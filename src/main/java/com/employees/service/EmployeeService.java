package com.employees.service;

import java.util.List;
import java.util.Map;

import com.employees.entity.Employee;

public interface EmployeeService {
	public Employee createEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public void deleteEmployee(Integer id);

	public Employee getEmployee(Integer id);

	public Employee findByName(String name);

	public Employee findByDepartment(String name);

	public Employee updateEmployee(Map<String, Object> map,Integer id);
}
