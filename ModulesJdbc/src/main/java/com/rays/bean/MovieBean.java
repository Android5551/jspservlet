package com.rays.bean;

public class MovieBean {
	private int movieId;
	private String title;
	private String genre;
	private int duration;
	private double rating;
	
	/*
	 * 'movie_id', 'int', 'NO', 'PRI', NULL, ''
'title', 'varchar(45)', 'YES', '', NULL, ''
'genre', 'varchar(45)', 'YES', '', NULL, ''
'duration', 'int', 'YES', '', NULL, ''
'rating', 'bigint', 'YES', '', NULL, ''

	 * */
	
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
	public int getMovieId() {
		return movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
	
}
