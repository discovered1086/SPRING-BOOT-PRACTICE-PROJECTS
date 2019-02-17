package com.kingshuk.springboot.multimodulespringboot.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -976431264925409791L;
	
	private ErrorResponse errorResponse;

}
