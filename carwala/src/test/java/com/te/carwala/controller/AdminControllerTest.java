package com.te.carwala.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.conf.PropertyDefinitions.AuthMech;
import com.te.carwala.dto.AdminDetails;
import com.te.carwala.dto.CarDetails;
import com.te.carwala.dto.MyAdminDetails;
import com.te.carwala.modal.AuthenticateRequest;
import com.te.carwala.modal.CarResponse;
import com.te.carwala.service.AdminService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class AdminControllerTest {

	@MockBean
	private AuthenticationManager authenticationManager;
	
	@MockBean
	private AdminService adminService;

	@MockBean
	private UserDetailsService userDetailsService;;
	
	private MockMvc mockMvc;
	


	@Autowired
	private WebApplicationContext applicationContext;

	private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
	}

	@Test
	void testGetCarForAdmin() throws JsonProcessingException, UnsupportedEncodingException, Exception {
		//fail("Not yet implemented");
	
		List<CarDetails> list=new ArrayList<CarDetails>();
		CarDetails carDetails1=new CarDetails();
		carDetails1.setCarId(103);
		carDetails1.setCarCompany("hyundai");
		carDetails1.setCarName("eilitei20");
		CarDetails carDetails2=new CarDetails();
		carDetails2.setCarId(103);
		carDetails2.setCarCompany("hyundai");
		carDetails2.setCarName("eilitei20");
		list.add(carDetails2);
		when(adminService.getAllCar()).thenReturn(list);
		
		String contentAsString=mockMvc.perform(get("/admin/getcarDetails")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(list))
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andReturn()
				.getResponse()
				.getContentAsString();
		
		CarResponse carResponse=objectMapper.readValue(contentAsString, CarResponse.class);
		assertTrue(!carResponse.getCarlist().isEmpty());

				
	
	}

	@Test
	void testAddCarDetails() throws JsonProcessingException, UnsupportedEncodingException, Exception {
	//fail("Not yet implemented");
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.getHeader("Authorization");
		CarDetails carDetails = new CarDetails();
		carDetails.setCarId(102);
		carDetails.setCarCompany("hundai");
		carDetails.setCarName("elitei20");
		carDetails.setEngineCapacity(220);
		carDetails.setBreakSystem("ABS");

		when(adminService.addCar(carDetails, request)).thenReturn(carDetails);

		String contentAsString = mockMvc
				.perform(post("/admin/addCar").contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(objectMapper.writeValueAsString(carDetails)).accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		CarResponse readValue = objectMapper.readValue(contentAsString, CarResponse.class);

		assertEquals("car added successfully", readValue.getMsg());

	}

	@Test
	void testDeleteCar() throws JsonProcessingException,UnsupportedEncodingException,Exception {
//		fail("Not yet implemented");
      
      CarDetails carDetails=new CarDetails();
      carDetails.setCarId(102);
      carDetails.setCarName("nexus");
      carDetails.setEngineCapacity(220);
      carDetails.setFuelType("petrol");
      
   
        
      String contentAsString=mockMvc.perform(delete("/admin/deleteCar")
    		  .contentType(MediaType.APPLICATION_JSON_VALUE)
    		  .content(objectMapper.writeValueAsString(carDetails))
    		  .accept(MediaType.APPLICATION_JSON_VALUE))
    		  .andExpect(status().isOk())
    		  .andReturn()
    		  .getResponse()
    		  .getContentAsString();
		
		
		CarResponse carResponse=objectMapper.readValue(contentAsString, CarResponse.class);
		assertEquals("car deleted successfully",carResponse.getMsg());
		
	}

	@Test
	void testUpdateCar() throws JsonProcessingException,UnsupportedEncodingException,Exception {
	//	fail("Not yet implemented");
		MockHttpServletRequest request=new MockHttpServletRequest();
		request.addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbmtpdCIsImV4cCI6MTY0NjcxMjQ3MiwiaWF0IjoxNjQ2Njc2NDcyfQ.XpSEJjjoNW0jfBkSk90enwHjUT4oWdXYUxbEVCT6Dl0 ");
		CarDetails carDetails = new CarDetails();
		
		carDetails.setCarCompany("hundai");
		carDetails.setCarName("elitei23");
		carDetails.setEngineCapacity(220);
		carDetails.setBreakSystem("manual");
		carDetails.setCarId(102);
		when(adminService.updateCar(carDetails, request,102)).thenReturn(carDetails);
		
		String contentAsString=mockMvc.perform(put("/admin/updateCar/102").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(carDetails)).accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
				
		CarResponse carResponse=objectMapper.readValue(contentAsString, CarResponse.class);
		assertEquals("car updated successfully", carResponse.getMsg());
		
	}

	@Test
	void testCreateAuthenticationToken() throws JsonProcessingException ,UnsupportedEncodingException,Exception {
		//fail("Not yet implemented");
	
     
     
     
	
	     
	
	}

	@Test
	void testSignUp() {
		fail("Not yet implemented");
	}

}
