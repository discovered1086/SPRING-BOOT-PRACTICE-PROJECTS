package com.kingshuk.springboot.springbeanconfiguration.beans;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@Import({ConfigA.class, ConfigB.class})
public class CommonConfig {
	
		
	@PostConstruct
	public void setUp() {
		System.out.println("Loading the common config bean");
	}
	
	@Bean
	public Employee getEmployeeBean() {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Kingshuk");
		
		return employee;
	}

}
