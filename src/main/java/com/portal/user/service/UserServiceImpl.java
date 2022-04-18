package com.portal.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.user.dao.UserDao;
import com.portal.user.entity.Users;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao dao;


	public Users addUser(Users user) {
		user.setRole("user");
		return dao.save(user);
	}

}
