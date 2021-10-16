package com.ipssi.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ipssi.model.UserBean;
import com.ipssi.model.UserReqDto;



@Repository
public class UserRepositoryProviderImpl implements UserRepositoryProvider {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public UserBean findUserById(UserReqDto reqDto) {
		// TODO Auto-generated method stub
//		jdbcTemplate.execute(action)
		return null;
	}

	@Override
	public UserBean loadUserByUserDetails(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}


}
