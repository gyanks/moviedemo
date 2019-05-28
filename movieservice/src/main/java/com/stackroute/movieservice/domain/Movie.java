package com.stackroute.movieservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Movie {
@Id
private int movieId;
private String name;
private String comments;
private String posterPath;
private String releaseDate;
private int voteCount;
private double voteAverage;
@Override
public String toString() {
	return "movie [movieId=" + movieId + ", name=" + name + ", comments=" + comments + ", posterPath=" + posterPath
			+ ", releaseDate=" + releaseDate + ", voteCount=" + voteCount + ", voteAverage=" + voteAverage + "]";
}
public Movie(int movieId, String name, String comments, String posterPath, String releaseDate, int voteCount,
		double voteAverage) {
	super();
	this.movieId = movieId;
	this.name = name;
	this.comments = comments;
	this.posterPath = posterPath;
	this.releaseDate = releaseDate;
	this.voteCount = voteCount;
	this.voteAverage = voteAverage;
}
public Movie() {
	super();
	// TODO Auto-generated constructor stub
}
public int getMovieId() {
	return movieId;
}
public void setMovieId(int movieId) {
	this.movieId = movieId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getComments() {
	return comments;
}
public void setComments(String comments) {
	this.comments = comments;
}
public String getPosterPath() {
	return posterPath;
}
public void setPosterPath(String posterPath) {
	this.posterPath = posterPath;
}
public String getReleaseDate() {
	return releaseDate;
}
public void setReleaseDate(String releaseDate) {
	this.releaseDate = releaseDate;
}
public int getVoteCount() {
	return voteCount;
}
public void setVoteCount(int voteCount) {
	this.voteCount = voteCount;
}
public double getVoteAverage() {
	return voteAverage;
}
public void setVoteAverage(double voteAverage) {
	this.voteAverage = voteAverage;
}


	
}
