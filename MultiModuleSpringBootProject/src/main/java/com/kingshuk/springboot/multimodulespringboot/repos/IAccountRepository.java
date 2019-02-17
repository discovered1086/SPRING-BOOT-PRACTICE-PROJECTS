package com.kingshuk.springboot.multimodulespringboot.repos;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kingshuk.springboot.multimodulespringboot.entities.Account;


public interface IAccountRepository {
	
	public <T extends Account> T createAccount(T account);
	
	Account getSingleAccount(long accountId);
	
	List<Account> getAllAccounts(long customerId);
	
	Account updateAccount(Account account);
	
	void deleteAccount(long accountId);

}
