package com.userlogindetails.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userlogindetails.entity.UserDetails;
import com.userlogindetails.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;

	// create users
	@Override
	public UserDetails createUsers(UserDetails userDetails) {
		UserDetails saveData = userRepo.save(userDetails);
		return saveData;
	}
	
	// get all users
	@Override
	public List<UserDetails> getAllUsers() {
		List<UserDetails> findAllUsers = userRepo.findAll();
		return findAllUsers;
	}

	// get user by id
	@Override
	public Optional<UserDetails> getAllUsersById(Integer userId) {
		Optional<UserDetails> findById = userRepo.findById(userId);
		return findById;
	}

	// get users by email
	@Override
	public UserDetails getAllUsersByEmail(String userEmail) {
		UserDetails allUsersByEmail = userRepo.findByUserEmail(userEmail);
		return allUsersByEmail;
	}

	// update users by id
	@Override
	public UserDetails updateUsers(Integer userId, UserDetails userDetails) {
		Optional<UserDetails> byId = userRepo.findById(userId);
		if(byId.isPresent()) {
			UserDetails details = byId.get();
			details.setUserName(userDetails.getUserName());
			details.setUserPass(userDetails.getUserPass());
			details.setUserEmail(userDetails.getUserEmail());
			return userRepo.save(details);
		}
		return null;
	}

	// delete users by id
	@Override
	public void deleteById(Integer userId) {
		userRepo.deleteById(userId);
	}

	
	@Override
    public String loginCheck(String userName, String userPass) {
        Optional<UserDetails> user = userRepo.findByUserNameAndUserPass(userName, userPass);
        if (user.isPresent()) {
            return "Login successful";
        }
        return "Login failed. Invalid username or password.";
    }
}
