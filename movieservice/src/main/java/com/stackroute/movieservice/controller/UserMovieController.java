package com.stackroute.movieservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.domain.User;
import com.stackroute.movieservice.exception.MovieAlreadyExistsException;
import com.stackroute.movieservice.exception.MovieNotFoundException;
import com.stackroute.movieservice.exception.UserAlreadyExistsException;
import com.stackroute.movieservice.service.UserMovieService;

@RestController
@RequestMapping("api/v1/movieservice")
public class UserMovieController {

	private UserMovieService userMovieService;
	private ResponseEntity responseEntity;

	@Autowired
	public UserMovieController(UserMovieService userMovieService) {
		super();
		this.userMovieService = userMovieService;
	}
	
	@PostMapping("/register")
	public ResponseEntity registerUser(@RequestBody User user) throws UserAlreadyExistsException
	{
		try
		{
			userMovieService.registerUser(user);
			responseEntity=new ResponseEntity(user,HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			throw new UserAlreadyExistsException();
		}
		
		return responseEntity;
	}
	
	@PostMapping("/user/{username}/movie")
	public ResponseEntity<?> saveMovieToFavourites(@RequestBody Movie movie,@PathVariable("username") String userName) throws MovieAlreadyExistsException
	{
		try {
		User user=userMovieService.saveMovieToFavourites(movie, userName);
				responseEntity=new ResponseEntity<User>(user,HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	

	@DeleteMapping("/user/{username}/movie")
	public ResponseEntity<?> deleteMovieFromFavourites(@RequestBody Movie movie,@PathVariable("username") String userName) throws  MovieNotFoundException
	{
		try {
		User user=userMovieService.deleteMovieFromFavourites(userName,movie.getMovieId());
				responseEntity=new ResponseEntity<User>(user,HttpStatus.OK);
		}
		catch(MovieNotFoundException e)
		{
			throw new MovieNotFoundException();
		}
		catch(Exception e)
		{
			responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@PutMapping("/user/{username}/movie")
	public ResponseEntity<?> updateCommentForMovie(@RequestBody Movie movie,@PathVariable("username") String userName) throws  MovieNotFoundException
	{
		try {
		User user=userMovieService.updateCommentForMovie(movie.getComments(),movie.getMovieId(), userName);
				responseEntity=new ResponseEntity<Movie>(movie,HttpStatus.OK);
		}
		catch(MovieNotFoundException e)
		{
			throw new MovieNotFoundException();
		}
		catch(Exception e)
		{
			responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	@GetMapping("/user/{username}/movies")
	public ResponseEntity<?> getAllUserMoviesFromFavourites(@PathVariable("username") String userName) 
	{
		try {
		
				responseEntity=new ResponseEntity<List<Movie>>(userMovieService.getAllUserMoviesFromFavourites(userName),HttpStatus.OK);
		}
		
		catch(Exception e)
		{
			System.out.println(e.toString());
			responseEntity=new ResponseEntity<String>(e.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	
}
