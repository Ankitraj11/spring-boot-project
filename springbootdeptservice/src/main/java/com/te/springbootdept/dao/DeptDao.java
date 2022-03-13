package com.te.springbootdept.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.te.springbootdept.beans.Dept;


public interface DeptDao extends CrudRepository<Dept, Integer> {

	           public Dept findByDeptId(int id);

	
	
}
