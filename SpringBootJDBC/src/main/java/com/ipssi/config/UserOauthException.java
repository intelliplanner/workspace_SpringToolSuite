package com.ipssi.config;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ipssi.exception.OAuth2Exception;

@JsonSerialize(using = CustomOauthExceptionSerializer.class)
public class UserOauthException extends OAuth2Exception  {

	private static final long serialVersionUID = 1L;

	public UserOauthException(String msg) {
		super(msg);
	}
}
