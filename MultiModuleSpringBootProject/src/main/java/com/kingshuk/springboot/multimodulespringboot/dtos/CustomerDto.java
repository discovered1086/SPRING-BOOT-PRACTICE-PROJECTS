package com.kingshuk.springboot.multimodulespringboot.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -209118244565098051L;
	
	private long customerId;
	
	private String firstName;
	
	private String lastName;

}
