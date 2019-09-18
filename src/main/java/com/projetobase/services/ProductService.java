package com.projetobase.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetobase.dto.ProductDTO;
import com.projetobase.dto.UserDTO;
import com.projetobase.entities.Product;
import com.projetobase.repositories.ProductRepository;
import com.projetobase.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repositoty;
	
	public List<ProductDTO> findAll(){
		
		List<Product> list = repositoty.findAll();
		return list.stream().map(e -> new ProductDTO(e)).collect(Collectors.toList());
	}
	
	public ProductDTO findById(Long id) {
		Optional<Product> obj = repositoty.findById(id);
		Product entity= obj.orElseThrow(()-> new ResourceNotFoundException(id));
		return new ProductDTO(entity);
	}
}
