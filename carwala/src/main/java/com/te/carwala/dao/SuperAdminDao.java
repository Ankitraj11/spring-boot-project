package com.te.carwala.dao;

import org.springframework.data.repository.CrudRepository;

import com.te.carwala.dto.AdminDetails;

public interface SuperAdminDao extends CrudRepository<AdminDetails, Integer> {

	public AdminDetails findByuserName(String username);
}
