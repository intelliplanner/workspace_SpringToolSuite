package com.test.java_notes_bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "header_details")
public class HeaderType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	int id;

	@Column(name = "header_type")
	String headerType;

	
	@Column(name = "status")
	int status;

	@Column(name = "created_on", nullable = false, columnDefinition = "datetime default now()")
	Date createdOn;

	@Column(name = "updated_on", nullable = false, columnDefinition = "datetime default now()")
	Date updatedOn;

	@Column(name = "updated_by")
	int updatedBy;
}
