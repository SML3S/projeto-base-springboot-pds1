package com.projetobase.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetobase.entities.Category;
import com.projetobase.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repositoty;

	public List<Category> findAll() {

		return repositoty.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> obj = repositoty.findById(id);
		return obj.get();
	}
}
