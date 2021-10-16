package com.test.employee.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name="Mobile") 
public class Mobile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	int id;
	
	@Column(name = "mobile_name")
	String mobileName;
	
	@Column(name = "mobile_model_no")
	String mobileModelNo;
}
