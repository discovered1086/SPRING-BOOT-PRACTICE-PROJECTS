package com.kingshuk.springboot.multimodulespringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kingshuk.springboot.multimodulespringboot.model.entities.Customer;
import com.kingshuk.springboot.multimodulespringboot.model.repos.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private ICustomerRepository customerRespository;

	@Override
	@Transactional
	public Customer saveCustomer(Customer customer) {
		return customerRespository.addCustomer(customer);
	}

}
