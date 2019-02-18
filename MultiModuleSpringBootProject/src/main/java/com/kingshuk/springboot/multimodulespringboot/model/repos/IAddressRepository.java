package com.kingshuk.springboot.multimodulespringboot.model.repos;

import com.kingshuk.springboot.multimodulespringboot.model.entities.Address;

public interface IAddressRepository {
	
	Address addNewAddress(Address address);

}