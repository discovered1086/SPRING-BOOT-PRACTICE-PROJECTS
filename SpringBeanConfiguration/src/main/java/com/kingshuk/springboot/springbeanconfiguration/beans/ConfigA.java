package com.kingshuk.springboot.springbeanconfiguration.beans;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@Configuration
@Profile("default")
@Import(CommonConfig.class)
public class ConfigA {
	
	@Autowired
	private Employee employee;
	
	@PostConstruct
	public void setUp() {
		System.out.println("Loading the ConfigA config bean");
	}
	
	@Autowired
	private Environment environment;
	
	/*@Bean(name="departmentAddedEmployee")
	public Employee getDepartmentBean() {
		Department department = new Department();
		
		department.setId(1);
		department.setName(environment.getProperty("department.name"));
		
		employee.setDepartment(department);
		
		return employee;
	}*/

}
