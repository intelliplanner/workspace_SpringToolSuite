package com.ipssi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@Entity
//@Data
//@Table(name = "users")
	
public class UserBean {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id")
	private Integer id;
	
//	@Column(name = "name")
	private String name;
	
//	@Column(name = "username")
	private String userName;
	
	@JsonIgnore
//	@Column(name = "password")
	private String password;
}