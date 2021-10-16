package com.work.interview_preperation.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Topics")

public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	int id;

	@Column(name = "topic_name")
	String topic_name;

	@Column(name = "status")
	int status;

	@Column(name = "created_on", nullable = false, columnDefinition = "datetime default now()")
	Date created_on;

	@Column(name = "updated_on", nullable = false, columnDefinition = "datetime default now()")
	Date updated_on;
	
	@Column(name = "updated_by")
	int updated_by;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopic_name() {
		return topic_name;
	}

	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
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

	
	public TopicExtends getTopic_extended() {
		return topic_extended;
	}

	public void setTopic_extended(TopicExtends topic_extended) {
		this.topic_extended = topic_extended;
	}


	@OneToOne(cascade=CascadeType.ALL)  
	TopicExtends topic_extended;
}
