package com.kingshuk.springboot.multimodulespringboot.controllers;

import javax.annotation.Resource;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kingshuk.springboot.multimodulespringboot.dtos.BankAccountDto;
import com.kingshuk.springboot.multimodulespringboot.dtos.CreditCardAccountDto;
import com.kingshuk.springboot.multimodulespringboot.entities.BankAccount;
import com.kingshuk.springboot.multimodulespringboot.entities.CreditCardAccount;
import com.kingshuk.springboot.multimodulespringboot.repos.IAccountRepository;

@RestController
@RequestMapping("/accounts")
public class AccountRESTController {

	@Resource(name = "dozerBeanMapper")
	private DozerBeanMapper beanMapper;

	@Autowired
	private IAccountRepository accountRepository;
	// Create a method to get all accounts for a customer

	// Create a method to get a single account for a customer

	// Create a method to add a credit card account
	@PostMapping(params = "accountType=1", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CreditCardAccountDto createCreditCardAccount(@RequestBody CreditCardAccountDto accountDto) {
		CreditCardAccount creditCardAccount = beanMapper.map(accountDto, CreditCardAccount.class);

		return beanMapper.map(accountRepository.createAccount(creditCardAccount), CreditCardAccountDto.class);

	}

	// Create a method to add a bank account account
	@PostMapping(params = "accountType=2", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public BankAccountDto createBankAccount(@RequestBody BankAccountDto accountDto) {
		BankAccount bankAccount = beanMapper.map(accountDto, BankAccount.class);

		return beanMapper.map(accountRepository.createAccount(bankAccount), BankAccountDto.class);
	}

	// Create a method to update an account. What we should allow to update

	// Create a method to get all transactions in an account

	// Create a method to get a single transaction in an account

	// Create a method to delete an account

}
