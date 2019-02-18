package com.kingshuk.springboot.multimodulespringboot.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kingshuk.springboot.multimodulespringboot.model.entities.Address;
import com.kingshuk.springboot.multimodulespringboot.model.repos.IAddressRepository;

@Service
public class AddressServiceImpl implements IAddressService {
	
	@Autowired
	private IAddressRepository addressRepository;

	@Override
	@Transactional
	public Address addSingleAddress(Address address) {
		return null;
	}

	@Override
	@Transactional
	public Set<Address> addMultipleAddresses(Set<Address> addresses) {
		Set<Address> updatedAddresses = new HashSet<>();
		
		addresses.forEach(address ->
			updatedAddresses.add(addressRepository.addNewAddress(address)));
		
		return updatedAddresses;
	}

}
