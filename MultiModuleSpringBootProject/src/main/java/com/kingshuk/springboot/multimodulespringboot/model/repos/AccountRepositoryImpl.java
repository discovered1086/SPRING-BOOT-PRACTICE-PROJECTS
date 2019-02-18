package com.kingshuk.springboot.multimodulespringboot.model.repos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kingshuk.springboot.multimodulespringboot.model.entities.Account;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class AccountRepositoryImpl implements IAccountRepository {

	private EntityManager entityManager;

	@Autowired
	public AccountRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Account> Optional<T> getSingleAccount(String accountId) {
		Session session = entityManager.unwrap(Session.class);

		return Optional.ofNullable((T) session.get(Account.class, accountId));

	}

	@Override
	public List<Account> getAllAccounts(String customerId) {
		return null;
	}

	@Override
	public Account updateAccount(Account account) {
		return null;
	}

	@Override
	public void deleteAccount(String accountId) {

	}

	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Override public <T extends Account> T createAccount(T account) { Session
	 * session = entityManager.unwrap(Session.class);
	 * 
	 * log.info(String.format("The session value is %s",session));
	 * 
	 * account.getAccountHolder().getAddressList().forEach(session::saveOrUpdate);
	 * 
	 * session.saveOrUpdate(account.getAccountHolder());
	 * 
	 * String id = (String) session.save(account);
	 * 
	 * return (T) session.find(Account.class, id); }
	 */

	@SuppressWarnings("unchecked")
	public <T extends Account> T createAccount(T account) {
		Session session = entityManager.unwrap(Session.class);

		String id = (String) session.save(account);

		return (T) session.find(Account.class, id);
	}

}
