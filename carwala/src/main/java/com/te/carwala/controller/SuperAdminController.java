package com.te.carwala.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.carwala.dto.AdminDetails;
import com.te.carwala.dto.CarDetails;
import com.te.carwala.filter.JwtRequestFilter;
import com.te.carwala.modal.AuthenticateRequest;
import com.te.carwala.modal.CarResponse;
import com.te.carwala.modal.UserResponse;
import com.te.carwala.service.AdminService;
import com.te.carwala.utill.JwtUtill;

@RestController
@RequestMapping(path="/superAdmin")
@CrossOrigin(origins = "*")
public class SuperAdminController {
    
	@Autowired
	private JwtUtill jwtUtil;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
    private AdminService service;
	
	
	
	@PostMapping("/signUp")
	public ResponseEntity<?> superAdminsignUp(@RequestBody AdminDetails adminDetails){
		
			AdminDetails superAdminDetails=service.signupData(adminDetails);
			if(superAdminDetails!=null) {
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(superAdminDetails.getUserName(),superAdminDetails.getPassword()));
				UserDetails userDetails=userDetailsService.loadUserByUsername(superAdminDetails.getUserName());
				String token=jwtUtil.generateToken(userDetails);
			
			return ResponseEntity.ok(new UserResponse("authentication successful",false,token,null));
			}else {
			
			// TODO Auto-generated catch block
		
			return ResponseEntity.ok(new UserResponse("user already exist", true, null, null));
		}
	
		}
	
	@PostMapping("/logIn")
	public ResponseEntity<?> superAdminLogIn(@RequestBody AuthenticateRequest authenticateRequest){
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateRequest.getUsername(), authenticateRequest.getPassword()));
		    
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return  ResponseEntity.ok(new UserResponse("invalid credential", true, null, null));
		}
		   UserDetails userDetails=userDetailsService.loadUserByUsername(authenticateRequest.getUsername());
		   String token =jwtUtil.generateToken(userDetails);
		   return ResponseEntity.ok(new UserResponse("logged in successful", false, token, null));
		   
			
		}
		@GetMapping("/getAllCar")
		public ResponseEntity<?> getAllCarWithAdmin(){
			
			try {
			List<CarDetails> carList=service.getAllCar();
				return ResponseEntity.ok(new CarResponse(carList,null,false));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return ResponseEntity.ok(new CarResponse(null, "somethign went wrong", true));
			}
		}
		
		
	}
	

