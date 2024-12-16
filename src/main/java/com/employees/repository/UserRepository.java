package com.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employees.entity.Users;

public interface UserRepository  extends JpaRepository<Users,Long>{

	public Users findByUsername(String username);
	
}
