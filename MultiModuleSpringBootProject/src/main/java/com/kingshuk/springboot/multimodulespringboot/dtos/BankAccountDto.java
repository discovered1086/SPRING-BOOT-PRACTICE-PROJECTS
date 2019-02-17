package com.kingshuk.springboot.multimodulespringboot.dtos;

import com.kingshuk.springboot.multimodulespringboot.enums.BankAccountType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountDto extends AccountDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4835536223408990008L;
	
	private BankAccountType accountType;

}
