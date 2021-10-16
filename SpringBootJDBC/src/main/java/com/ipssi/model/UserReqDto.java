package com.ipssi.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserReqDto implements Serializable{
	/**
	 * Virendra Gupta
	 */
	public static final long serialVersionUID = -8252418922855991376L;
	public String name;
	public String username;
	public String password;
	public String email;
	public int isActive;
	public int portNodeId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public int getPortNodeId() {
		return portNodeId;
	}
	public void setPortNodeId(int portNodeId) {
		this.portNodeId = portNodeId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}