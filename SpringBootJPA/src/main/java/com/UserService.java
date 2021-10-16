package com;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
 
@Autowired 
UserRepository userRepository;


public List<UserRecord>  getAllUsers() {
	List<UserRecord> listUser = new ArrayList<UserRecord>();
	userRepository.findAll().forEach(listUser::add);
	return listUser;
}
public UserRecord getUser(String id) {
	UserRecord user = new UserRecord();
	userRepository.findById(id);
	return user;
} 

public void addUser(UserRecord user) {
	userRepository.save(user);
}
public void delete(String id) {
	userRepository.deleteById(id);
}
}
