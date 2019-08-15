package com.boraji.tutorial.springboot.service;

import java.util.List;

public interface GenericService<T> {

	public void save(T entity);

	public List<T> getAll();

	public T findById(long id);

	public void delete(T entity);
}
