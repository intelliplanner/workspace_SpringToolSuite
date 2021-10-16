package com.test.java_notes_bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Topics")
@Inheritance(strategy = InheritanceType.JOINED)
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	int id;

	@Column(name = "topic_name")
	String topicName;

	@Column(name = "status" , columnDefinition = "int default 1")
	int status;

	@Column(name = "created_on", columnDefinition = "datetime default now()")
	Date createdOn;

	@Column(name = "updated_on",  columnDefinition = "datetime default now()")
	Date updatedOn;

	
//	@OneToMany(cascade =CascadeType.ALL, fetch =FetchType.LAZY)
//	List<TopicExtends> topicExtend = new ArrayList<TopicExtends>();
//	
//	public List<TopicExtends> getTopicExtend() {
//		return topicExtend;
//	}
//
//	public void setTopicExtend(List<TopicExtends> topicExtend) {
//		this.topicExtend = topicExtend;
//	}

	@Column(name = "updated_by")
	int updatedBy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

}
