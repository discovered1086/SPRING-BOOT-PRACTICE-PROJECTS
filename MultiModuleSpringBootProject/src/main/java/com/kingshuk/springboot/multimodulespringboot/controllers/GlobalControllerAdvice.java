package com.kingshuk.springboot.multimodulespringboot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kingshuk.springboot.multimodulespringboot.errors.AccountNotFoundException;
import com.kingshuk.springboot.multimodulespringboot.errors.ErrorResponse;

@ControllerAdvice
public class GlobalControllerAdvice {
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> getErrorResponse(AccountNotFoundException accountNotFoundException){
		
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(),"Account Not Found..!!");
		
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

}
