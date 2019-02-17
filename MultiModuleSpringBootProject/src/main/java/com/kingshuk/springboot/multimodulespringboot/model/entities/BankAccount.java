package com.kingshuk.springboot.multimodulespringboot.model.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.kingshuk.springboot.multimodulespringboot.enums.BankAccountType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="bank_account")
public class BankAccount extends Account{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8606614599902139364L;
	
	
	@Enumerated(EnumType.STRING)
	private BankAccountType accountType;

}
