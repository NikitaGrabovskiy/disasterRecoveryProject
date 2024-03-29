package com.boraji.tutorial.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boraji.tutorial.springboot.Entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

	List<Job> findAll();
}
