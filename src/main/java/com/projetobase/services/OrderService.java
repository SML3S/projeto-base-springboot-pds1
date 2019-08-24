package com.projetobase.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetobase.entities.Order;
import com.projetobase.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repositoty;
	
	public List<Order> findAll(){
		
		return repositoty.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repositoty.findById(id);
		return obj.get();
	}
}
