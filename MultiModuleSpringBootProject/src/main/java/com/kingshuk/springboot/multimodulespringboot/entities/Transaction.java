package com.kingshuk.springboot.multimodulespringboot.entities;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "transaction")
@Table(name = "account_transaction")
@NoArgsConstructor
@Getter
@Setter
public class Transaction {

	@Id
	@Column(length = 20, name = "transaction_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long transactionId;

	@Column(length = 1000, name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "account_id", referencedColumnName = "account_id", nullable = false)
	private Account account;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
	private Category transactionCategory;
	
	@Column(name = "transaction_date")
	@Type(type="java.sql.Timestamp")
	private ZonedDateTime transactionDate;
	
	}
