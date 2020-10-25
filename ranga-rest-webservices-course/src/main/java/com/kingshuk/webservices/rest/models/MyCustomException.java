package com.kingshuk.webservices.rest.models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@EqualsAndHashCode(doNotUseGetters = true, callSuper = true)
@Getter
@Setter
public class MyCustomException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2985738122916303883L;

	private final LocalDateTime dateTime;
	
	private final String message;
	
	private final String details;

}
