package com.te.springbootuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springbootuser.beans.User;
import com.te.springbootuser.pojo.ResponseTemplateVO;
import com.te.springbootuser.userservice.UserService;

@RestController
public class UserController {

    @Autowired
	private UserService service;
	
    @GetMapping("/getUser/{id}")
	public ResponseEntity<?> getData(@PathVariable int id){
		
		try {
			User user=service.getUser(id);
			return new ResponseEntity<User>(user,HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user ){
    	try {
			service.addUser(user);
			return new ResponseEntity<String>("user added successfully",HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	
    	
    }
    @GetMapping("/userDept/{id}")
    public ResponseTemplateVO getUserDept(@PathVariable int id) {
    	ResponseTemplateVO responseTemplateVO=service.getUserDept(id);
    	if(responseTemplateVO!=null) {
    		return responseTemplateVO;
    	}
    	else {
    		return null;
    	}
    }
	
}
