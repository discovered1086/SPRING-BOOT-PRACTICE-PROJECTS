package com.kingshuk.springboot.multimodulespringboot.service;

import java.util.Set;

import com.kingshuk.springboot.multimodulespringboot.model.entities.Address;

public interface IAddressService {
	
	Address addSingleAddress(Address address);
	
	Set<Address> addMultipleAddresses(Set<Address> addresses);

}
