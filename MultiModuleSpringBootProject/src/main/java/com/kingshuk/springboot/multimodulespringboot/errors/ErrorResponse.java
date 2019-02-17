package com.kingshuk.springboot.multimodulespringboot.errors;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6378268541666489143L;

	private int statusCode;
	
	private String errorMessage;
}
