package com.hoseok.web.entity;

import java.util.Date;

public class NoticeView extends Notice {
	private int cmtCount;

	public NoticeView() {

	}
	
	public NoticeView(int id, String title, String memberId, Date regdate, int hit, String files, boolean pub, int cmtCount) {
		//부모인자에서 넘겨받아옴, content값은 뻇으므로 기본값으로 빈문자 삽입
		super(id, title, memberId, "", regdate, hit, files, pub);
		this.cmtCount = cmtCount;
		
	}
	
	public int getCmtCount() {
		return cmtCount;
	}
	
	public void setCmtCount(int cmtCount) {
		this.cmtCount = cmtCount;
	}
}
