package com.kingshuk.webservices.rest.controllers;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.kingshuk.webservices.rest.models.MyCustomException;

@RestControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		MyCustomException exception = new MyCustomException(LocalDateTime.now(), "Validation failed",
				ex.getBindingResult().toString());
		
		return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
	}

}
