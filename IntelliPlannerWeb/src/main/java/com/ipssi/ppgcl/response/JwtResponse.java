package com.ipssi.ppgcl.response;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	/**
	 * 	Virendra Gupta
	 */
	private static final long serialVersionUID = -2136101834858981728L;
	private final String token;

	public JwtResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return this.token;
	}

}
