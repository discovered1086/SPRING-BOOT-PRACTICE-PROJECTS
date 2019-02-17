package com.kingshuk.springboot.multimodulespringboot.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kingshuk.springboot.multimodulespringboot.enums.NetWork;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditCardAccountDto extends AccountDto{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 432206124906470403L;

	private String creditCardNumber;
		
	private NetWork netWork;

}
