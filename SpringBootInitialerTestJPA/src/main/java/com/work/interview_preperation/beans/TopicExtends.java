package com.work.interview_preperation.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "topic_extended")
public class TopicExtends {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	int id;

	@Column(name = "sub_topic_name")
	String sub_topic_name;

	@Column(name = "status")
	int status;

	@Column(name = "created_on", nullable = false, columnDefinition = "datetime default now()")
	Date created_on;

	@Column(name = "updated_on", nullable = false, columnDefinition = "datetime default now()")
	Date updated_on;

	@Column(name = "updated_by")
	int updated_by;

	@ManyToOne(cascade=CascadeType.ALL)  
	@Column(name = "topic_id")
	int topic_id;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	public Date getUpdated_on() {
		return updated_on;
	}

	public void setUpdated_on(Date updated_on) {
		this.updated_on = updated_on;
	}

	public int getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(int updated_by) {
		this.updated_by = updated_by;
	}

	
}
