package com.kingshuk.springboot.springdatajpaproject.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kingshuk.springboot.springdatajpaproject.dto.EmployeeDto;
import com.kingshuk.springboot.springdatajpaproject.entities.Address;
import com.kingshuk.springboot.springdatajpaproject.entities.Department;
import com.kingshuk.springboot.springdatajpaproject.entities.Employee;
import com.kingshuk.springboot.springdatajpaproject.repos.AddressRepository;
import com.kingshuk.springboot.springdatajpaproject.repos.DepartmentRepository;
import com.kingshuk.springboot.springdatajpaproject.repos.EmployeeManagementRepository;

@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementService {

	@Autowired
	private EmployeeManagementRepository repository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Employee getEmployee(long employeeId) {
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	@Override
	public Employee getEmployeeById(long employeeId) {
		return repository.findById(employeeId).orElseThrow(null);
	}

	@Override
	public void deleteEmployee(long employeeId) {
		repository.deleteById(employeeId);
	}

	@Override
	@Transactional
	public void addOrUpdateEmployee(EmployeeDto employee) {

		Employee employee2 = null;

		Address address = addressRepository
				.findByAddressLine1AndAddressLine2AndCityAndStateAndZipCode(employee.getAddress().getAddressLine1(),
						employee.getAddress().getAddressLine2(), employee.getAddress().getCity(),
						employee.getAddress().getState(), employee.getAddress().getZipCode())
				.orNull();

		Department department = departmentRepository.findByDepartmentName(employee.getDepartment().getDepartmentName())
				.orNull();

		Employee employee3 = repository.findByFirstNameAndLastName(employee.getFirstName(), employee.getLastName())
				.orNull();

		if (address == null) {
			address = new Address(employee.getAddress());
		}

		if (department == null) {
			department = new Department(employee.getDepartment().getDepartmentId(),
					employee.getDepartment().getDepartmentName());
		}

		if (employee3 == null) {
			employee2 = new Employee(employee, address, department);
			repository.save(employee2);
		}

	}

}