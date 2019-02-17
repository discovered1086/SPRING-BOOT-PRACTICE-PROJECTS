package com.kingshuk.springboot.multimodulespringboot.dtos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

	private String accountId;

	private String accountNumber;

	private String accountDesc;

	private CustomerDto accountHolder;

}
