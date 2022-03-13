package com.te.springbootuser.userservice;

import com.te.springbootuser.beans.User;
import com.te.springbootuser.pojo.ResponseTemplateVO;

public interface UserService  {

	   public User getUser(int id);
	   public User addUser(User user);
	   public ResponseTemplateVO getUserDept(int id);
	
}
