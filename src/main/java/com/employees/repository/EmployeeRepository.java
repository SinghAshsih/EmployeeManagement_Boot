package com.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employees.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
