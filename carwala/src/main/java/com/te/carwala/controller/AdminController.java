package com.te.carwala.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.carwala.dao.AdminDao;
import com.te.carwala.dao.CarDao;
import com.te.carwala.dto.AdminDetails;
import com.te.carwala.dto.CarDetails;
import com.te.carwala.modal.AuthenticateRequest;
import com.te.carwala.modal.AuthenticateResponse;
import com.te.carwala.modal.CarResponse;
import com.te.carwala.modal.UserResponse;
import com.te.carwala.service.AdminService;
import com.te.carwala.utill.JwtUtill;

@RestController
@RequestMapping(path="/admin")
@CrossOrigin(origins = "*")
public class AdminController {

      @Autowired	
	  private AdminDao adminDao;
      @Autowired
      private CarDao carDao;
	@Autowired
	private AdminService adminService;
	@Autowired
	private AuthenticationManager authenticationManager;

   @Autowired
	private JwtUtill jwtUtil;

	@Autowired
	private UserDetailsService userDetailsService;
	

	@GetMapping("/getcarDetails")
	public ResponseEntity<?> getCarForAdmin() {
		List<CarDetails> carList = adminService.getAllCar();
		if (carList != null) {
			return ResponseEntity.ok(new CarResponse(carList, null, false));
		} else {
			return ResponseEntity.ok(new CarResponse(null, "something went wrong", true));
		}

	}
	@PostMapping("/addCar")
	public ResponseEntity<?> addCarDetails(@RequestBody CarDetails carDetails, HttpServletRequest request) {
          
		try {
			adminService.addCar(carDetails, request);
			return ResponseEntity.ok(new CarResponse(null, "car added successfully", false));
			
		} catch (Exception e) {
		 return ResponseEntity.ok(new CarResponse(null, "something went wrong", true));
		}
		

	}

	

	

	

	@DeleteMapping("/deleteCar/{carId}")
	public ResponseEntity<?> deleteCar( @PathVariable int carId) {
		try {
			adminService.deleteCar(carId);
			return ResponseEntity.ok(new CarResponse(null, "car deleted successfully", false));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.ok(new CarResponse(null, "something went wrong", true));
		}
	}

	@PutMapping("/updateCar/{carId}")
	public ResponseEntity<?> updateCar(@RequestBody CarDetails car, @PathVariable int carId,HttpServletRequest request) {
		try {
			adminService.updateCar(car,request ,carId);
			return ResponseEntity.ok(new CarResponse(null, "car updated successfully", false));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.ok(new CarResponse(null, "something went wrong", true));
		}
	}

	@PostMapping("/loggedIn")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticateRequest authenticateRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticateRequest.getUsername(), authenticateRequest.getPassword()));
		} catch (Exception e) {
			return ResponseEntity.ok(new UserResponse("inavlad credentical", true, null, null));
		}
		UserDetails userDetails = userDetailsService.loadUserByUsername(authenticateRequest.getUsername());
		String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new UserResponse("authenticaotin success", false, jwt, userDetails.getAuthorities()));
	}

	@PostMapping("/signUp")
	public ResponseEntity<?> signUp(@RequestBody AdminDetails adminDetails) {

		AdminDetails signUpData =adminService.signupData(adminDetails);
		if (signUpData != null) {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(signUpData.getUserName(), signUpData.getPassword()));
			UserDetails userDetails = userDetailsService.loadUserByUsername(signUpData.getUserName());
			String jwt = jwtUtil.generateToken(userDetails);
			return ResponseEntity.ok(new UserResponse("registtration success", false, jwt,null));

		} else {
			return ResponseEntity.ok(new UserResponse( "user already exist", true, null,null));
		}

	}
	
	

}
