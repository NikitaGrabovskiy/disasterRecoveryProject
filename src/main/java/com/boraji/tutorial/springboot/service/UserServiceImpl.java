package com.boraji.tutorial.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boraji.tutorial.springboot.Entity.User;
import com.boraji.tutorial.springboot.repository.UserRepository;

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	@Override
	public void save(User entity) {
		repository.saveAndFlush(entity);
	}

	@Override
	public List<User> getAll() {
		return repository.findAll();
	}

	@Override
	public User findById(long id) {
		return repository.findOne(id);
	}

	@Override
	public void delete(User entity) {
		repository.delete(entity);
	}

	@Override
	public User getByName(String name) {
		return repository.findByName(name);
	}

}
