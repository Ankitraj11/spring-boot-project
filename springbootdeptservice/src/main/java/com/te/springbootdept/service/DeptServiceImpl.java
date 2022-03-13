package com.te.springbootdept.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springbootdept.beans.Dept;
import com.te.springbootdept.dao.DeptDao;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptDao dao;

	@Override
	public Dept getDept(int id) {
		// TODO Auto-generated method stub

		return dao.findByDeptId(id);
	}

	@Override
	public Dept addDept(Dept dept) {

		return dao.save(dept);
	}

}
