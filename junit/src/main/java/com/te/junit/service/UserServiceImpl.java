package com.te.junit.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.junit.dto.UserDto;
import com.te.junit.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDto adduser(UserDto user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

}
