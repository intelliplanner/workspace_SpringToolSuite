package com.ipssi.ppgcl.requestDto;

import java.io.Serializable;

public class LoginRequest implements Serializable {
	/**
	 * Virendra Gupta
	 */
	private static final long serialVersionUID = 619953827871511361L;
	String username;
	String password;

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

}
