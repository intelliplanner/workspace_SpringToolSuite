package com.ipssi.ppgcl.services;

import com.ipssi.ppgcl.entity.Users;
import com.ipssi.ppgcl.response.MessageResponse;

public interface UserService {
	MessageResponse fetchUserDetails(String username,String password);
	boolean saveUserDetails(Users obj);
	boolean existsByUsername(String username);
	boolean existsByEmail(String email);
}
