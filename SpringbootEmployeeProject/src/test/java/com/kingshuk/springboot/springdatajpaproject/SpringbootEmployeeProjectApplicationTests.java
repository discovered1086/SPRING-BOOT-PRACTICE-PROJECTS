package com.kingshuk.springboot.springdatajpaproject;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
public class SpringbootEmployeeProjectApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeManagementService employeeService;

	@MockBean
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

		mockMvc.perform(get("/SpringBootEmployeeProject/employees").contextPath("/SpringBootEmployeeProject")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))

				.andExpect(status().isOk());

	}

}
