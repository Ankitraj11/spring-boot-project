package com.te.springbootsecuritycrud.dao;

import org.springframework.data.repository.CrudRepository;

import com.te.springbootsecuritycrud.dto.User;

public interface UserDao   extends CrudRepository<User, String>{

	public User findByUserName(String name);
	public User findByUserId(int id);
	
}
