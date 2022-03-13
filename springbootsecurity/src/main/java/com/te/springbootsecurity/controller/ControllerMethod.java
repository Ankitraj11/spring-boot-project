package com.te.springbootsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerMethod {

	@GetMapping("/welcome")
	public String login() {
		
		return "<h1>welcome all <h1>";
				
	}
	@GetMapping("/user")
	public String user() {
	
	  return "<h1>welcome user</h1>";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "<h1> welcome admin</h1>";
	}
	
}
