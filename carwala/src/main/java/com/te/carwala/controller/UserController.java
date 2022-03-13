package com.te.carwala.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.carwala.dto.CarDetails;
import com.te.carwala.modal.CarResponse;
import com.te.carwala.modal.UserCarResponse;
import com.te.carwala.service.AdminService;

@RestController
@RequestMapping(path="/user")
@CrossOrigin(origins = "*")
public class UserController {

	      @Autowired
	     private AdminService adminService; 
	      
	       @GetMapping("/getCarByName/{carname}")
      public ResponseEntity<?> getCarByName(@PathVariable String carname){
	    	   
	          List<CarDetails> details=adminService.getCarByName(carname);
	           if(details!=null) {
	           return ResponseEntity.ok(new UserCarResponse(details,false));
	          }
	           else {
	        	   return ResponseEntity.ok(new UserCarResponse(null,true));
	           }
	       }
	
	
	
	
	       @GetMapping("/getCarByfuelType/{fuelType}")
	       public ResponseEntity<?> getCarByCompanyName(@PathVariable String fuelType){
	    	   List<CarDetails> carDetails=adminService.getCarByFuelType(fuelType);
	    	   if(carDetails!=null) {
	    		   return ResponseEntity.ok(new UserCarResponse(carDetails, false));
	    	   }
	    	   else {
	    		   return ResponseEntity.ok(new UserCarResponse(null, true));
	    	   }
	    	   
	    	   
	       }
	       
	       @GetMapping("/getCarByCompany/{company}")
      public ResponseEntity<?> getCarByCompany(@PathVariable String company){
	    	   
	          List<CarDetails> details=adminService.getCarByCompany(company);
	           if(details!=null) {
	           return ResponseEntity.ok(new UserCarResponse(details,false));
	          }
	           else {
	        	   return ResponseEntity.ok(new UserCarResponse(null,true));
	           }
	       }
	       }
