package com.kingshuk.springboot.multimodulespringboot.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kingshuk.springboot.multimodulespringboot.errors.AccountNotFoundException;
import com.kingshuk.springboot.multimodulespringboot.model.entities.Account;
import com.kingshuk.springboot.multimodulespringboot.model.entities.Address;
import com.kingshuk.springboot.multimodulespringboot.model.entities.Customer;
import com.kingshuk.springboot.multimodulespringboot.model.repos.IAccountRepository;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private IAccountRepository accountRepository;
	
	@Autowired
	private IAddressService addressService;
	
	@Autowired
	private ICustomerService customerService;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public <T extends Account> T createAccount(T account) {
		Set<Address> updatedAddresses = addressService.addMultipleAddresses(account.getAccountHolder().getAddressList());
		
		Customer customer = customerService.saveCustomer(account.getAccountHolder());
		
		customer.setAddressList(updatedAddresses);
		
		account.setAccountHolder(customer);
		
		return accountRepository.createAccount(account);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public Account getSingleAccount(String accountId) throws AccountNotFoundException {
		return accountRepository.getSingleAccount(accountId).orElseThrow(AccountNotFoundException::new);
	}

	@Override
	public List<Account> getAllAccounts(String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account updateAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccount(String accountId) {
		// TODO Auto-generated method stub

	}

}
