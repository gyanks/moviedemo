package com.stackroute.authentication.service;

import com.stackroute.authentication.domain.User;
import com.stackroute.authentication.exception.UserNotFoundException;

public interface UserService {

	
	public User saveUser(User user);
	public User findUserByUserNameAndPassword(String userName,String password) throws UserNotFoundException;
}
