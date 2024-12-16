package com.employees.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employees.entity.Users;
import com.employees.repository.UserRepository;

@Service
public class UsersServiceImpl {

	@Autowired
	private UserRepository userRepository;

	public Users register(Users user) {
		user.setPassword(user.getPassword());
		return userRepository.save(user);
	}
}