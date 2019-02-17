package com.kingshuk.springboot.multimodulespringboot.controllers;

import javax.annotation.Resource;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kingshuk.springboot.multimodulespringboot.dtos.AccountDto;
import com.kingshuk.springboot.multimodulespringboot.dtos.BankAccountDto;
import com.kingshuk.springboot.multimodulespringboot.dtos.CreditCardAccountDto;
import com.kingshuk.springboot.multimodulespringboot.entities.Account;
import com.kingshuk.springboot.multimodulespringboot.entities.BankAccount;
import com.kingshuk.springboot.multimodulespringboot.entities.CreditCardAccount;
import com.kingshuk.springboot.multimodulespringboot.errors.AccountNotFoundException;
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
	@GetMapping(path = "/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountDto> getSingleAccount(@PathVariable("accountId") long accountId) throws AccountNotFoundException {
		Account account = accountRepository.getSingleAccount(accountId).
				orElseThrow(AccountNotFoundException::new);

		if (account == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(beanMapper.map(account, AccountDto.class));
	}

	// Create a method to add a credit card account
	@PostMapping(params = "accountType=1", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CreditCardAccountDto> createCreditCardAccount(
			@RequestBody CreditCardAccountDto accountDto) {
		CreditCardAccount creditCardAccount = beanMapper.map(accountDto, CreditCardAccount.class);

		return ResponseEntity
				.ok(beanMapper.map(accountRepository.createAccount(creditCardAccount), CreditCardAccountDto.class));

	}

	// Create a method to add a bank account account
	@PostMapping(params = "accountType=2", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BankAccountDto> createBankAccount(@RequestBody BankAccountDto accountDto) {
		BankAccount bankAccount = beanMapper.map(accountDto, BankAccount.class);

		return ResponseEntity.ok(beanMapper.map(accountRepository.createAccount(bankAccount), BankAccountDto.class));
	}

	// Create a method to update an account. What we should allow to update

	// Create a method to get all transactions in an account

	// Create a method to get a single transaction in an account

	// Create a method to delete an account

}
