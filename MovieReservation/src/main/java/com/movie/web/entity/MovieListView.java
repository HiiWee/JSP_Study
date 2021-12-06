package com.movie.web.entity;

import java.util.Date;

public class MovieListView extends Movie {
	private String scheduleId;
	private Date screenDay;
	private String audiId;
	private int totalSeat;
	
	
	public MovieListView() {
		
	}
	
	public MovieListView(String movieId, String name, String genre, String content, Date openDay, String files, 
			String scheduleId, Date screenDay, String audiId, int totalSeat) {
		super(movieId, name, genre, content, openDay, files);
		this.scheduleId = scheduleId;
		this.screenDay = screenDay;
		this.audiId = audiId;
		this.totalSeat = totalSeat;
	}
	public String getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}
	public Date getScreenDay() {
		return screenDay;
	}
	public void setScreenDay(Date screenDay) {
		this.screenDay = screenDay;
	}
	public String getAudiId() {
		return audiId;
	}
	public void setAudiId(String audiId) {
		this.audiId = audiId;
	}
	public int getTotalSeat() {
		return totalSeat;
	}
	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}
	
	
	
}
