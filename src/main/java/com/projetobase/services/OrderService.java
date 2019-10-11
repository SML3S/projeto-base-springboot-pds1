package com.projetobase.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetobase.dto.OrderDTO;
import com.projetobase.dto.OrderItemDTO;
import com.projetobase.entities.Order;
import com.projetobase.entities.OrderItem;
import com.projetobase.entities.Product;
import com.projetobase.entities.User;
import com.projetobase.entities.enums.OrderStatus;
import com.projetobase.repositories.OrderItemRepository;
import com.projetobase.repositories.OrderRepository;
import com.projetobase.repositories.ProductRepository;
import com.projetobase.repositories.UserRepository;
import com.projetobase.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private AuthService authService;
	
	public List<OrderDTO> findAll() {

		List<Order>list = repository.findAll();
		return list.stream().map(e -> new OrderDTO(e)).collect(Collectors.toList());
	}

	public OrderDTO findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		Order entity= obj.orElseThrow(()-> new ResourceNotFoundException(id));
		authService.validateOwnOrderOrAdmin(entity);
		return new OrderDTO(entity);
	}

	public List<OrderDTO> findByClient(){
		User client = authService.authenticated();
		List<Order> list = repository.findByClient(client);
		return list.stream().map(e -> new OrderDTO(e)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<OrderItemDTO> findItems(Long id) {
		Order order = repository.getOne(id);
		authService.validateOwnOrderOrAdmin(order);
		Set<OrderItem> set = order.getItem();
		return set.stream().map(e -> new OrderItemDTO(e)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<OrderDTO> findByClientId(Long clientId) {
		User client = userRepository.getOne(clientId);
		List<Order> list = repository.findByClient(client);
		return list.stream().map(e -> new OrderDTO(e)).collect(Collectors.toList());
	}

	@Transactional
	public OrderDTO placeOrder(List<OrderItemDTO> dto) {
		
		User client = authService.authenticated();
		Order order = new Order(null, Instant.now(), OrderStatus.WAITING_PAYMENT, client);
		
		for(OrderItemDTO itemDTO : dto) {
			Product product = productRepository.getOne(itemDTO.getProductId());
			OrderItem item = new OrderItem(order, product, itemDTO.getQuantity(), itemDTO.getPrice() );
			order.getItem().add(item);
		}
		
		repository.save(order);
		orderItemRepository.saveAll(order.getItem());
	return new OrderDTO(order);
	}
}
