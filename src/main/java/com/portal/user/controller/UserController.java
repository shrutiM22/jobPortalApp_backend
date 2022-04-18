package com.portal.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.portal.user.dao.UserDao;
import com.portal.user.entity.UserDto;
import com.portal.user.entity.Users;
import com.portal.user.service.UserServiceImpl;

@RestController
//@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServiceImpl service;
	
	@Autowired
	UserDao userdao;

	
	//registration form page
	@CrossOrigin(origins = "http://localhost:3001")
	@RequestMapping(value = "/register", method = { RequestMethod.GET, RequestMethod.POST })
	public Users addUser(@RequestBody Users use ) { 
		 return service.addUser(use);
			
}
	
	//login users
	@CrossOrigin(origins = "http://localhost:3001")
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })         // http://localhost:5800/user/login
	public String logIn(@RequestBody UserDto userdto) {
		List<Users> users = userdao.findAll();
		for (Users object : users) {
			 if(userdto.getemail().equals(object.getEmail()) && userdto.getPassword().equals(object.getPassword())) {
				return "Login Successfully";
			}
  
		}
		return "User Not Available";

	}
	
	
}
