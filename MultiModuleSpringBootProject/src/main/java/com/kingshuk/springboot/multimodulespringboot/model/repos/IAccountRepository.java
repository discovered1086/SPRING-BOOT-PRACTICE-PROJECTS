package com.kingshuk.springboot.multimodulespringboot.model.repos;

import java.util.List;
import java.util.Optional;

import com.kingshuk.springboot.multimodulespringboot.model.entities.Account;

public interface IAccountRepository {

	<T extends Account> T createAccount(T account);

	<T extends Account> Optional<T> getSingleAccount(String accountId);

	List<Account> getAllAccounts(String customerId);

	Account updateAccount(Account account);

	void deleteAccount(String accountId);

}
