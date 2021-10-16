package com.ipssi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipssi.dto.UserMaster;
import com.ipssi.mapper.UserMapper;


@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public UserMaster findByUsername(String username) {
//		LOGGER.debug("inside findByUserName OK-A1");
		String SQL_FIND_User = "select * from users where UserName = ? and IsActive=1";
		try {
			return jdbcTemplate.queryForObject(SQL_FIND_User, new Object[] { username },
					new UserMapper());
			
		} catch (Exception e) {
//			LOGGER.error("inside findByUserName GOT ERRRO:"+e.getMessage());
//			LOGGER.error("error:",e);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int save(UserMaster user) {
		String SQL_INSERT_USER_MASTER = "insert into users(name,username,email,password,bcryptPassword,IsActive) values(?,?,?,?,?,1)";
		return jdbcTemplate.update(SQL_INSERT_USER_MASTER, user.getName(),user.getUserName(),user.getEmail(),user.getPassword(),user.getBcryptPassword(),1);
	}
	
}
