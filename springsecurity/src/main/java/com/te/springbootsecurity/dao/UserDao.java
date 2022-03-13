package com.te.springbootsecurity.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.te.springbootsecurity.dto.User;


public interface UserDao extends CrudRepository<User, String>{

	
	public User findByUserName(String  name);

	
	
	
	
	
}
