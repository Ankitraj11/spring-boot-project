package com.te.springbootdept.service;

import com.te.springbootdept.beans.Dept;

public interface DeptService {

	public Dept getDept(int id);
	
	public Dept addDept(Dept dept);
	
	
}
