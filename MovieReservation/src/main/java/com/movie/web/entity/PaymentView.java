package com.movie.web.entity;

import java.util.Date;

public class PaymentView extends Payment{
	private String name;

	
	
	public PaymentView() {
	}
	
	public PaymentView(String payId, String movieId, String method, int totalPrice, Date payDay, String memberId,
			String audiId, String seatName, String screenDay, String name) {
		super(payId, movieId, method, totalPrice, payDay, memberId,
				audiId, seatName, screenDay);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
