package com.te.junit.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.te.junit.dto.UserDto;
import com.te.junit.response.UserResponse;
import com.te.junit.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(UserDto user){
		
		UserDto userDto=userService.adduser(user);
		if(userDto!=null) {
			return ResponseEntity.ok(new UserResponse("user added successfully",false));
		}
		return ResponseEntity.ok(new UserResponse("something went wrong", true));
	}
}
