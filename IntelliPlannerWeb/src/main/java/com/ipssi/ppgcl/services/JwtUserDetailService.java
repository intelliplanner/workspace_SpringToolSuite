package com.ipssi.ppgcl.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ipssi.ppgcl.entity.Users;
import com.ipssi.ppgcl.repository.UsersRepoJpa;

@Service
public class JwtUserDetailService implements UserDetailsService {
	
	@Autowired(required = true)
	private UsersRepoJpa usersRepoJpa;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Users> user = usersRepoJpa.findByUserId(username);
		
		if(user==null || user.size()==0)
			return null;
		
		Users data = user.get(0);
		
		return new User(data.getUsername(), data.getPassword(), new ArrayList<>());
	}
	
}