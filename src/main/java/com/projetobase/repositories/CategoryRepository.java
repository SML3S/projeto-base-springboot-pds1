package com.projetobase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetobase.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
