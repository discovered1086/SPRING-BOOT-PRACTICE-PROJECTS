package com.kingshuk.webservices.rest.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class UserPost {
	
	@Id
	@GeneratedValue
	private int postId;
	
	private String postMessage;
	
	private LocalDateTime postedAt;
	
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name = "userId", referencedColumnName = "id")
	@JsonIgnore
	private User user;

}
