package com.te.springbootuser.userservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.te.springbootuser.beans.User;
import com.te.springbootuser.dao.UserDao;
import com.te.springbootuser.pojo.DepartmentPojo;
import com.te.springbootuser.pojo.ResponseTemplateVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	@Autowired
	private RestTemplate restTemplate;
	 
	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return dao.findByUserId(id);
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return dao.save(user);
	}
	
	@Override
	public ResponseTemplateVO getUserDept(int userId) {
		ResponseTemplateVO responseTemplateVO=new ResponseTemplateVO();
		User user=dao.findByUserId(userId);
	   DepartmentPojo departmentPojo=restTemplate.getForObject("http://localhost:8083/department/getDept/"+user.getDepartmentId(),DepartmentPojo.class);
	   
	   responseTemplateVO.setUser(user);
	   responseTemplateVO.setDepartmentPojo(departmentPojo);
	   return responseTemplateVO;
	}

	
	
}
