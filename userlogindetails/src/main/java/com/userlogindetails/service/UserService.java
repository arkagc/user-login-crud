package com.userlogindetails.service;

import java.util.List;
import java.util.Optional;

import com.userlogindetails.entity.UserDetails;

public interface UserService {
	
	UserDetails createUsers(UserDetails userDetails); // create user
	List<UserDetails> getAllUsers(); // get all users
	Optional<UserDetails> getAllUsersById(Integer userId); // get users by id
	UserDetails getAllUsersByEmail(String userEmail); // get users by email
	UserDetails updateUsers(Integer userId, UserDetails userDetails); // update users by id
	void deleteById(Integer userId); // delete users by id
	String loginCheck(String username, String password);
}
