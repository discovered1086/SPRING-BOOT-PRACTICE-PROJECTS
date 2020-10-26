package com.kingshuk.webservices.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kingshuk.webservices.rest.models.PersonV1;
import com.kingshuk.webservices.rest.models.PersonV2;

@RestController
public class PersonVersionController {

	@GetMapping(path = "/v1/person")
	public PersonV1 helloWorld() {
		return new PersonV1("Kingshuk Mukherjee");
	}

	@GetMapping(path = "/v2/person")
	public PersonV2 helLoWorldBean() {
		return new PersonV2("Kingshuk", "Mukherjee");
	}

}
