package com.test.java_notes_bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "topic_extend_content")
public class TopicExtendContent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	int id;

	@Column(name = "topic_header")
	String topicHeader;

	@Column(name = "topic_prev")
	int topicPrev;

	@Column(name = "topic_next")
	int topicNext;

	@Length(max=65000)
	@Column(name = "topic_content")
	String topicContent;

	@Column(name = "status")
	int status;

	@Column(name = "created_on", nullable = false, columnDefinition = "datetime default now()")
	Date createdOn;

	@Column(name = "updated_on", nullable = false, columnDefinition = "datetime default now()")
	Date updatedOn;

	@Column(name = "updated_by")
	int updatedBy;

	@Column(name = "topic_extend_id")
	int topicExtendId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopicHeader() {
		return topicHeader;
	}

	public void setTopicHeader(String topicHeader) {
		this.topicHeader = topicHeader;
	}

	public int getTopicPrev() {
		return topicPrev;
	}

	public void setTopicPrev(int topicPrev) {
		this.topicPrev = topicPrev;
	}

	public int getTopicNext() {
		return topicNext;
	}

	public void setTopicNext(int topicNext) {
		this.topicNext = topicNext;
	}

	public String getTopicContent() {
		return topicContent;
	}

	public void setTopicContent(String topicContent) {
		this.topicContent = topicContent;
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

	public int getTopicExtendId() {
		return topicExtendId;
	}

	public void setTopicExtendId(int topicExtendId) {
		this.topicExtendId = topicExtendId;
	}

}
