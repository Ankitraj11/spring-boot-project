package com.te.carwala.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.carwala.dao.AdminDao;
import com.te.carwala.dao.CarDao;
import com.te.carwala.dto.AdminDetails;
import com.te.carwala.dto.CarDetails;
import com.te.carwala.utill.JwtUtill;

@ExtendWith(MockitoExtension.class)

class AdminServiceImplTest {

	@InjectMocks
	private AdminServiceImpl adminServiceImpl;

	@Mock
	private AdminDao adminDao;
	
	@Mock
	private CarDao carDao;
	
	@Mock
	private JwtUtill jwtUtill;
	
	
	private ObjectMapper objectMapper=new ObjectMapper();
	
	
	@Test
	void testGetAllCar() {
		//fail("Not yet implemented");
     List<CarDetails> carList=new ArrayList<>();
     CarDetails carDetails1=new CarDetails();
     carDetails1.setBreakSystem("ABS");
     carDetails1.setCarCompany("tata");
     carDetails1.setCarId(191);
     carDetails1.setCarName("verna");
     carDetails1.setEngineCapacity(220);
     carDetails1.setFuelType("petrol");
     carDetails1.setGearType("manual");
     carDetails1.setMileage(23);
     carDetails1.setPowerSteering(false);
     carDetails1.setOnRoadPrice(120000);
     carDetails1.setSeatingCapacity(4);
     carDetails1.setShowRoomPrice(130000);
     
     CarDetails carDetails2=new CarDetails();
     carDetails2.setBreakSystem("ABS");
     carDetails2.setCarCompany("tata");
     carDetails2.setCarId(191);
     carDetails2.setCarName("verna");
     carDetails2.setEngineCapacity(220);
     carDetails2.setFuelType("petrol");
     carDetails2.setGearType("manual");
     carDetails2.setMileage(23);
     carDetails2.setPowerSteering(false);
     carDetails2.setOnRoadPrice(120000);
     carDetails2.setSeatingCapacity(4);
     carDetails2.setShowRoomPrice(130000);
     
     carList.add(carDetails1);
     carList.add(carDetails2);
     
   when(carDao.findAll()).thenReturn(carList);
     
     List<CarDetails> carList3=adminServiceImpl.getAllCar();
     assertTrue(!carList3.isEmpty());
     
		
	}

	@Test
	void testAddCar() throws JsonProcessingException {
	//	fail("Not yet implemented");
		
//		CarDetails carDetails=new CarDetails();
//		carDetails.setCarId(10);
//		carDetails.setCarName("centro");
//		carDetails.setEngineCapacity(220);
//		
//		when(carDao.save(carDetails)).thenReturn(carDetails);
//		
//	    CarDetails carDetails2=adminServiceImpl.addCar(carDetails, null);
//	assertTrue(!carDetails.equals(null));
		                      
	}

	@Test
	void testDeleteCar() {
	//	fail("Not yet implemented");
	}

	@Test
	void testLoadUserByUsername() {
	//	fail("Not yet implemented");
	
	AdminDetails adminDetails=new AdminDetails();
	adminDetails.setAdminId(1);
	adminDetails.setAdminRole("ROLE_ADMIN");
	adminDetails.setUserName("user");
	when(adminDao.findByuserName("user")).thenReturn(adminDetails);
	UserDetails loadUserByUserName=adminServiceImpl.loadUserByUsername("user");
	assertEquals("user", loadUserByUserName.getUsername());
	
	
	}

	@Test
	void testSignupData() {
	//	fail("Not yet implemented");
		
		AdminDetails adminDetails=new AdminDetails();
		adminDetails.setAdminId(107);
		adminDetails.setAdminRole("ROLE_ADMIN");
		adminDetails.setUserName("chandra");
		adminDetails.setPassword("chandra");
		when(adminDao.save(adminDetails)).thenReturn(adminDetails);
		AdminDetails adminDetails2=adminServiceImpl.signupData(adminDetails);
		assertEquals("chandra", adminDetails2.getUserName());
	}

	@Test
	void testGetCar() {
		fail("Not yet implemented");
		List<CarDetails> carList=new ArrayList<>();
		CarDetails carDetails=new CarDetails();
		carDetails.setCarId(201);
		carDetails.setCarCompany("hyundai");
		carDetails.setBreakSystem("ABS");
		carList.add(carDetails);
		
		when(carDao.findAll()).thenReturn(carList);
		List<CarDetails> carList2=adminServiceImpl.getCar();
		//assertEquals("hyundai", carList2.get(0).getCarCompany());
		assertTrue(!carList2.isEmpty());
	}

	@Test
	void testUpdateCar() {
//		fail("Not yet implemented");
	
		
		
		
	}

	@Test
	void testGetCarByName() {
	//	fail("Not yet implemented");
	
		List<CarDetails> detailList=new ArrayList<CarDetails>();
		CarDetails details=new CarDetails();
		details.setCarCompany("tata");
		details.setCarName("verna");
		details.setEngineCapacity(220);
		detailList.add(details);
		
	
		when(carDao.findBycarName("verna")).thenReturn(detailList);
		List<CarDetails> deList=adminServiceImpl.getCarByName("verna");
		assertEquals("verna",deList.get(0).getCarName());
		
	}

	@Test
	void testGetCarByFuelType() {
	//	fail("Not yet implemented");
	
	  List<CarDetails> carList=new ArrayList<CarDetails>();
	  CarDetails details=new CarDetails();
	  details.setCarId(102);
	  details.setFuelType("petrol");
     details.setEngineCapacity(229);
     details.setMileage(12);
     carList.add(details);
           when(carDao.findByfuelType("petrol")).thenReturn(carList);
           List<CarDetails> details2=adminServiceImpl.getCarByFuelType("petrol");
           assertEquals(229, carList.get(0).getEngineCapacity());
     
	}

	@Test
	void testGetCarByCompany() {
		//fail("Not yet implemented");
		
		
		  List<CarDetails> carList=new ArrayList<CarDetails>();
		  CarDetails details=new CarDetails();
		  details.setCarId(102);
		  details.setCarCompany("tata");
	     details.setEngineCapacity(229);
	     details.setMileage(12);
	     carList.add(details);
	           when(carDao.findBycarCompany("tata")).thenReturn(carList);
	           
	           List<CarDetails> details2=adminServiceImpl.getCarByCompany("tata");
	           assertEquals("tata" ,carList.get(0).getCarCompany());
		
	}

}
