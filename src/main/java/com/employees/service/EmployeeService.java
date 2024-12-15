package com.employees.service;

import java.util.List;

import com.employees.entity.Employee;

public interface EmployeeService {
	public Employee createEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public void deleteEmployee(Integer id);

	public Employee getEmployee(Integer id);
}
