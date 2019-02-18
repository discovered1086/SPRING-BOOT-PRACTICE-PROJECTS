package com.kingshuk.springboot.multimodulespringboot.model.repos;

import com.kingshuk.springboot.multimodulespringboot.model.entities.Customer;

public interface ICustomerRepository {
	
	Customer addCustomer(Customer customer);

}
