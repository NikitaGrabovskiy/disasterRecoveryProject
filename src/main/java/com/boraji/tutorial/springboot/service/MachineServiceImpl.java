package com.boraji.tutorial.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boraji.tutorial.springboot.Entity.Machine;
import com.boraji.tutorial.springboot.repository.MachineRepository;


@Service("MachineService")
public class MachineServiceImpl implements MachineService {
	
	@Autowired
	MachineRepository repository;
	
	@Override
	public void save(Machine entity) {
		repository.saveAndFlush(entity);
	}

	@Override
	public List<Machine> getAll() {
		return repository.findAll();
	}

	@Override
	public Machine findById(long id) {
		return repository.findOne(id);
	}

	@Override
	public void delete(Machine entity) {
		repository.delete(entity);
	}

}
