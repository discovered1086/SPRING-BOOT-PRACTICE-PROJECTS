package com.kingshuk.springboot.multimodulespringboot.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transaction_category")
@Getter
@Setter
public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7223290830168812286L;

	@Id
	@Column(length = 20, name = "category_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountSequenceGenerator")
	@GenericGenerator(name="accountSequenceGenerator", strategy="com.kingshuk.springboot.multimodulespringboot.model.sequencegenerators.CategorySequenceGenerator")
	private long categoryId;

	@Column(length = 60, name = "category_name")
	private String categoryName;

	@Column(length = 100, name = "category_description")
	private String categoryDesc;

}
