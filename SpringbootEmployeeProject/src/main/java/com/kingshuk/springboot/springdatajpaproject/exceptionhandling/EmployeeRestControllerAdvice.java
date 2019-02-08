package com.kingshuk.springboot.springdatajpaproject.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.kingshuk.springboot.springdatajpaproject.controller.EmployeeManagementController;
import com.kingshuk.springboot.springdatajpaproject.exceptionhandling.beans.MyCustomErrorResponse;

@ControllerAdvice(assignableTypes = {EmployeeManagementController.class})
public class EmployeeRestControllerAdvice {
	
	//Moving the exception handling to this class for employee controller
	@ExceptionHandler
	public ResponseEntity<MyCustomErrorResponse> handleEmployeeNotFoundException
	(EmployeeNotFoundException employeeNotFoundException){
		
		MyCustomErrorResponse customErrorResponse = new MyCustomErrorResponse();
		
		customErrorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		customErrorResponse.setMessage("I'm sorry honey!! This employee does not exist...");
		
		return new ResponseEntity<>(customErrorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	//@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "InvalidInput")
	public ResponseEntity<MyCustomErrorResponse> handleGenericException
	(Exception exception){
		
		MyCustomErrorResponse customErrorResponse = new MyCustomErrorResponse();
		
		customErrorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
		customErrorResponse.setMessage("I'm sorry honey!! You have sent some nasty shit this way!!" 
					+exception.getMessage());
		
		return new ResponseEntity<>(customErrorResponse, HttpStatus.BAD_REQUEST);
	}

}
