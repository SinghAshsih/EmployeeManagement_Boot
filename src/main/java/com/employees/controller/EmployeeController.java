package com.employees.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employees.entity.Employee;
import com.employees.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/{id}")
	ResponseEntity<?> getEmployee(@PathVariable Integer id) {
		Optional<Employee> employee = employeeService.getEmployee(id);
		if (employee.isPresent()) {
			return new ResponseEntity<Employee>(employee.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No Employee found ", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/all")
	ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> listOfEmployee = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(listOfEmployee, HttpStatus.OK);
	}

	@PostMapping("/create")
	ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee createEmployee = employeeService.createEmployee(employee);
		return new ResponseEntity<Employee>(createEmployee, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmploee(@PathVariable(value = "id") Integer id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Data deleted successfully !! ", HttpStatus.NO_CONTENT);
	}

}
