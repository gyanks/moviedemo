package com.stackroute.movieservice.service;

import java.util.List;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.domain.User;
import com.stackroute.movieservice.exception.MovieAlreadyExistsException;
import com.stackroute.movieservice.exception.MovieNotFoundException;
import com.stackroute.movieservice.exception.UserAlreadyExistsException;

public interface UserMovieService {
User saveMovieToFavourites(Movie movie, String userName) throws MovieAlreadyExistsException;
User deleteMovieFromFavourites(String userName,int movieId) throws MovieNotFoundException;
User updateCommentForMovie(String comment,int movieId,String userName) throws MovieNotFoundException;
List<Movie> getAllUserMoviesFromFavourites(String userName) throws Exception;
User registerUser(User user) throws UserAlreadyExistsException;
}
