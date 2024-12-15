package com.employees.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employees.entity.Employee;
import com.employees.repository.EmployeeRepository;
import com.employees.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public void deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

	@Override
	public Employee getEmployee(Integer id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).get();
	}

}
