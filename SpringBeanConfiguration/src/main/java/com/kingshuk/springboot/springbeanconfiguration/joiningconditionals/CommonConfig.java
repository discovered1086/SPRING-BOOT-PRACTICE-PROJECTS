package com.kingshuk.springboot.springbeanconfiguration.joiningconditionals;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration("secondCommonConfig")
@Import({ConfigC.class, ConfigB.class})
//@ConditionalOnExpression("'${propertycheck.enabled}' =='true'")
@ConditionalOnProperty(name="propertycheck.enabled", havingValue="true", matchIfMissing=false)
@ConditionalOnBean(name={"secondConfigB", "secondConfigC"})
public class CommonConfig {
	
	@Autowired
	@Qualifier("secondRoleBean")
	private Role role;
	
	@Autowired
	@Qualifier("secondAddressBean")
	private Address address;
	
	
	@PostConstruct
	public void setUp() {
		System.out.println("Loading the second common config bean");
	}
	
	@Bean(name="secondConfigEmployee")
	public Employee getEmployeeBean() {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Kingshuk");
		
		employee.setAddress(address);
		
		employee.setRole(role);
		
		return employee;
	}

}
