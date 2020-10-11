package com.kingshuk.webservices.rest.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class MyHelloWorldBean {
	
	private String message = "Hello from the bean..Mr. ";

	@NonNull
	private final String firstName;
	
	@NonNull
	private final String lastName;
	
	public String getMessage() {
		return this.message + this.firstName + " "+this.lastName;
	}
}
