package com.userlogindetails.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userlogindetails.entity.UserDetails;

@Repository
public interface UserRepo extends JpaRepository<UserDetails, Integer>{
	
	UserDetails findByUserEmail(String userEmail); // get users by email
	//UserDetails findByUsernameAndPassword(String username, String password); // check username password
	Optional<UserDetails> findByUserNameAndUserPass(String userName, String userPass);
}
