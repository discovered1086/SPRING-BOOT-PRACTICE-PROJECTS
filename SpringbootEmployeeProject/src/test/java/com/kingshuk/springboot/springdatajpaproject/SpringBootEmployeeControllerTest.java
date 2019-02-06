package com.kingshuk.springboot.springdatajpaproject;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.kingshuk.springboot.springdatajpaproject.dto.AddressDto;
import com.kingshuk.springboot.springdatajpaproject.dto.DepartmentDto;
import com.kingshuk.springboot.springdatajpaproject.dto.EmployeeDto;
import com.kingshuk.springboot.springdatajpaproject.entities.Address;
import com.kingshuk.springboot.springdatajpaproject.entities.Department;
import com.kingshuk.springboot.springdatajpaproject.entities.Employee;

/**
 * We;re performing end to end integration test here and not just unit test and notice that's why we have not
 * mocked anything in this class
 * We need to run the real classes in the flow and test them.
 * @author kingshuksmacbookpro
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootEmployeeControllerTest {
	
	@Value("${employeeapi.services.url}")
	private String serviceUrl;

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	static List<EmployeeDto> employeeDtos;

	static List<Employee> employees;

	static Employee employee;

	static EmployeeDto employeeDto;

	@PostConstruct
	public void loadDataForTesting() {
		AddressDto address = new AddressDto();
		//address.setAddressId(9L);
		address.setAddressLine1("771 Shady Grove Ln");
		address.setAddressLine2("");
		address.setCity("Buffalo Grove");
		address.setState("IL");
		address.setZipCode("60089");

		DepartmentDto departmentDto = new DepartmentDto();
		//departmentDto.setDepartmentId(9l);
		departmentDto.setDepartmentName("Architecture");

		employeeDto = new EmployeeDto();
		//employeeDto.setEmployeeId(9l);
		employeeDto.setFirstName("Kingshuk");
		employeeDto.setLastName("Mukherjee");
		employeeDto.setAddress(address);
		employeeDto.setDepartment(departmentDto);

		employeeDtos = Arrays.asList(employeeDto);

		employee = new Employee(employeeDto, new Address(address), new Department(departmentDto));

		employees = Arrays.asList(employee);
	}

	@Test
	public void testSingleEmployeeGet() {
		System.out.println(serviceUrl);
		RestTemplate restTemplate = restTemplateBuilder.build();
		EmployeeDto employee2 = restTemplate.getForObject(serviceUrl+"/14",
				EmployeeDto.class);

		// assertEquals(employee, employee2);
		assertNotNull(employee2);

		assertEquals(employeeDto, employee2);

	}
	
	@Test
	public void testSingleEmployeeCreate() {
		RestTemplate restTemplate = restTemplateBuilder.build();
		Employee employee2 = restTemplate.postForObject(serviceUrl,
				 employeeDto, Employee.class);

		// assertEquals(employee, employee2);
		assertNotNull("The object returned is null",employee2);

		assertEquals(employee, employee2);

	}
	
	@Test
	public void testSingleEmployeeUpdate() {
		RestTemplate restTemplate = restTemplateBuilder.build();
		
		EmployeeDto employee2 = restTemplate.getForObject(serviceUrl+"/14",
				EmployeeDto.class);
		
		assertNotNull(employee2);
		
		
		DepartmentDto department = new DepartmentDto();
		department.setDepartmentId(2l);
		department.setDepartmentName("Architecture");
		
		employee2.setDepartment(department);
		
		restTemplate.put(serviceUrl, employee2);
		
		EmployeeDto employee3 = restTemplate.getForObject(serviceUrl+"/14",
				EmployeeDto.class);
		
		assertNotNull(employee3);
		
		assertEquals(employeeDto.getDepartment().getDepartmentName(), employee3.getDepartment().getDepartmentName());

	}

}
