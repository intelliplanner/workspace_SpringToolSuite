package com.ipssi.repository;

import com.ipssi.model.UserBean;
import com.ipssi.model.UserReqDto;


public interface UserRepositoryProvider {
	public UserBean findUserById(UserReqDto reqDto);
	public UserBean loadUserByUserDetails(String username,String password);
}
