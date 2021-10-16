package com.ipssi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ipssi.config.UserOauthException;
import com.ipssi.dao.UserDao;
import com.ipssi.dto.UserMaster;

@Service
public class JwtUserDetailsService implements UserDetailsService, UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		if ("javainuse".equals(username)) {
//			return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//					new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//	}
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//		UserDetails user = userService.findByUserName(username);
//		if (user == null) {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//				new ArrayList<>());
//	}
//
//	public DAOUser save(UserDTO user) {
//		DAOUser newUser = new DAOUser();
//		newUser.setUsername(user.getUsername());
//		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
//		return userDao.save(newUser);
//	}

	@Override
	public UserDetails findByUserName(String username) throws UsernameNotFoundException {
		return null;
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			if ("javainuse".equals(username)) {
				return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
						new ArrayList<>());
			} else {
				// throw new UsernameNotFoundException("User not found with username: " +
				// username);

				UserMaster user = userDao.findByUsername(username);
				if (user == null) {
					throw new UserOauthException("Invalid username or password.");
				} else {
					return new org.springframework.security.core.userdetails.User(user.getUserName(),
							user.getPassword(), getAuthority());
				}
			}
		} catch (Exception e) {
			throw new UserOauthException("Assign Permission");
		}
	}

	@Override
	public int save(UserMaster user) {
		user.setBcryptPassword(bcryptEncoder.encode(user.getPassword()));
		return userDao.save(user);
	}
}
