package com.projetobase.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetobase.entities.User;
import com.projetobase.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repositoty;
	
	public List<User> findAll(){
		
		return repositoty.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repositoty.findById(id);
		return obj.get();
	}
}
