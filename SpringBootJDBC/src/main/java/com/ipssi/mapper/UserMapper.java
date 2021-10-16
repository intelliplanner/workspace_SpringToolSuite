package com.ipssi.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipssi.dto.UserMaster;

public class UserMapper implements RowMapper<UserMaster> {

	@Override
	public UserMaster mapRow(ResultSet rs, int arg1) throws SQLException {
		UserMaster user = new UserMaster();
		user.setId(rs.getInt("id"));
		user.setUserName(rs.getString("UserName"));
		user.setPassword(rs.getString("Password"));
		user.setBcryptPassword(rs.getString("bcryptPassword"));
		user.setName(rs.getString("Name"));
		user.setEmail(rs.getString("Email"));
		user.setIsActive(rs.getInt("IsActive"));
		user.setPortNodeId(rs.getInt("port_node_id"));
		user.setCreatedDate(rs.getDate("created_on"));
		user.setUpdatedDate(rs.getDate("updated_ON"));
		return user;
	}
}