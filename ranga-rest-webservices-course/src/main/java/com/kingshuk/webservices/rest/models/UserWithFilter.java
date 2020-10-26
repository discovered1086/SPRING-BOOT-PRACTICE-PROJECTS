package com.kingshuk.webservices.rest.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(doNotUseGetters = true)
@Getter
@Setter
@Entity
@ApiModel(description = "This model works as  DTO for a single user",
			value = "Social Media User")
@JsonFilter("SingleUserFetchFilter")
public class UserWithFilter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Size(min = 2, message = "Name should be at least two characters")
	@ApiModelProperty(notes = "name should at least have 2 characters")
	private String name;
	
	@Past
	@ApiModelProperty(notes = "Date of Birth must be in the past")
	private LocalDate dob;
	
	private String ssn;

}
