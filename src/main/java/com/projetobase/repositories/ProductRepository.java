package com.projetobase.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.projetobase.entities.Category;
import com.projetobase.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Product obj INNER JOIN obj.categories cats WHERE :category IN cats")
	Page<Product> findByCAtegory(Category category, Pageable pageable);
}
