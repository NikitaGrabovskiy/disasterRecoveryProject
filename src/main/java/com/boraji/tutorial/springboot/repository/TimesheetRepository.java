package com.boraji.tutorial.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boraji.tutorial.springboot.Entity.Timesheet;

public interface TimesheetRepository extends JpaRepository<Timesheet, Long>  {

	   List<Timesheet> findAll();
	
}
