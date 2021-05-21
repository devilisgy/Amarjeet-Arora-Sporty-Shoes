package com.example.sporty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sporty.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
User findByUsernameAndPassword(String username,String password);
	
	
}
