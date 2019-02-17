package com.kingshuk.springboot.multimodulespringboot.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class BaseController {
	
	@GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
	public String getMessage() {
		return "Welcome to the transaction world!!";
	}

}
