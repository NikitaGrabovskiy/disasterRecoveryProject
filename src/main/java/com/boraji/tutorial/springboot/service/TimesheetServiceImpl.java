package com.boraji.tutorial.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boraji.tutorial.springboot.Entity.Timesheet;
import com.boraji.tutorial.springboot.repository.TimesheetRepository;

@Service("TimesheetService")
public class TimesheetServiceImpl implements TimesheetService {
	
	@Autowired
	TimesheetRepository repository;
	
	@Override
	public void save(Timesheet entity) {
		repository.saveAndFlush(entity);
	}

	@Override
	public List<Timesheet> getAll() {
		return repository.findAll();
	}

	@Override
	public Timesheet findById(long id) {
		return repository.findOne(id);
	}

	@Override
	public void delete(Timesheet entity) {
		repository.delete(entity);
	}

}
