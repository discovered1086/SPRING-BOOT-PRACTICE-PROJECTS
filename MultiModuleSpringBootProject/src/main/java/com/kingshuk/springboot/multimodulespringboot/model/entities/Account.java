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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.kingshuk.springboot.multimodulespringboot.model.sequencegenerators.newsequences.NewAccountSequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "account")
@Inheritance(strategy = InheritanceType.JOINED)
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1540097108451574865L;

	@Id
	@Column(length = 20, name = "account_id", updatable = false, insertable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accSequenceGen")
	@GenericGenerator(name = "accSequenceGen", 
			strategy = "com.kingshuk.springboot.multimodulespringboot.model.sequencegenerators.newsequences.NewAccountSequenceGenerator", parameters = {
			@Parameter(name = NewAccountSequenceGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = "stringPrefix", value = "ACC"), @Parameter(name = "numberFormat", value = "%012d") })
	private String accountId;

	@Column(length = 50, name = "account_number")
	private String accountNumber;

	@Column(length = 100, name = "account_title")
	private String accountDesc;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
	private Customer accountHolder;

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "account")
	private List<Transaction> transactionList;
}
