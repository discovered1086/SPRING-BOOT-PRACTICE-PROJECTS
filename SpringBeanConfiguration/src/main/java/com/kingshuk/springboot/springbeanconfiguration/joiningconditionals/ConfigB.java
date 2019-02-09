package com.kingshuk.springboot.springbeanconfiguration.joiningconditionals;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Configuration("secondConfigB")
//@ConditionalOnExpression("'${make.role.available}' =='true'")
@ConditionalOnProperty(name="make.role.available", havingValue="true", matchIfMissing=false)
public class ConfigB {
		
	@PostConstruct
	public void setUp() {
		System.out.println("Loading the second ConfigB config bean");
	}
	
	@Bean(name="secondRoleBean")
	public Role getRoleBean() {
		Role role = new Role();
		
		role.setRoleId(1);
		role.setRoleName("developer");
		
		return role;
	}

}
