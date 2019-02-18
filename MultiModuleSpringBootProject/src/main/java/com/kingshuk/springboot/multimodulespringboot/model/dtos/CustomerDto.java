package com.kingshuk.springboot.multimodulespringboot.model.dtos;

import java.io.Serializable;
import java.util.Set;

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
	
	private String customerId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phoneNumber;
	
	private Set<AddressDto> addressList;

}
