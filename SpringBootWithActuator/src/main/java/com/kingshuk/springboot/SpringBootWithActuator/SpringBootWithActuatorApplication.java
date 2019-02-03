package com.kingshuk.springboot.SpringBootWithActuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWithActuatorApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithActuatorApplication.class, args);
	}
}
