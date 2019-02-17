package com.kingshuk.springboot.multimodulespringboot.repos;

import java.util.List;
import java.util.Optional;

import com.kingshuk.springboot.multimodulespringboot.entities.Account;


public interface IAccountRepository {
	
	public <T extends Account> T createAccount(T account);
	
	<T extends Account> Optional<T> getSingleAccount(long accountId);
	
	List<Account> getAllAccounts(long customerId);
	
	Account updateAccount(Account account);
	
	void deleteAccount(long accountId);

}
