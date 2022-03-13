package com.te.springbootsecurity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.te.springbootsecurity.dao.UserDao;
import com.te.springbootsecurity.dto.MyUserDetails;
import com.te.springbootsecurity.dto.User;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
	private UserDao dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		
		User user=dao.findByUserName(username);
		if(user!=null) {
			return new MyUserDetails(user);
		}
		throw new UsernameNotFoundException("user not found");
	}

}
