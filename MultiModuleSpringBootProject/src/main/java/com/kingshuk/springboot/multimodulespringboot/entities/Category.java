package com.kingshuk.springboot.multimodulespringboot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transaction_category")
@Getter
@Setter
public class Category {

	@Id
	@Column(length = 20, name = "category_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long categoryId;

	@Column(length = 60, name = "category_name")
	private String categoryName;

	@Column(length = 100, name = "category_description")
	private String categoryDesc;

}
