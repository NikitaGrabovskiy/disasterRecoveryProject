package com.boraji.tutorial.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.tutorial.springboot.Entity.Job;
import com.boraji.tutorial.springboot.repository.JobRepository;



@Service("JobService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class JobServiceImpl implements JobService {
	
	@Autowired
	JobRepository repository;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void save(Job entity) {
		repository.saveAndFlush(entity);
	}

	@Override
	public List<Job> getAll() {
		return repository.findAll();
	}

	@Override
	public Job findById(long id) {
		return repository.findOne(id);
	}

	@Override
	public void delete(Job entity) {
		repository.delete(entity);
	}

}
