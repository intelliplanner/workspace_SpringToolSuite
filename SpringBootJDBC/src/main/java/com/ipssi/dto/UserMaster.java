package com.ipssi.dto;

import java.util.Date;

import javax.validation.constraints.Pattern;

public class UserMaster {

	private int id;
	private String userName;
	private String password;
	private String bcryptPassword;
	private String name;
	@Pattern(regexp = "^[0-9,^]+$|", message = "Mobile number format is invalid.")
	private String phone;
	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~.-]+@[a-zA-Z0-9.-^]+$|", message = "Nodal Officer's Email Id format is invalid.")
	private String Email;
	private int IsActive;
	private int portNodeId;
	private Date createdDate;
	private Date updatedDate;

	public String getBcryptPassword() {
		return bcryptPassword;
	}

	public void setBcryptPassword(String bcryptPassword) {
		this.bcryptPassword = bcryptPassword;
	}

	public int getPortNodeId() {
		return portNodeId;
	}

	public void setPortNodeId(int portNodeId) {
		this.portNodeId = portNodeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getIsActive() {
		return IsActive;
	}

	public void setIsActive(int isActive) {
		IsActive = isActive;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}