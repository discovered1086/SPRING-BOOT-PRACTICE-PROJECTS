package com.kingshuk.springboot.springbeanconfiguration.beans;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("default")
@Import(CommonConfig.class)
public class ConfigB {
	
	@Autowired
	private Employee employee;
	
	@PostConstruct
	public void setUp() {
		System.out.println("Loading the ConfigB config bean");
	}
	
	/*@Bean(name="roleAddedEmployee")
	public Employee getRoleBean() {
		Role role = new Role();
		
		role.setRoleId(1);
		role.setRoleName("developer");
		
		employee.setRole(role);
		
		return employee;
	}*/

}
