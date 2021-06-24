package com.teamone.postgres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "users")
public class User {

	@Id
	@Column(name = "userid")
	private int userId; 
	
	@Column(name = "username")
	private String username; 
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "profilepicurl")
	private String profilePicUrl;
	
	@Column(name = "linkedinurl")
	private String linkedinUrl;
	
	@Column(name = "facebookurl")
	private String facebookUrl;
	
}
