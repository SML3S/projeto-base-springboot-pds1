package com.projetobase.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetobase.entities.Order;
import com.projetobase.entities.User;

public interface OrderRepository extends JpaRepository<Order, Long>{

	List<Order> findByClient(User client);
}
