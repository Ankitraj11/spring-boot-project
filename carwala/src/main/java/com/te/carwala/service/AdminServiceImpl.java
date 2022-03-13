package com.te.carwala.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.te.carwala.dao.AdminDao;
import com.te.carwala.dao.CarDao;
import com.te.carwala.dto.AdminDetails;
import com.te.carwala.dto.CarDetails;
import com.te.carwala.dto.MyAdminDetails;
import com.te.carwala.utill.JwtUtill;
@Service
public class AdminServiceImpl implements AdminService,UserDetailsService {

	@Autowired
	private CarDao dao;
	
	
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private JwtUtill util;
	@Override
	public List<CarDetails> getAllCar() {
		// TODO Auto-generated method stub
		List<CarDetails> carDetails=(List<CarDetails>)dao.findAll();
		return carDetails;
	}
	@Override
	public CarDetails addCar(CarDetails car, HttpServletRequest request) {
		// TODO Auto-generated method stub
		String tokenHeader = request.getHeader("Authorization");
		String token = tokenHeader.substring(7);
		String adminName = util.extractUsername(token);
		AdminDetails adminDetails = adminDao.findByuserName(adminName);
		double showroomPrice=(double) (car.getShowRoomPrice()*100000);
		double onRoadPrice=0;
		
		car.setShowRoomPrice(showroomPrice);
		
		if(car.getFuelType().equals("Electric")) {
			onRoadPrice=(double) car.getShowRoomPrice()*1.04;
		}
		
		else if(car.getShowRoomPrice()<500000) {
			onRoadPrice=(double)car.getShowRoomPrice()*1.13;
			
		}
		else if(car.getShowRoomPrice()>500000 && car.getShowRoomPrice()<1000000) {
			onRoadPrice= (double) car.getShowRoomPrice()*1.14;
		}
		else if(car.getShowRoomPrice()>1000000 && car.getShowRoomPrice()<2000000) {
			onRoadPrice=(double) car.getShowRoomPrice()*1.17;
		}
		else if(car.getShowRoomPrice()>2000000) {
			onRoadPrice=(double)car.getShowRoomPrice()*1.18;
		}
		
		
		car.setOnRoadPrice(onRoadPrice);
		car.setAdminDetails(adminDetails);
		return dao.save(car);
	}
		
	
	

	
	@Override
	public void deleteCar(int id) {
		// TODO Auto-generated method stub
		CarDetails car=dao.findBycarId(id);
		  dao.delete(car);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		AdminDetails adminDetails=adminDao.findByuserName(username);
		if(adminDetails!=null) {
			return new MyAdminDetails(adminDetails);
		}
		else {
			throw new UsernameNotFoundException("username not found");
		}
		
		
	
	}
	@Override
	public AdminDetails signupData(AdminDetails adminDetails) {
		// TODO Auto-generated method stub
		return adminDao.save(adminDetails);
	}
	@Override
	public List<CarDetails> getCar() {
		// TODO Auto-generated method stub
		List<CarDetails> carList=(List<CarDetails>)dao.findAll();
		
		return carList;
	}
	

	@Override
	public CarDetails updateCar(CarDetails car, HttpServletRequest request,int id) {
		// TODO Auto-generated method stub
		String tokenHeader = request.getHeader("Authorization");
		String token = tokenHeader.substring(7);
		String adminName = util.extractUsername(token);
		AdminDetails adminDetails = adminDao.findByuserName(adminName);
		double showroomPrice=(double) car.getShowRoomPrice()*100000;
		double onRoadPrice=0;
		
		car.setShowRoomPrice(showroomPrice);
		
		if(car.getFuelType().equals("Electric")) {
			onRoadPrice=(double)car.getShowRoomPrice()*1.04;
		}
		
		else if(car.getShowRoomPrice()<500000) {
			onRoadPrice=(double) car.getShowRoomPrice()*1.13;
			
		}
		else if(car.getShowRoomPrice()>500000 && car.getShowRoomPrice()<1000000) {
			onRoadPrice= (double) car.getShowRoomPrice()*1.14;
		}
		else if(car.getShowRoomPrice()>1000000 && car.getShowRoomPrice()<2000000) {
			onRoadPrice=(double) car.getShowRoomPrice()*1.17;
		}
		else if(car.getShowRoomPrice()>2000000) {
			onRoadPrice=(double) car.getShowRoomPrice()*1.18;
		}
		
		car.setCarId(id);
		car.setOnRoadPrice(onRoadPrice);
		car.setAdminDetails(adminDetails);
		return dao.save(car);
	}
	@Override
	public List<CarDetails> getCarByName(String carname) {
		// TODO Auto-generated method stub
		return (List<CarDetails>)dao.findBycarName(carname);
	}
	@Override
	public List<CarDetails> getCarByFuelType(String fuelType) {
		// TODO Auto-generated method stub
		return (List<CarDetails>)dao.findByfuelType(fuelType);
		}
	@Override
	public List<CarDetails> getCarByCompany(String company) {
		// TODO Auto-generated method stub
		return (List<CarDetails>)dao.findBycarCompany(company);
	}
	
	
	
	
	 



}
