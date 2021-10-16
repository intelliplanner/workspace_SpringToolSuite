package com.ipssi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;

import com.ipssi.dto.UserMaster;

public class UserServiceImpl implements UserService{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public UserDetails findByUserName(String username) {
		String query = "Select * from users where username like ?";
		return  null;//jdbcTemplate.execute(query, username);
	}

	@Override
	public int save(UserMaster user) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
