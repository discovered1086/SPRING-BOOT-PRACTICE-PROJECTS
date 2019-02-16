package com.kingshuk.springboot.multimodulespringboot.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "account")
public class Account {

	@Id
	@Column(length = 20, name = "account_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long accountId;

	@Column(length = 50, name = "account_number")
	private int accountNumber;

	@Column(length = 100, name = "account_title")
	private String accountDesc;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
	private Customer accountHolder;
}
