package com.employees.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

	@Override
	public Employee updateEmployee(Map<String, Object> map, Integer id) {
		Optional<Employee> oldEmployee = employeeRepository.findById(id);
		List<String> keys = map.entrySet().stream().map((key) -> key.getKey()).collect(Collectors.toList());

		if (oldEmployee.isPresent()) {
			for (String key : keys) {
				switch (key) {
				case "name":
					oldEmployee.get().setName(map.get(key).toString());
					break;
				case "salary":
					Object object = map.get(key);
					String s = object.toString();
					Float valueOf = Float.valueOf(s);
					oldEmployee.get().setSalary(valueOf);
					break;
				case "department":
					oldEmployee.get().setDepartment(map.get(key).toString());
					break;
				case "age":
					oldEmployee.get().setAge((int) map.get(key));
					break;
				case "email":
					oldEmployee.get().setEmail(map.get(key).toString());
				}
			}
			Employee updated = employeeRepository.save(oldEmployee.get());

			return updated;
		} else {
			return oldEmployee
					.orElseThrow(() -> new ResourceNotFoundException("Resource not found with the given id : " + id));
		}

	}

}
