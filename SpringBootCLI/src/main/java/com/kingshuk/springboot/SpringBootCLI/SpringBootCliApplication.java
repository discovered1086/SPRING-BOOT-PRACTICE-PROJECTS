package com.kingshuk.springboot.SpringBootCLI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBootCliApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCliApplication.class, args);


	}

    @RestController
    @RequestMapping("/api")
    public class MyHelloWorld{

	    @GetMapping("/hello")
        public String getMyGreeting(){
            return "Hello and welcome to the Spring Boot World Mr. Kingshuk Mukherjee";
        }
    }
}
