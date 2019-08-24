package com.projetobase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetobase.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
