package com.ipssi.ppgcl.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.ipssi.ppgcl.entity.Users;
import com.ipssi.ppgcl.repository.UsersRepoJpa;
import com.ipssi.ppgcl.response.MessageResponse;
import com.ipssi.ppgcl.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UsersRepoJpa usersRepoJpa;

	@Override
	public MessageResponse fetchUserDetails(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveUserDetails(Users obj) {
		usersRepoJpa.insertUser(obj.getUsername(), obj.getName(), obj.getPassword(), obj.getCreatedOn(), obj.getEmail(),
				obj.getIsActive());

		return true;
	}

	@Override
	public boolean existsByUsername(String userId) {
		List<Users> obj = usersRepoJpa.findByUserId(userId);
		if (obj == null || obj.size() == 0)
			return false;

		return true;
	}

	@Override
	public boolean existsByEmail(String email) {
		List<Users> obj = usersRepoJpa.findByEmail(email);
		if (obj == null || obj.size() == 0)
			return false;
		return true;
	}

}
