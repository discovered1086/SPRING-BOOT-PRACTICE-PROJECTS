package com.kingshuk.springboot.multimodulespringboot.dtos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kingshuk.springboot.multimodulespringboot.entities.Customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8842016159962415832L;

	private long accountId;

	private String accountNumber;

	private String accountDesc;

	private CustomerDto accountHolder;

}
