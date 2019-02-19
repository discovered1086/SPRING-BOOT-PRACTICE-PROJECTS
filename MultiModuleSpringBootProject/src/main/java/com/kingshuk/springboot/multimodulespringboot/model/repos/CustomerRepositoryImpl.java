package com.kingshuk.springboot.multimodulespringboot.model.repos;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kingshuk.springboot.multimodulespringboot.model.entities.Customer;
/**
 * We're going to use JPA API in this class
 * @author kingshuksmacbookpro
 *
 */
@Repository
public class CustomerRepositoryImpl implements ICustomerRepository {
	
	@Autowired
	private EntityManager entityManager;

	/*@Override
	public Customer addCustomer(Customer customer) {
		Session session = entityManager.unwrap(Session.class);
		
		String customerId = (String) session.save(customer);
		
		return session.get(Customer.class, customerId);
	}*/
	
	public Customer addCustomer(Customer customer) {
		//Customer mergedCustomer = entityManager.merge(customer);
		
		//customer.setCustomerId(mergedCustomer.getCustomerId());
		
		return entityManager.merge(customer);
	}

}
