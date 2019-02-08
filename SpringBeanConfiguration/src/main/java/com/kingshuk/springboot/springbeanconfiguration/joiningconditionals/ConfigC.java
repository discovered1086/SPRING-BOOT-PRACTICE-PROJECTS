package com.kingshuk.springboot.springbeanconfiguration.joiningconditionals;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@Configuration("secondConfigC")
//@Profile("default")
//@ConditionalOnExpression("'${make.addess.available}' =='true'")
@ConditionalOnProperty(name="make.addess.available", havingValue="true", matchIfMissing=false)
public class ConfigC {
	
	@PostConstruct
	public void setUp() {
		System.out.println("Loading the ConfigC config bean");
	}
	
	@Bean(name="secondAddressBean")
	public Address getAddessBean() {
		Address address = new Address();
		
		address.setCity("New York");
		address.setZipCode("5454654");
		
		return address;
	}

}
