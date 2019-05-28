package com.stackroute.authentication.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.authentication.domain.User;
import com.stackroute.authentication.exception.UserNotFoundException;
import com.stackroute.authentication.service.SecurityTokenGenerator;
import com.stackroute.authentication.service.UserService;

@RestController
@RequestMapping("api/v1/userservice")
public class UserController {
	ResponseEntity responseEntity;
	private SecurityTokenGenerator securityTokenGenerator;
	private UserService userService;

	@Autowired
	public UserController(SecurityTokenGenerator securityTokenGenerator, UserService userService) {
		super();
		this.securityTokenGenerator = securityTokenGenerator;
		this.userService = userService;
	}

	@PostMapping("/save")
	public ResponseEntity saveUser(@RequestBody User user) {
		userService.saveUser(user);
		return responseEntity = new ResponseEntity(user, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity logiUser(@RequestBody User user) throws UserNotFoundException
	{
		Map<String,String> map=null;
		try {
		User user1=userService.findUserByUserNameAndPassword(user.getUserName(), user.getPassword());
		if(user1.getUserName().equals(user.getUserName()))
				{
			map=securityTokenGenerator.generateToken(user);
				}
		 responseEntity=new ResponseEntity(map,HttpStatus.CREATED);
	}
	catch(UserNotFoundException e)
	{
		throw new UserNotFoundException();
	}
		catch(Exception e)
		{
			return  new ResponseEntity("Try after sometime"+e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	return responseEntity;
}
	
}
