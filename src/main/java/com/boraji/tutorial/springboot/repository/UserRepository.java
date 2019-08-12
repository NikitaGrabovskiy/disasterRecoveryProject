package com.boraji.tutorial.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boraji.tutorial.springboot.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	   List<User> findAll();
	   
	   User findByName(String name);
	
}
