package com.hoseok.web.entity;

import java.util.Date;

/*
 * 프로그램 만들며 낱개로 설정된 데이터들을 낱개로 사용하면
 * ------> 반복되는 코드 많아짐, 데이터 구분 어려워짐, 데이터 표현할때 이름 명명시 다른 개념의 데이터와 충돌 해결위해 이름이 길어짐
 * 따라서 데이터를 낱개로 보기보다 데이터를 속성이란 이름으로 대치하고 이걸 묶어서 표현하는 방식이 좋아보임
 * -------> request.addAttribute("notice", notice); ----> 객체를 만들어 전달하면 훨씬 더 간단하고 직관적으로 표현 가능
 * 
 * 위와 같은 이유로 만든 객체
 * */

// Notice Entity 객체
public class Notice {
	private int id;
	private String title;
	private String memberId;
	private String content;
	private Date regdate;
	private int hit;
	private String files;
	
	
	public Notice() {
		
	}
	public Notice(int id, String title, String memberId, String content, Date regdate, int hit, String files) {
		this.id = id;
		this.title = title;
		this.memberId = memberId;
		this.content = content;
		this.regdate = regdate;
		this.hit = hit;
		this.files = files;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getFiles() {
		return files;
	}
	public void setFiles(String files) {
		this.files = files;
	}
	
	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", memberId=" + memberId + ", content=" + content
				+ ", regdate=" + regdate + ", hit=" + hit + ", files=" + files + "]";
	}

	
}
