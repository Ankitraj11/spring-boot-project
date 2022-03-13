package com.te.carwala.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.te.carwala.dto.CarDetails;

public interface CarDao extends CrudRepository<CarDetails, Integer> {

	public CarDetails findBycarId(int id);
	public List<CarDetails> findBycarName(String carName);
	public List<CarDetails> findByfuelType(String fuelType);
	public List<CarDetails> findBycarCompany(String company);

}
