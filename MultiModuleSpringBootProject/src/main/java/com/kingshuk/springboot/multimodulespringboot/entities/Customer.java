package com.kingshuk.springboot.multimodulespringboot.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@Column(length = 20, name = "customer_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long customerId;
	
	@Column(length = 40, name = "first_name")
	private String firstName;
	
	@Column(length = 40, name = "last_name")
	private String lastName;
	
	@OneToMany(cascade = CascadeType.PERSIST,
			mappedBy = "accountHolder",
			fetch = FetchType.LAZY)
	private List<Account> customerAccounts;

}
