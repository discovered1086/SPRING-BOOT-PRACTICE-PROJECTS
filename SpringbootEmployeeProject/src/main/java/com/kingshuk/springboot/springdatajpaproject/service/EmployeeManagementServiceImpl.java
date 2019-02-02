package com.kingshuk.springboot.springdatajpaproject.service;

import java.util.List;

import org.dozer.DozerBeanMapper;
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
	private DozerBeanMapper myBeanMapper;

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
	public Employee addOrUpdateEmployee(Employee employee) {

		Address address = addressRepository
				.findByAddressLine1AndAddressLine2AndCityAndStateAndZipCode(employee.getAddress().getAddressLine1(),
						employee.getAddress().getAddressLine2(), employee.getAddress().getCity(),
						employee.getAddress().getState(), employee.getAddress().getZipCode())
				.or(employee.getAddress());

		Department department = departmentRepository.findByDepartmentName(employee.getDepartment().getDepartmentName())
				.or(new Department(employee.getDepartment().getDepartmentId(),
						employee.getDepartment().getDepartmentName()));

		Employee employee3 = repository.findByFirstNameAndLastName(employee.getFirstName(), employee.getLastName())
				.or(new Employee(department, address));

		return repository.save(employee3);

	}

	public void partialUpdateEmployee(EmployeeDto employeeDto) {
		Employee employee = repository.findById(employeeDto.getEmployeeId()).orElse(null);

		if (employee != null) {
			Employee employee2 = new Employee(employeeDto, employee.getAddress(), employee.getDepartment());

			repository.save(employee2);
		}

	}

}
