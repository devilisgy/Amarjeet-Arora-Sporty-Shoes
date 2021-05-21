package com.example.sporty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sporty.domain.Shoes;
import com.example.sporty.repository.ShoesRepository;

@Service

public class ShoesService {
	@Autowired
	private ShoesRepository repo;
	 public List<Shoes> listAll()
	 {
		 return repo.findAll();
		 
	 }
	 public void save(Shoes std)
	 {
		 repo.save(std);
	 }
	 public Shoes get(int id)
	 {
		 return repo.findById((long) id).get();
		 
	 }
		public void delete(long id) {
			repo.deleteById(id);
		}
	
	

}
