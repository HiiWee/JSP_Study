package com.movie.web.entity;

import java.util.Date;

public class Payment {
	private String payId;
	private String movieId;
	private String method;
	private int totalPrice;
	private Date payDay;
	private String memberId;
	private String audiId;
	private String seatName;
	private String screenDay;

	public Payment() {
	}
	
	public Payment(String payId, String movieId, String method, int totalPrice, Date payDay, String memberId,
			String audiId, String seatName, String screenDay) {
		this.payId = payId;
		this.movieId = movieId;
		this.method = method;
		this.totalPrice = totalPrice;
		this.payDay = payDay;
		this.memberId = memberId;
		this.audiId = audiId;
		this.seatName = seatName;
		this.screenDay = screenDay;
	}

	public String getPayId() {
		return payId;
	}

	public void setPayId(String payId) {
		this.payId = payId;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getPayDay() {
		return payDay;
	}

	public void setPayDay(Date payDay) {
		this.payDay = payDay;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getAudiId() {
		return audiId;
	}

	public void setAudiId(String audiId) {
		this.audiId = audiId;
	}

	public String getSeatName() {
		return seatName;
	}
 

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	public String getScreenDay() {
		return screenDay;
	}

	public void setScreenDay(String screenDay) {
		this.screenDay = screenDay;
	}
	
	@Override
	public String toString() {
		return "Payment [payId=" + payId + ", movieId=" + movieId + ", method=" + method + ", totalPrice=" + totalPrice
				+ ", payDay=" + payDay + ", memberId=" + memberId + ", audiId=" + audiId + ", seatName=" + seatName
				+ ", screenDay=" + screenDay + "]";
	}
	
	
	
}
