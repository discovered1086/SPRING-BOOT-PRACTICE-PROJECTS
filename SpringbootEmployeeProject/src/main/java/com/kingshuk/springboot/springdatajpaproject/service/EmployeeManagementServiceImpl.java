package com.kingshuk.springboot.springdatajpaproject.service;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
	@Transactional(readOnly = true)
	@Cacheable(value = "employee-cache")
	public Employee getEmployeeById(long employeeId) {
		return repository.findById(employeeId).orElse(null);
	}

	@Override
	@CacheEvict(value = "employee-cache")
	public void deleteEmployee(long employeeId) {
		repository.deleteById(employeeId);
	}

	@Override
	@Transactional
	public Employee addOrUpdateEmployee(Employee employee) {
		
		Employee employee2 = repository.findByFirstNameAndLastName(employee.getFirstName(), employee.getLastName())
				.orElseGet(()-> {
					Employee employee3 = repository.findById(employee.getEmployeeId()).orElse(null);
					
					if(employee3!=null) {
						employee3.setFirstName(employee.getFirstName());
						employee3.setLastName(employee.getLastName());
					}else {
						employee3 = new Employee(employee.getFirstName(), employee.getLastName());
					}
					
					return employee3;
				});
						

		
		/*
		 * First I'm searching for the address in the database
		 * If I find it, then I have to see if this address belongs to the employee I found or created.
		 * If it doesn't then I set the address to this employee
		 */
		if(employee.getAddress()!=null) {
			Address address = addressRepository.findByAddressLine1AndAddressLine2AndCityAndStateAndZipCode
					(employee.getAddress().getAddressLine1(), 
					 employee.getAddress().getAddressLine2(), 
					 employee.getAddress().getCity(), 
					 employee.getAddress().getState(), 
					 employee.getAddress().getZipCode()).orElse(null);	
			
			if(address==null) {
				address = employee.getAddress();
				
				address = addressRepository.save(address);
			}
			
			employee2.setAddress(address);
		}
		
		
		/*
		 * Same logic for department
		 */
		if(employee.getDepartment()!=null) {
			Department department = departmentRepository.findByDepartmentName(employee.getDepartment().getDepartmentName())
									.orElse(null);
			
			if(department == null) {
				department = employee.getDepartment();
			}
			
			employee2.setDepartment(department);
		}
		
		

		return repository.save(employee2);

	}

	public void partialUpdateEmployee(EmployeeDto employeeDto) {
		Employee employee = repository.findById(employeeDto.getEmployeeId()).orElse(null);

		if (employee != null) {
			Employee employee2 = new Employee(employeeDto, employee.getAddress(), employee.getDepartment());

			repository.save(employee2);
		}

	}

}
