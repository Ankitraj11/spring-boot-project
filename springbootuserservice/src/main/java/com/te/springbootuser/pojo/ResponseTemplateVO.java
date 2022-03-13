package com.te.springbootuser.pojo;

import com.te.springbootuser.beans.User;

public class ResponseTemplateVO {

	private User user;
	private DepartmentPojo departmentPojo;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public DepartmentPojo getDepartmentPojo() {
		return departmentPojo;
	}
	public void setDepartmentPojo(DepartmentPojo departmentPojo) {
		this.departmentPojo = departmentPojo;
	}
  
}
