package com.boraji.tutorial.springboot.service;

import com.boraji.tutorial.springboot.Entity.User;

public interface UserService extends GenericService<User> {

	User getByName(String name);

}
