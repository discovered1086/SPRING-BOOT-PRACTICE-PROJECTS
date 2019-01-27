package com.kingshuk.springboot.springdatajpaproject;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.kingshuk.springboot.springdatajpaproject.controller.EmployeeManagementController;
import com.kingshuk.springboot.springdatajpaproject.dto.AddressDto;
import com.kingshuk.springboot.springdatajpaproject.dto.DepartmentDto;
import com.kingshuk.springboot.springdatajpaproject.dto.EmployeeDto;
import com.kingshuk.springboot.springdatajpaproject.entities.Address;
import com.kingshuk.springboot.springdatajpaproject.entities.Department;
import com.kingshuk.springboot.springdatajpaproject.entities.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmployeeManagementController.class)
public class SpringBootEmployeeControllerTest {

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	static List<EmployeeDto> employeeDtos;

	static List<Employee> employees;

	static Employee employee;

	static {
		AddressDto address = new AddressDto();
		address.setAddressId(9L);
		address.setAddressLine1("771 Shady Grove Ln");
		address.setAddressLine2("");
		address.setCity("Buffalo Grove");
		address.setState("IL");
		address.setZipCode("60089");

		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setDepartmentId(9l);
		departmentDto.setDepartmentName("IT");

		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setEmployeeId(9l);
		employeeDto.setFirstName("Amit");
		employeeDto.setLastName("Mukherjee");
		employeeDto.setAddress(address);
		employeeDto.setDepartment(departmentDto);

		employeeDtos = Arrays.asList(employeeDto);

		employee = new Employee(employeeDto, new Address(address), new Department(departmentDto));

		employees = Arrays.asList(employee);

	}

	@Test
	public void testSingleEmployee() {
		RestTemplate restTemplate = restTemplateBuilder.build();
		EmployeeDto employee2 = restTemplate.getForObject("http://localhost:8080/SpringBootEmployeeProject/employees/9"
				, EmployeeDto.class);
		
		//assertEquals(employee, employee2);
		assertNotNull(employee2);
		
	}

}
