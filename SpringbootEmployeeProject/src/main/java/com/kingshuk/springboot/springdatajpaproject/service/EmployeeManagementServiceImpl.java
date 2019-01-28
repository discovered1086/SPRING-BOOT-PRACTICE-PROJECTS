package com.kingshuk.springboot.springdatajpaproject.service;


import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;
import java.util.Optional;

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
	public Employee addNewEmployee(EmployeeDto employee) {

		Employee employee2 = null;
		
		Optional<Employee> returnEmployee = Optional.empty();

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
			returnEmployee = Optional.of(repository.save(employee2));
		}
		
		return returnEmployee.orElse(employee3);

	}
	
	@Override
	@Transactional
	public Employee updateEmployee(EmployeeDto employee) {

		Employee employee2 = null;
		
		Optional<Employee> returnEmployee = Optional.empty();

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
		
		if (employee3 != null) {
			employee2 = new Employee(employee, address, department);
			returnEmployee = Optional.of(repository.save(employee2));
		}
		
		return returnEmployee.orElse(employee3);

	}
	
	public void partialUpdateEmployee(EmployeeDto employeeDto) {
		Employee employee = repository.findById(employeeDto.getEmployeeId()).orElse(null);
		
		if(employee!=null) {
			Employee employee2 = new Employee(employeeDto, employee.getAddress(), employee.getDepartment());
			
			
			repository.save(employee2);
		}
		
	}

}
