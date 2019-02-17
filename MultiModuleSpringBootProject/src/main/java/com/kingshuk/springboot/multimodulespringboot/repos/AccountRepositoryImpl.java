package com.kingshuk.springboot.multimodulespringboot.repos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kingshuk.springboot.multimodulespringboot.entities.Account;

@Repository
@Transactional
public class AccountRepositoryImpl implements IAccountRepository {

	private EntityManager entityManager;

	@Autowired
	public AccountRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Account> Optional<T> getSingleAccount(long accountId) {
		Session session = entityManager.unwrap(Session.class);

		return Optional.ofNullable((T) session.get(Account.class, accountId));

	}

	@Override
	public List<Account> getAllAccounts(long customerId) {
		return null;
	}

	@Override
	public Account updateAccount(Account account) {
		return null;
	}

	@Override
	public void deleteAccount(long accountId) {

	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Account> T createAccount(T account) {
		Session session = entityManager.unwrap(Session.class);

		session.saveOrUpdate(account.getAccountHolder());

		Long id = (Long) session.save(account);

		return (T) session.find(Account.class, id);
	}

}
