package com.projetobase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetobase.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
