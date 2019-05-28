package com.stackroute.movieservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.domain.User;
import com.stackroute.movieservice.exception.MovieAlreadyExistsException;
import com.stackroute.movieservice.exception.MovieNotFoundException;
import com.stackroute.movieservice.exception.UserAlreadyExistsException;
import com.stackroute.movieservice.repository.UserMovieRepository;

@Service
public class UserMovieServiceImpl implements UserMovieService {
	private UserMovieRepository userMovieRepository;
	
	@Autowired
	public UserMovieServiceImpl(UserMovieRepository movieRepository) {
		super();
		this.userMovieRepository = movieRepository;
	}

	
	@Override
	public User registerUser(User user) throws UserAlreadyExistsException {
		User user1=userMovieRepository.findByUserName(user.getUserName());
		if(user1!=null)
		{
			throw new UserAlreadyExistsException();
		}
		else
			userMovieRepository.save(user);
		return user;
	}
	@Override
	public User saveMovieToFavourites(Movie movie, String userName) throws MovieAlreadyExistsException {
		
		User user1=userMovieRepository.findByUserName(userName);
		List<Movie> movieList=user1.getMovieList();
		if(movieList!=null)
		{
			for(Movie movieObj:movieList)
			{
				if(movieObj.getName().equals(movie.getName()))
					throw new MovieAlreadyExistsException();
			}
		
		movieList.add(movie);
		user1.setMovieList(movieList);
		userMovieRepository.save(user1);
		}
		else
		{
			movieList=new ArrayList<>();
			movieList.add(movie);
			user1.setMovieList(movieList);
			userMovieRepository.save(user1);
			
		}
		return user1;
	}

	@Override
	public User deleteMovieFromFavourites(String userName,int movieId) throws MovieNotFoundException {
		User user1=userMovieRepository.findByUserName(userName);
		List<Movie> movieList=user1.getMovieList();
		if(movieList.size()>0)
		{
			for(Movie  movieObj:movieList)
			{
				if(movieObj.getMovieId()==movieId)
				{
					movieList.remove(movieObj);
					user1.setMovieList(movieList);
					userMovieRepository.save(user1);
					break;
				}
			}
		}
		else
		{
			throw new MovieNotFoundException();
		}
		return user1;
	}

	@Override
	public User updateCommentForMovie(String comment, int movieId, String userName) throws MovieNotFoundException {
		User user1=userMovieRepository.findByUserName(userName);
		List<Movie> movieList=user1.getMovieList();
		if(movieList.size()>0)
		{
			for(Movie  movieObj:movieList)
			{
				if(movieObj.getMovieId()==movieId)
				{
					movieObj.setComments(comment);
					
					userMovieRepository.save(user1);
					break;
				}
			}
		}
		else
		{
			throw new MovieNotFoundException();
		}
		return user1;
	}

	@Override
	public List<Movie> getAllUserMoviesFromFavourites(String userName) throws Exception {
	User user=userMovieRepository.findByUserName(userName);
		return user.getMovieList();
	}



}
