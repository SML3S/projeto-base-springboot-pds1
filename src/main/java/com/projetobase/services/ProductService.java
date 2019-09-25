package com.projetobase.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetobase.dto.CategoryDTO;
import com.projetobase.dto.ProductCategoriesDTO;
import com.projetobase.dto.ProductDTO;
import com.projetobase.entities.Category;
import com.projetobase.entities.Product;
import com.projetobase.repositories.CategoryRepository;
import com.projetobase.repositories.ProductRepository;
import com.projetobase.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private CategoryRepository  CategoryRepository;
	
	public List<ProductDTO> findAll(){
		
		List<Product> list = repository.findAll();
		return list.stream().map(e -> new ProductDTO(e)).collect(Collectors.toList());
	}
	
	public ProductDTO findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		Product entity= obj.orElseThrow(()-> new ResourceNotFoundException(id));
		return new ProductDTO(entity);
	}
	
	@Transactional 
	public ProductDTO insert(ProductCategoriesDTO dto) {
		Product entity =  dto.toEntity();
		setProductCategories(entity, dto.getCategories());
		entity = repository.save(entity);
		return new ProductDTO(entity);
	}

	private void setProductCategories(Product entity, List<CategoryDTO> categories) {
		entity.getCategories().clear();
		for (CategoryDTO dto : categories){
			Category category = CategoryRepository.getOne(dto.getId());
			entity.getCategories().add(category);
		}
	}
}
