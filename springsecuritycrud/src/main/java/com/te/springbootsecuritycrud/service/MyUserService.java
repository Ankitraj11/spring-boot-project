package com.te.springbootsecuritycrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.te.springbootsecuritycrud.dao.UserDao;
import com.te.springbootsecuritycrud.dto.MyUserDetails;
import com.te.springbootsecuritycrud.dto.User;

@Service
public class MyUserService implements UserDetailsService {

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
	
	
	  public User getDetails(int id) {
		  
		  return dao.findByUserId(id);
	  }
	  
	  public List<User> seeAllDetails(){
		  
		  List<User> userList=(List<User>)dao.findAll();
		  return userList; 
	  }
	
       public boolean updateDetails(User user,int id) {
    	   
    	User user2=dao.findByUserId(id);
    	user2.setUserName(user.getUserName());
    	user2.setPassword(user.getPassword());
    	 User user3=dao.save(user2);
    	  if(user3!=null) {
    		  return true;
    	  }
    	  else {
    		  return false;
    	  }
       }
       
       public User addDetails(User user) {
    	   
    	   return dao.save(user);
       }
}
