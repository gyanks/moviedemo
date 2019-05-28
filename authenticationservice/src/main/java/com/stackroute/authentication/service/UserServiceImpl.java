package com.stackroute.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.authentication.domain.User;
import com.stackroute.authentication.exception.UserNotFoundException;
import com.stackroute.authentication.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
		
	}

	@Override
	public User findUserByUserNameAndPassword(String userName,String password) throws UserNotFoundException {
		// TODO Auto-generated method stub
		//System.out.println("Before fetching");
		User user=userRepository.findByUserNameAndPassword(userName, password);
		//System.out.println("name:"+user.getUserName());
		
		if(user==null)
		{
			throw new UserNotFoundException();
		}
	
		return user;
	}

}
