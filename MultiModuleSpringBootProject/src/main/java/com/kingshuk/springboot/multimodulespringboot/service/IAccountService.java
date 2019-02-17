package com.kingshuk.springboot.multimodulespringboot.service;

import java.util.List;

import com.kingshuk.springboot.multimodulespringboot.errors.AccountNotFoundException;
import com.kingshuk.springboot.multimodulespringboot.model.entities.Account;

public interface IAccountService {

	<T extends Account> T createAccount(T account);

	Account getSingleAccount(String accountId) throws AccountNotFoundException;

	List<Account> getAllAccounts(String customerId);

	Account updateAccount(Account account);

	void deleteAccount(String accountId);

}
