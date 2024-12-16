package com.employees.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employees.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	public Optional<Employee> findByName(String name);

	public Optional<Employee> findByDepartment(String department);
}
