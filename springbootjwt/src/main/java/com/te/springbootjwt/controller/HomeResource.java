package com.te.springbootjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springbootjwt.modal.AuthenticateRequest;
import com.te.springbootjwt.modal.AuthenticateResponse;
import com.te.springbootjwt.utill.JwtUtil;



@RestController
public class HomeResource {
    @Autowired
	private JwtUtil jwtutils;
	
   
    @Autowired
	private UserDetailsService usedetailsService;
	@Autowired
private AuthenticationManager authiAuthenticationManager;
	
	@GetMapping("/home")
	public String home() {
		return "laern spring jwt";
	}
	
	@PostMapping("/aunthenticate")
	public ResponseEntity<?> createAuthenicationToken(@RequestBody AuthenticateRequest authenticateRequest)
		throws Exception{
			
			try {
				authiAuthenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateRequest.getUsername(),authenticateRequest.getPassword()));
			}catch(Exception e) {
				throw new Exception("invald username an password"+e);
				
			}
			UserDetails userDetails=usedetailsService.loadUserByUsername(authenticateRequest.getUsername());
			String jwt=jwtutils.generateToken(userDetails);
			return ResponseEntity.ok(new AuthenticateResponse(jwt));
		}
		
	}
	

