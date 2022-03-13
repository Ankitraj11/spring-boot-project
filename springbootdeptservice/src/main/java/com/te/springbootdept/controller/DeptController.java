package com.te.springbootdept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springbootdept.beans.Dept;
import com.te.springbootdept.service.DeptService;

@RestController
@RequestMapping("/department")
public class DeptController {

	@Autowired
	private DeptService service;
	
  @GetMapping("/getDept/{deptId}")
   public ResponseEntity<?> getData(@PathVariable(name="deptId") int id){
	   
	   Dept dept=service.getDept(id);
	   if(dept!=null) {
		
		   return new ResponseEntity<Dept>(dept, HttpStatus.OK);
	   }
	   else {
		   return new ResponseEntity<String>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	   
	   
	   
   }
  
    @PostMapping("/addDept")
     public ResponseEntity<?> addData(@RequestBody Dept dept){
    	 
    	 try {
			service.addDept(dept);
			return new ResponseEntity<String>("data added successfuly", HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return new ResponseEntity<String>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		
			
		}
    	 
    	 
     }

}
