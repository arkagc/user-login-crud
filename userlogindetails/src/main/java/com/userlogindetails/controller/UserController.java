package com.userlogindetails.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userlogindetails.entity.UserDetails;
import com.userlogindetails.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// create users
	// http://localhost:9092/api/users
	@PostMapping
	public UserDetails createData(@RequestBody UserDetails userDetails) {
		UserDetails createUsers = userService.createUsers(userDetails);
		return createUsers;
	}
	
	// get all users
	// http://localhost:9092/api/users
	@GetMapping
	public List<UserDetails> getAllData(){
		List<UserDetails> allUsers = userService.getAllUsers();
		return allUsers;
	}
	
	// get users by id
	// http://localhost:9092/api/users/id/id
	@GetMapping("/id/{id}")
	public Optional<UserDetails> getUserDataById(@PathVariable int id) {
		Optional<UserDetails> usersById = userService.getAllUsersById(id);
		return usersById;
	}
	
	// get users by email
	// http://localhost:9092/api/users/email/email
	@GetMapping("/email/{email}")
	public UserDetails getUserDataByEmail(@PathVariable String email) {
		UserDetails allUsersByEmail = userService.getAllUsersByEmail(email);
		return allUsersByEmail;
	}
	
	// update user
	// http://localhost:9092/api/users/id
	@PutMapping("/{id}")
	public UserDetails updateUserData(@PathVariable int id, @RequestBody UserDetails userDetails) {
		UserDetails updateUsers = userService.updateUsers(id, userDetails);
		return updateUsers;
	}
	
	// delete user by id
	// http://localhost:9092/api/users/id
	@DeleteMapping("/{id}")
	public void deleteUserData(@PathVariable int id) {
		userService.deleteById(id);
	}
	
	// check login through username and password
	// http://localhost:9092/api/users/login
	@PostMapping("/login")
	public String checkLogin(@RequestBody UserDetails userDetails) {
		return userService.loginCheck(userDetails.getUserName(), userDetails.getUserPass());
	}
}
