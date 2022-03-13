package com.te.springbootuser.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")

public class User implements Serializable {

	@Id
	private int userId;
	
	@Column
	private String userName;
	
   @Column
	private String departmentId;

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getDepartmentId() {
	return departmentId;
}

public void setDepartmentId(String departmentId) {
	this.departmentId = departmentId;
}
   
   
	
}
