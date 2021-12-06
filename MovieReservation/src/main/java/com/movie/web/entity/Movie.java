package com.movie.web.entity;

import java.util.Date;

public class Movie {
	private String movieId;
	private String name;
	private String genre;
	private String content;
	private Date openDay;
	private String files;
	
	public Movie() {

	}
	public Movie(String movieId, String name, String genre, String content, Date openDay, String files) {
		this.movieId = movieId;
		this.name = name;
		this.genre = genre;
		this.content = content;
		this.openDay = openDay;
		this.files = files;
	}

	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getOpenDay() {
		return openDay;
	}
	public void setOpenDay(Date openDay) {
		this.openDay = openDay;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", name=" + name + ", genre=" + genre + ", content=" + content
				+ ", openDay=" + openDay + ", files=" + files + "]";
	}

	
}
