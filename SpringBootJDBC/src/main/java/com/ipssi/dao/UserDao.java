package com.ipssi.dao;

import org.springframework.stereotype.Repository;

import com.ipssi.dto.UserMaster;

@Repository
public interface UserDao{
	UserMaster findByUsername(String username);

	int save(UserMaster user);
}
