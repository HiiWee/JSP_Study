package com.hoseok.web.entity;

import java.util.Date;

/*
 * ���α׷� ����� ������ ������ �����͵��� ������ ����ϸ�
 * ------> �ݺ��Ǵ� �ڵ� ������, ������ ���� �������, ������ ǥ���Ҷ� �̸� ���� �ٸ� ������ �����Ϳ� �浹 �ذ����� �̸��� �����
 * ���� �����͸� ������ ���⺸�� �����͸� �Ӽ��̶� �̸����� ��ġ�ϰ� �̰� ��� ǥ���ϴ� ����� ���ƺ���
 * -------> request.addAttribute("notice", notice); ----> ��ü�� ����� �����ϸ� �ξ� �� �����ϰ� ���������� ǥ�� ����
 * 
 * ���� ���� ������ ���� ��ü
 * */

// Notice Entity ��ü
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
