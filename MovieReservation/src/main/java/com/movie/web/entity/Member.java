package com.movie.web.entity;

public class Member {
	
	private String memberId;
	private String name;
	private String pwd;
	private String phone;
	private boolean auth;
	
	
	public Member() {
	}

	public Member(String memberId, String name, String pwd, String phone, boolean auth) {
		this.memberId = memberId;
		this.name = name;
		this.pwd = pwd;
		this.phone = phone;
		this.auth = auth;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean getAuth() {
		return auth;
	}


	public void setAuth(boolean auth) {
		this.auth = auth;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", name=" + name + ", pwd=" + pwd + ", phone=" + phone + ", auth="
				+ auth + "]";
	}

	
}
