package com.te.springbootuser.dao;


import org.springframework.data.repository.CrudRepository;

import com.te.springbootuser.beans.User;

public interface UserDao extends CrudRepository<User, Integer> {

	
	   public User findByUserId(int id);
	
}
