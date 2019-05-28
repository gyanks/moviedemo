package com.stackroute.movieservice.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
@Id
	private String userName;
    private String email;
    private List<Movie> movieList;
    
    
    
    
	@Override
	public String toString() {
		return "User [userName=" + userName + ", email=" + email + ", movieList=" + movieList + "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Movie> getMovieList() {
		return movieList;
	}
	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}
	public User(String userName, String email, List<Movie> movieList) {
		super();
		this.userName = userName;
		this.email = email;
		this.movieList = movieList;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
