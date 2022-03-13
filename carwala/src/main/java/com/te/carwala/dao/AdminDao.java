package com.te.carwala.dao;

import org.springframework.data.repository.CrudRepository;

import com.te.carwala.dto.AdminDetails;




public interface AdminDao extends CrudRepository<AdminDetails, String> {

    public AdminDetails findByuserName(String username);
    
	
    
}
