package com.kingshuk.webservices.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kingshuk.webservices.rest.models.MyHelloWorldBean;

@RestController
public class RestFulController {
	
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello Kingshuk Mukherjee";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public MyHelloWorldBean helLoWorldBean() {
		return new MyHelloWorldBean("Kingshuk", "Mukherjee");
	}

}
