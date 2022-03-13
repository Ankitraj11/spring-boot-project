package com.te.carwala.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.te.carwala.dto.AdminDetails;
import com.te.carwala.dto.CarDetails;

public interface AdminService  {

	AdminDetails  signupData(AdminDetails adminDetails);
	public List<CarDetails>  getAllCar();
    CarDetails addCar(CarDetails car,HttpServletRequest request);
	public void deleteCar(int carId);
	public CarDetails updateCar(CarDetails car,HttpServletRequest request,int id);
	public List<CarDetails> getCar(); 
	public List<CarDetails> getCarByName(String carname );
	public List<CarDetails> getCarByFuelType(String fuelType);
	public List<CarDetails> getCarByCompany(String company);

	
	
	
}
