package com.kingshuk.springboot.springdatajpaproject.unittest;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.io.IOUtils;
import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.kingshuk.springboot.springdatajpaproject.dto.AddressDto;
import com.kingshuk.springboot.springdatajpaproject.dto.DepartmentDto;
import com.kingshuk.springboot.springdatajpaproject.dto.EmployeeDto;
import com.kingshuk.springboot.springdatajpaproject.entities.Address;
import com.kingshuk.springboot.springdatajpaproject.entities.Department;
import com.kingshuk.springboot.springdatajpaproject.entities.Employee;
import com.kingshuk.springboot.springdatajpaproject.service.EmployeeManagementService;

/**
 * What this class is doing here is performing unit testing, not end to end
 * integration test and that's exactly why we have mocked out the employee
 * management service class
 * 
 * @author kingshuksmacbookpro
 *
 */

@RunWith(SpringRunner.class)
@WebMvcTest
public class EmployeeControllerUnitTest {

	private static final String EMPLOYEE_UPDATE_JSON = "jsonFiles/employee-update.json";

	private static final String EMPLOYEE_CREATE_RESPONSE_JSON = "jsonFiles/employee-create-response.json";

	private static final String EMPLOYEE_CREATE_JSON = "jsonFiles/employee-create.json";

	private static final String EMPLOYEES_URI_PATH = "/SpringBootEmployeeProject/employees";

	private static final String CONTEXT_PATH = "/SpringBootEmployeeProject";

	private static final String EMPLOYEE_JSON = "jsonFiles/employee.json";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeManagementService employeeService;

	@SpyBean
	private DozerBeanMapper myBeanMapper;

	List<EmployeeDto> employeeDtos;

	List<Employee> employees;

	Employee employee;

	@PostConstruct
	public void loadDataForTesting() {
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
		employeeDto.setFirstName("Kingshuk");
		employeeDto.setLastName("Mukherjee");
		employeeDto.setAddress(address);
		employeeDto.setDepartment(departmentDto);

		employeeDtos = Arrays.asList(employeeDto);

		employee = new Employee(employeeDto, new Address(address), new Department(departmentDto));

		employees = Arrays.asList(employee);
	}

	@Test
	public void testFindAllEmployees() throws Exception {
		when(employeeService.getAllEmployees()).thenReturn(employees);

		Resource resource = new ClassPathResource(EMPLOYEE_JSON);

		String jsonResponse = IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);

		mockMvc.perform(get(EMPLOYEES_URI_PATH).contextPath(CONTEXT_PATH).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().json(jsonResponse));

	}

	@Test
	public void testCreateEmployee() throws Exception {
		when(employeeService.addOrUpdateEmployee(any())).thenReturn(employee);

		Resource resource = new ClassPathResource(EMPLOYEE_CREATE_JSON);

		String jsonRequest = IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);

		resource = new ClassPathResource(EMPLOYEE_CREATE_RESPONSE_JSON);

		String jsonResponse = IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);

		mockMvc.perform(post(EMPLOYEES_URI_PATH).contextPath(CONTEXT_PATH).content(jsonRequest)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().json(jsonResponse));

	}
	
	
	@Test
	public void testUpdateEmployee() throws Exception {
		when(employeeService.addOrUpdateEmployee(any())).thenReturn(getUpdateEmployeeObject());

		Resource resource = new ClassPathResource(EMPLOYEE_UPDATE_JSON);

		String jsonRequest = IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);

		resource = new ClassPathResource(EMPLOYEE_UPDATE_JSON);

		String jsonResponse = IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);

		mockMvc.perform(post(EMPLOYEES_URI_PATH).contextPath(CONTEXT_PATH).content(jsonRequest)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().json(jsonResponse));

	}
	
	
	@Test
	public void testDeleteEmployee() throws Exception {
		when(employeeService.addOrUpdateEmployee(any())).thenReturn(employee);

		Resource resource = new ClassPathResource(EMPLOYEE_CREATE_JSON);

		String jsonRequest = IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);

		resource = new ClassPathResource(EMPLOYEE_CREATE_RESPONSE_JSON);

		String jsonResponse = IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);

		mockMvc.perform(post(EMPLOYEES_URI_PATH).contextPath(CONTEXT_PATH).content(jsonRequest)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().json(jsonResponse));

	}
	
	private Employee getUpdateEmployeeObject() {
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
		employeeDto.setFirstName("Deeksha");
		employeeDto.setLastName("Banerjee");
		employeeDto.setAddress(address);
		employeeDto.setDepartment(departmentDto);
		
		return new Employee(employeeDto, new Address(address), new Department(departmentDto));
	}

}
