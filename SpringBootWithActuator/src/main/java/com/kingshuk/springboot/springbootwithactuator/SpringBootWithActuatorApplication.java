package com.kingshuk.springboot.springbootwithactuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBootWithActuatorApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithActuatorApplication.class, args);
	}
}

@RestController
@RequestMapping("/")
class SimpleRestController{
	
	@GetMapping
	public String simpleGreeting() {
		return "Hello Mr. Kingshuk Mukherjee";
	}
	
}
