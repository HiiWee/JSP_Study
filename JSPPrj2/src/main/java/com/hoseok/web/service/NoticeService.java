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
		String sql = "select * "
				+ "from (select ROW_NUMBER() over(order by n.regdate desc) rownum, n.* from NOTICE n) n2 "
				+ "where n2.rownum between ? and ?";
		return 0;
	}

//	id값에 대한 공지목록을 반환하는 메소드들
	public Notice getNotice(int id) {
		String sql = "select * from notice where id = ?";
		return null;
	}

//	페이지내에서 이전 다음 공지 목록 반환
//  현재 ID에 해당하는 ID로 다음 ID를 구해야함
	public Notice getNextNotice(int id) {
		String sql = "select * "
				+ "from ("
				+ "    select ROW_NUMBER() over(order by n.regdate) rownum, n.* "
				+ "    from ( select * "
				+ "            from notice "
				+ "            where regdate > (select regdate "
				+ "                            from notice "
				+ "                            where id = ?)) n) n2 "
				+ "where rownum = 1";
		return null;
	}

	public Notice getPrevNotice(int id) {
		String sql = "select * "
				+ "from ("
				+ "    select ROW_NUMBER() over(order by n.regdate desc) rownum, n.* "
				+ "    from ( select * "
				+ "            from notice "
				+ "            where regdate < (select regdate "
				+ "                            from notice "
				+ "                            where id = 3)) n) n2 "
				+ "where rownum = 1";
		return null;
	}

}
