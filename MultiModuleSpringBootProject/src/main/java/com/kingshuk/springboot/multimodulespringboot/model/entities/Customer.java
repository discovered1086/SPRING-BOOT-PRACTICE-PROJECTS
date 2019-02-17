package com.kingshuk.springboot.multimodulespringboot.model.entities;

import java.io.Serializable;
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

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7267904589383486101L;

	@Id
	@Column(length = 20, name = "customer_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountSequenceGenerator")
	@GenericGenerator(name="accountSequenceGenerator", strategy="com.kingshuk.springboot.multimodulespringboot.model.sequencegenerators.CustomerSequenceGenerator")
	private long customerId;
	
	@Column(length = 40, name = "first_name")
	private String firstName;
	
	@Column(length = 40, name = "last_name")
	private String lastName;
	
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
			mappedBy = "accountHolder",
			fetch = FetchType.LAZY)
	private List<Account> customerAccounts;

}
