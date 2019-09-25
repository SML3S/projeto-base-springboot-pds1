package com.projetobase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetobase.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
	
}
