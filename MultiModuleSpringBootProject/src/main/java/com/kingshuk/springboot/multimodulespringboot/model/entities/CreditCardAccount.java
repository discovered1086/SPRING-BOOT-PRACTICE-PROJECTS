package com.kingshuk.springboot.multimodulespringboot.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.kingshuk.springboot.multimodulespringboot.enums.NetWork;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="credit_card_account")
public class CreditCardAccount extends Account{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8036997190322227104L;

	@Column(name="credit_card_number", length=20)
	private String creditCardNumber;
		
	@Enumerated(EnumType.STRING)
	private NetWork netWork;

}
