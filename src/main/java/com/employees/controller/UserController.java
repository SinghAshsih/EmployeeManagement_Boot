package com.employees.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employees.entity.Users;
import com.employees.service.impl.UsersServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UsersServiceImpl userServiceImpl;
	
	@PostMapping("/register")
	public Users register(@RequestBody Users user) {
		return userServiceImpl.register(user);
	}
	
}
