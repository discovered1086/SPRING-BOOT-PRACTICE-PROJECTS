package com.kingshuk.springboot.springdatajpaproject.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyCustomConfiguration {
	
	@Bean
	public DozerBeanMapper getDozerBeanMapper() {
		return new DozerBeanMapper();
	}

}
