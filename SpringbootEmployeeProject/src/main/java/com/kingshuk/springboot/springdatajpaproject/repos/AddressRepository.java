package com.kingshuk.springboot.springdatajpaproject.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.kingshuk.springboot.springdatajpaproject.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	public Optional<Address> findByAddressLine1AndAddressLine2AndCityAndStateAndZipCode(String addessLine1, String addressLine2,
			String city, String state, String zipCode);
}
