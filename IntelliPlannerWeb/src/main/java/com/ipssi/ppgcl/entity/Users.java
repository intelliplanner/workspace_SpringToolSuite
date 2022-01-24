package com.ipssi.ppgcl.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "username", "password" }) })
public class Users implements Serializable {
	/**
	 * Virendra Gupta
	 */
	private static final long serialVersionUID = -9087222933990356824L;
	
	
	public Users() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "username")
	private String username;
	@Column(name = "name")
	private String name;
	@Column(name = "password")
	private String password;
	@Column(name = "ISACTIVE")
	private boolean isActive;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "port_node_id")
	private String portNodeId;
	@Column(name = "created_on")
	private Date createdOn;

	public Users(String username, String name, String password, boolean isActive, String email, String portNodeId,
			Date createdOn) {
		super();
		this.username = username;
		this.name = name;
		this.password = password;
		this.isActive = isActive;
		this.email = email;
		this.portNodeId = portNodeId;
		this.createdOn = createdOn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPortNodeId() {
		return portNodeId;
	}

	public void setPortNodeId(String portNodeId) {
		this.portNodeId = portNodeId;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

}
