package com.stackroute.movieservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackroute.movieservice.domain.User;

public interface UserMovieRepository extends MongoRepository<User,Integer>{

	public User findByUserName(String userName);
}
