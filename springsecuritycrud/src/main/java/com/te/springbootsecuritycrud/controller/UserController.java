package com.te.springbootsecuritycrud.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.springbootsecuritycrud.dto.MyUserDetails;
import com.te.springbootsecuritycrud.dto.User;
import com.te.springbootsecuritycrud.service.MyUserService;

@Controller
public class UserController {

	@Autowired
	private MyUserService service;

	@GetMapping("/admin")
	public String admin() {
		return "welcome";

	}

	@GetMapping("/user")
	public String seeDetails() {
		return "welcome";
	}

	@PostMapping("/seeUserById")
	public String seeDetails(int id, ModelMap map) {

		User user = service.getDetails(id);
		if (user != null) {
			map.addAttribute("data", user);
		}

		return "welcome";
	}

	@GetMapping("/seeUserById")
	public String seeUserById() {
		return "welcome";
	}

	@GetMapping("/seeAllUser")
	public String sellAllDetails(ModelMap map) {

		List<User> userList = service.seeAllDetails();
		if (userList != null) {
			map.addAttribute("users", userList);
		}
		return "showUser";
	}

	@GetMapping("/addUser")
	public String addUser() {

		return "addDetails";
	}

	@PostMapping("/addUser")
	public String addUser(ModelMap map, User user) {
		User user2 = service.addDetails(user);
		if (user2 != null) {
			map.addAttribute("msg", "user added succesfully");
		} else {
			map.addAttribute("error", "something went wrong");
		}

		return "addDetails";
	}

}
