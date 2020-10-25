package com.kingshuk.springboot.springdatajpaproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableCaching
public class SpringbootEmployeeProjectApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringbootEmployeeProjectApplication.class, args);
	}

}