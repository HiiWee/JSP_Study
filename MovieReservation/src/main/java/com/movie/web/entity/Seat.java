package com.movie.web.entity;

public class Seat {
	private String seatId;
	private String audiId;
	private boolean pub;
	
	public Seat() {
	}

	public Seat(String seatId, String audiId, boolean pub) {
		super();
		this.seatId = seatId;
		this.audiId = audiId;
		this.pub = pub;
	}

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	public String getAudiId() {
		return audiId;
	}

	public void setAudiId(String audiId) {
		this.audiId = audiId;
	}

	public boolean getPub() {
		return pub;
	}

	public void setPub(boolean pub) {
		this.pub = pub;
	}
	
	
}
