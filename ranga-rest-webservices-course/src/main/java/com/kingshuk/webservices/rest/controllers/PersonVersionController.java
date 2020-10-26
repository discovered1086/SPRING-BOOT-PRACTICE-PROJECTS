package com.kingshuk.webservices.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kingshuk.webservices.rest.models.PersonV1;
import com.kingshuk.webservices.rest.models.PersonV2;

@RestController
public class PersonVersionController {

	@GetMapping(path = "/v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Kingshuk Mukherjee");
	}

	@GetMapping(path = "/v2/person")
	public PersonV2 personV2() {
		return new PersonV2("Kingshuk", "Mukherjee");
	}
	
	@GetMapping(path = "/person/param", params = "version=v1")
	public PersonV1 requestParam1() {
		return new PersonV1("Kingshuk Mukherjee");
	}

	@GetMapping(path = "/person/param", params = "version=v2")
	public PersonV2 requestParam12() {
		return new PersonV2("Kingshuk", "Mukherjee");
	}
	
	@GetMapping(path = "/person/header", headers = "version=v1")
	public PersonV1 headerPersonV1() {
		return new PersonV1("Kingshuk Mukherjee");
	}

	@GetMapping(path = "/person/header", headers = "version=v2")
	public PersonV2 headerPersonV2() {
		return new PersonV2("Kingshuk", "Mukherjee");
	}
	
	@GetMapping(path = "/person/produces", produces = "application/mycompany-v1+json")
	public PersonV1 producesPersonV1() {
		return new PersonV1("Kingshuk Mukherjee");
	}

	@GetMapping(path = "/person/produces", produces = "application/mycompany-v2+json")
	public PersonV2 producesPersonV2() {
		return new PersonV2("Kingshuk", "Mukherjee");
	}

}
