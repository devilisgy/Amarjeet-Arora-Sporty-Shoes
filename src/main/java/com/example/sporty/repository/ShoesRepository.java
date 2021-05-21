package com.example.sporty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sporty.domain.Shoes;


@Repository
public interface ShoesRepository extends JpaRepository<Shoes, Long> {

}