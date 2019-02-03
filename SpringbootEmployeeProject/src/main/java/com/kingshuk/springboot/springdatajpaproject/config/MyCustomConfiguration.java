package com.kingshuk.springboot.springdatajpaproject.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class MyCustomConfiguration {
	
	@Bean
	public DozerBeanMapper getDozerBeanMapper() {
		return new DozerBeanMapper();
	}

}
