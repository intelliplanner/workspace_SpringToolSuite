package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


//@CrossOrigin(origins="http://localhost:4200")  

@RestController
@RequestMapping(value="/ipssi")  
public class UserController {
	@Autowired
	UserService userService;

//	@RequestMapping("/test/${id}",  )
//	public List<UserRecord> getResult(@PathVariable int id) {
//		List<UserRecord> data =  userService.getAllUsers();
//		return data;
//	}
	
	@RequestMapping("/t")
	public List<UserRecord> getAlluser() {
		List<UserRecord> data =  userService.getAllUsers();
		return data;
	}
	@RequestMapping("/test")
	public String getAlluserTest() {
		List<UserRecord> data =  userService.getAllUsers();
		return "Hello";
	}
	@RequestMapping(value="/xml", method = RequestMethod.GET, produces = "text/xml")
	public List<UserRecord> getAllusers() {
		List<UserRecord> data =  userService.getAllUsers();
		return data;
	}
	
	@RequestMapping("/delete/{id}")
	public void delete(@PathVariable String id) {
		userService.delete(id);
	}
	
	@RequestMapping(value="/add-user", method=RequestMethod.POST)
	public void getUser(@RequestBody UserRecord user){
		userService.addUser(user);
	}
	
	
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	public UserRecord getUser(@PathVariable String id){
		return userService.getUser(id);
	}
}
