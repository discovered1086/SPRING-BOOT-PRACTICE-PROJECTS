package com.kingshuk.springboot.springdatajpaproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kingshuk.springboot.springdatajpaproject.dto.EmployeeDto;
import com.kingshuk.springboot.springdatajpaproject.entities.Address;
import com.kingshuk.springboot.springdatajpaproject.entities.Department;
import com.kingshuk.springboot.springdatajpaproject.entities.Employee;
import com.kingshuk.springboot.springdatajpaproject.service.EmployeeManagementService;

@RestController
public class EmployeeManagementController {

	@Autowired
	private EmployeeManagementService employeeManagementService;

	@GetMapping("/")
	public String welcomeMessage() {
		return "Welcome to the employee Management service";
	}

	@PostMapping(path = "/employees", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public EmployeeDto createEmployee(@RequestBody EmployeeDto employee) {

		employeeManagementService.addOrUpdateEmployee(employee);

		return employee;
	}

	@GetMapping(path = "/employees", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Employee>> getAllEmployees() {
		
		List<Employee> employeeList = employeeManagementService.getAllEmployees();
		
		if(employeeList==null || employeeList.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		
		return ResponseEntity.ok(employeeList);
	}

	@GetMapping(path = "/employees/{employeeId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Employee getEmployeeByEmployeeId(@PathVariable("employeeId") Long empId) {
		return employeeManagementService.getEmployeeById(empId);
	}

	@PutMapping(path = "/employees", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public EmployeeDto updateEmployee(@RequestBody EmployeeDto employee) {
		
		employeeManagementService.addOrUpdateEmployee(employee);
		
		return employee;
	}
	
	@PatchMapping(path = "/employees", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public EmployeeDto updatePartialEmployeeDto(@RequestBody EmployeeDto employeeDto) {
		return null;
	}
	
	
	
	@DeleteMapping(path = "/employees/{employeeId}")
	public void deleteEmployee(@PathVariable("employeeId") Long empId) {
		employeeManagementService.deleteEmployee(empId);
	}

}