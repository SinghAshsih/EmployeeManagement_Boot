package com.employees.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employees.entity.Employee;
import com.employees.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/{id}")
	ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
		Employee employee = employeeService.getEmployee(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
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

	@GetMapping("/byName")
	public ResponseEntity<Employee> findByName(@RequestParam String name) {
		Employee findByName = employeeService.findByName(name);
		return new ResponseEntity<Employee>(findByName, HttpStatus.OK);
	}

	@GetMapping("/byDepartment")
	public ResponseEntity<Employee> findByDepartment(@RequestParam String department) {
		Employee findByDepartment = employeeService.findByDepartment(department);
		return new ResponseEntity<Employee>(findByDepartment, HttpStatus.OK);
	}

	@PatchMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployeee(@RequestBody Map<String, Object> map, @PathVariable Integer id) {
		Employee updatedEmployee = employeeService.updateEmployee(map,id);
		return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
	}
}
