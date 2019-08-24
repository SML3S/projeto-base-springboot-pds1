package com.projetobase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetobase.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
