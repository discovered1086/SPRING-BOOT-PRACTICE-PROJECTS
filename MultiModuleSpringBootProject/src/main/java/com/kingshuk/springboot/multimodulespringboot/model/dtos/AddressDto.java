package com.kingshuk.springboot.multimodulespringboot.model.dtos;

import java.io.Serializable;
import java.util.Set;

import com.kingshuk.springboot.multimodulespringboot.model.entities.Customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1862330654264823048L;

	private String addressId;
	
	private String addressLine1, addressLine2, city, state, zipCode;
	

	@Override
	public String toString() {
		return "AddressDto [addressId=" + addressId + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + "]";
	}
	
	

}
