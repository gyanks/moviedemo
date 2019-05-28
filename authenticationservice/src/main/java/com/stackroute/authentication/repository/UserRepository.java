package com.stackroute.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.authentication.domain.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	public User findByUserNameAndPassword(String userName,String password);

}
