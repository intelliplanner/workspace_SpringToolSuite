package com.test.java_notes_bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "topic_extended")
public class TopicExtends {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	int id;

	@Column(name = "updated_by")
	int updatedBy;

	@Column(name = "topic_id")
	private int topicId;

	@Column(name = "sub_topic_name")
	String subTopicName;

	@Column(name = "status")
	int status;

	@Column(name = "created_on", nullable = false, columnDefinition = "datetime default now()")
	Date createdOn;

	@Column(name = "updated_on", nullable = false, columnDefinition = "datetime default now()")
	Date updatedOn;

	@Column(name = "sub_topic_header")
	String sub_topic_header;

	public String getSub_topic_header() {
		return sub_topic_header;
	}

	public void setSub_topic_header(String sub_topic_header) {
		this.sub_topic_header = sub_topic_header;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getSubTopicName() {
		return subTopicName;
	}

	public void setSubTopicName(String subTopicName) {
		this.subTopicName = subTopicName;
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
