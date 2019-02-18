package com.kingshuk.springboot.multimodulespringboot.model.repos;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kingshuk.springboot.multimodulespringboot.model.entities.Address;

@Repository
public class AddressRepositoryImpl implements IAddressRepository {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public Address addNewAddress(Address address) {
		Session session = entityManager.unwrap(Session.class);
		
		String addressId = (String) session.save(address);
		
		return session.get(Address.class, addressId);
	}
	
	

}
