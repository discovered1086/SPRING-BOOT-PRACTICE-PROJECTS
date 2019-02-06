package com.kingshuk.springboot.springdatajpaproject.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kingshuk.springboot.springdatajpaproject.controller.EmployeeManagementController;
import com.kingshuk.springboot.springdatajpaproject.exceptionhandling.beans.MyCustomErrorResponse;

@ControllerAdvice(assignableTypes = {EmployeeManagementController.class})
public class EmployeeRestControllerAdvice {
	
	//Moving the exception handling to this class for employee controller
	@ExceptionHandler
	public ResponseEntity<MyCustomErrorResponse> handleException
	(EmployeeNotFoundException employeeNotFoundException){
		
		MyCustomErrorResponse customErrorResponse = new MyCustomErrorResponse();
		
		customErrorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		customErrorResponse.setMessage("I'm sorry honey!! This employee does not exist...");
		
		return new ResponseEntity<>(customErrorResponse, HttpStatus.NOT_FOUND);
	}

}
