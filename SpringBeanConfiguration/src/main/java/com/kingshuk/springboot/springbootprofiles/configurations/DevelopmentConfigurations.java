package com.kingshuk.springboot.springbootprofiles.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.kingshuk.springboot.springbootprofiles.beans.Resource;

@Configuration
@Profile("dev")
public class DevelopmentConfigurations {
	
	@Bean
	public Resource getDevResource() {
		System.out.println("Creating the dev resource bean");
		return new Resource("learning-material", "https://www.kingshuk-dev.com");
	}

}
