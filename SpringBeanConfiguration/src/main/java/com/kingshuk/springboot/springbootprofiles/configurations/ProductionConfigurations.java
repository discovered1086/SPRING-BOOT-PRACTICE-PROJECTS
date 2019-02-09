package com.kingshuk.springboot.springbootprofiles.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.kingshuk.springboot.springbootprofiles.beans.Resource;

@Configuration
@Profile("prod")
public class ProductionConfigurations {

	@Bean
	public Resource getDevResource() {
		System.out.println("creating the production bean");
		return new Resource("learning-material", "https://www.kingshuk-prod.com");
	}
}
