package com.ipssi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	PasswordEncoder encoder;

	@RequestMapping({ "/login" })
	public String firstPage() {
		return "Token World";
	}

	@PostMapping("/getEncodedPassword")
	public String getEncodeedPassword(String username, String pwd) {
		String passwd = encoder.encode(username + pwd);
		System.out.println(passwd);
		return passwd;
	}
}
