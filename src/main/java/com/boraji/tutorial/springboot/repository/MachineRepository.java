package com.boraji.tutorial.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boraji.tutorial.springboot.Entity.Machine;

public interface MachineRepository extends JpaRepository<Machine, Long> {
	
	   List<Machine> findAll();
	   
}
