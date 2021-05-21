package com.example.sporty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sporty.domain.User;
import com.example.sporty.repository.UserRepository;

@Service
public class Userservice {

	@Autowired
	private UserRepository rep;
	
	public void save(User users) {
		
		rep.save(users);
	}
	
	public User login(String email, String password) {
		

		return rep.findByUsernameAndPassword(email, password);
		
	}
	
}
