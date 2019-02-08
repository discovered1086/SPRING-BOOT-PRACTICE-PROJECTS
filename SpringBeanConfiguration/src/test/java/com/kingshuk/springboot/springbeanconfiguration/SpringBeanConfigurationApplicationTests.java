package com.kingshuk.springboot.springbeanconfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.kingshuk.springboot.springbeanconfiguration.beans.Address;
import com.kingshuk.springboot.springbeanconfiguration.beans.Department;
import com.kingshuk.springboot.springbeanconfiguration.beans.Employee;
import com.kingshuk.springboot.springbeanconfiguration.beans.Role;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class SpringBeanConfigurationApplicationTests {
	
	//@Autowired
	//private Employee employee;
	
	//@Autowired
	//private Department department;
	
	@Autowired
	//@Qualifier("departmentAddedEmployee")	
	private Employee employee;
	
	@Autowired
	private Address address;

	@Test
	public void testBeanAvailability() {
		assertNotNull(employee);
	}
	
	@Test
	public void testRoleAvailability() {
		assertNotNull(employee.getRole());
	}
	
	@Test
	public void testDepartmentAvailability() {
		assertNotNull(employee.getDepartment());
	}
	
	@Test
	public void testAddressAvailability() {
		assertNotNull(address);
	}

}

