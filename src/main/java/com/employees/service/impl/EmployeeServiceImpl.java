package com.employees.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employees.entity.Employee;
import com.employees.exception.custom.ResourceNotFoundException;
import com.employees.repository.EmployeeRepository;
import com.employees.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee saveEmployee = employeeRepository.save(employee);
		return saveEmployee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> findAllEmployees = employeeRepository.findAll();
		return findAllEmployees;
	}

	@Override
	public void deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		Optional<Employee> findById = employeeRepository.findById(id);
		if (findById.isPresent()) {
			employeeRepository.deleteById(id);
		} else {
			findById.orElseThrow(() -> new ResourceNotFoundException("Resource not found with the given id : " + id));
		}
	}

	@Override
	public Employee getEmployee(Integer id) {
		// TODO Auto-generated method stub
		Optional<Employee> findById = employeeRepository.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		} else {
			return findById
					.orElseThrow(() -> new ResourceNotFoundException("Resource not found with the given id : " + id));
		}
	}

	@Override
	public Employee findByName(String name) {
		Optional<Employee> findByName = employeeRepository.findByName(name);
		if (findByName.isPresent()) {
			return findByName.get();
		} else {
			return findByName.orElseThrow(
					() -> new ResourceNotFoundException("Resource not found with the given name : " + name));
		}
	}

	@Override
	public Employee findByDepartment(String name) {
		// TODO Auto-generated method stub
		Optional<Employee> findByDepartmentName = employeeRepository.findByDepartment(name);
		if (findByDepartmentName.isPresent()) {
			return findByDepartmentName.get();
		} else {
			return findByDepartmentName.orElseThrow(
					() -> new ResourceNotFoundException("Resource not found with the given name : " + name));
		}
	}

}
