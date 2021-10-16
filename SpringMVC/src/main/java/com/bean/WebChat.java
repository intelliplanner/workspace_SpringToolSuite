package com.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "web_chat")
public class WebChat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	
	@NotBlank(message = "Header not blank")
	@Column(name = "header")
	String header;
	
	@NotBlank(message = "author not blank")
	@Column(name = "author")
	
	String author;
	@NotBlank(message = "body not blank")
	@Column(name = "body")
	String body;
	@Column(name = "updated_on")
	Date updated_on = new Date();

	public WebChat() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getUpdated_on() {
		return updated_on;
	}

	public void setUpdated_on(Date updated_on) {
		this.updated_on = updated_on;
	}
}
