package com.hoseok.web.service;

import java.util.ArrayList;
import java.util.List;

import com.hoseok.web.entity.Notice;

public class NoticeService {
//	공지 목록을 반환해주는 메소드 목록
//	코드 집중화 : 매개인자가 가장 많은 메소드를 구현(나머지 메소드들은 오버로드함
	public List<Notice> getNoticeList() {
		
		return getNoticeList("title", "", 1);  //두번째 메소드를 호출하면 스택이 1개 더 쌓임
	}

	public List<Notice> getNoticeList(int page) {
		
		return getNoticeList("title", "", page);
	}

	public List<Notice> getNoticeList(String field, String query, int page) {
		List<Notice> list = new ArrayList<>();
		String url = "jdbc:mysql://127.0.0.1:3306/hoseok";
		String sql = "select * "
				+ "from (select ROW_NUMBER() over(order by n.regdate desc) rownum, n.* from NOTICE n) n2 "
				+ "where n2.rownum between ? and ?";
		return list;
	}

//	목록 개수 반환해주는 메소드
	public int getNoticeCount() {

		return getNoticeCount("title", "");
	}

	public int getNoticeCount(String field, String query) {

		return 0;
	}

//	id값에 대한 공지목록을 반환하는 메소드들
	public Notice getNotice(int id) {
		return null;
	}

//	페이지내에서 이전 다음 공지 목록 반환
	public Notice getNextNotice(int id) {
		return null;
	}

	public Notice getPrevNotice(int id) {
		return null;
	}

}
