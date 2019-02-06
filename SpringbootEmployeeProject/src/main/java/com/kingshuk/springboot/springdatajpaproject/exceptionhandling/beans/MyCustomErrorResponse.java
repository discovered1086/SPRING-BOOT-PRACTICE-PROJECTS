package com.kingshuk.springboot.springdatajpaproject.exceptionhandling.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyCustomErrorResponse {
	
	private int statusCode;
	
	private String message;

}
