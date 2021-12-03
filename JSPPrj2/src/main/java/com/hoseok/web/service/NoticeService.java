package com.hoseok.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hoseok.web.entity.Notice;
import com.hoseok.web.entity.NoticeView;

public class NoticeService {
	/* 사용자가 이용하는 공지사항 페이지 메소드 */	
	
	
	// 공지 목록을 반환해주는 메소드 목록
	// 코드 집중화 : 매개인자가 가장 많은 메소드를 구현(나머지 메소드들은 오버로드함
	public List<NoticeView> getNoticeViewList() {
		
		// 두번째 메소드를 호출하면 스택이 1개 더 쌓임
		return getNoticeViewList("title", "", 1);  
	}

	public List<NoticeView> getNoticeViewList(int page) {
		
		return getNoticeViewList("title", "", page);
	}

	public List<NoticeView> getNoticeViewList(String field, String query, int page) {
		
		List<NoticeView> list = new ArrayList<>();
		
		String url = "jdbc:mysql://127.0.0.1:3306/hoseok";
		String sql = "select * "
				+ "from (select ROW_NUMBER() over(order by n.regdate desc) rownum, n.* from NOTICE_VIEW n "
				+ "where " + field + " like ?) n2 "
				+ "where n2.rownum between ? and ?";
				// field를 값을 세팅하듯 ?와 st.setString()을 이용해 값을 넣으면 양쪽에 홑따옴표 입력됨 'TITLE'
				// 하지만 TITLE은 값이 아니므로 문자열 더하기를 이용한다.\
		
		//TODO 페이지변수로 볌위 구하기
			//1, 11, 21, 31 -> an = 1 + (page - 1) * 10
			//10, 20, 30, 40 -> page * 10
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "hoseok", "!dlghtjr4948");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			st.setInt(2, 1 + (page - 1) * 10);
			st.setInt(3, page * 10);
			
			
			ResultSet rs = st.executeQuery();
			
			
			while(rs.next()) { 
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String memberId = rs.getString("memberId");
				Date regdate = rs.getDate("regdate");
				int hit = rs.getInt("hit");
				String files = rs.getString("files");
				int cmtCount = rs.getInt("cmt_count");
				
				NoticeView notice = new NoticeView(
						id,
						title,
						memberId,
						regdate,
						hit,
						files,
						// content, --> 용량문제로 뷰에서 삭제
						cmtCount
						);
				
				// 목록을 위해 리스트 객체에 담아놓음
				list.add(notice);
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	
	
	// 목록 개수 반환해주는 메소드
	public int getNoticeCount() {

		return getNoticeCount("title", "");
	}

	public int getNoticeCount(String field, String query) {
		String sql = "select count(id) count "
					+ "from (select ROW_NUMBER() over(order by n.regdate desc) rownum, n.* from NOTICE n "
					+ "where " + field + " like ?) n2 ";
		String url = "jdbc:mysql://127.0.0.1:3306/hoseok";
		int count = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "hoseok", "!dlghtjr4948");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, "%" + query + "%");
			
			ResultSet rs = st.executeQuery();
			
			if (rs.next())
				count = rs.getInt("count");
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	// id값에 대한 공지목록을 반환하는 메소드들
	public Notice getNotice(int id) {

		Notice notice = null;
		String sql = "select * from notice where id = ?";
		String url = "jdbc:mysql://127.0.0.1:3306/hoseok";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "hoseok", "!dlghtjr4948");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			
			ResultSet rs = st.executeQuery();
			
			
			if (rs.next()) { 
				int nid = rs.getInt("id");
				String title = rs.getString("title");
				String memberId = rs.getString("memberId");
				String content = rs.getString("content");
				Date regdate = rs.getDate("regdate");
				int hit = rs.getInt("hit");
				String files = rs.getString("files");
				
				notice = new Notice(
						nid,
						title,
						memberId,
						content,
						regdate,
						hit,
						files
						);
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notice;
	}

	// 페이지내에서 이전 다음 공지 목록 반환
	// 현재 ID에 해당하는 ID로 다음 ID를 구해야함
	public Notice getNextNotice(int id) {
		Notice notice = null;
		String url = "jdbc:mysql://127.0.0.1:3306/hoseok";
		String sql = "select id "
				+ "from ("
				+ "    select ROW_NUMBER() over(order by n.regdate) rownum, n.* "
				+ "    from ( select * "
				+ "            from notice "
				+ "            where regdate > (select regdate "
				+ "                            from notice "
				+ "                            where id = ?)) n) n2 "
				+ "where rownum = 1";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "hoseok", "!dlghtjr4948");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			
			ResultSet rs = st.executeQuery();
			
			
			if (rs.next()) { 
				int nid = rs.getInt("id");
				String title = rs.getString("title");
				String memberId = rs.getString("memberId");
				String content = rs.getString("content");
				Date regdate = rs.getDate("regdate");
				int hit = rs.getInt("hit");
				String files = rs.getString("files");
				
				notice = new Notice(
						nid,
						title,
						memberId,
						content,
						regdate,
						hit,
						files
						);
				
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notice;
	}

	public Notice getPrevNotice(int id) {

		Notice notice = null;
		
		String url = "jdbc:mysql://127.0.0.1:3306/hoseok";
		String sql = "select id "
				+ "from ("
				+ "    select ROW_NUMBER() over(order by n.regdate desc) rownum, n.* "
				+ "    from ( select * "
				+ "            from notice "
				+ "            where regdate < (select regdate "
				+ "                            from notice "
				+ "                            where id = ?)) n) n2 "
				+ "where rownum = 1";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "hoseok", "!dlghtjr4948");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			
			ResultSet rs = st.executeQuery();
			
			
			if (rs.next()) { 
				int nid = rs.getInt("id");
				String title = rs.getString("title");
				String memberId = rs.getString("memberId");
				String content = rs.getString("content");
				Date regdate = rs.getDate("regdate");
				int hit = rs.getInt("hit");
				String files = rs.getString("files");
				
				notice = new Notice(
						nid,
						title,
						memberId,
						content,
						regdate,
						hit,
						files
						);
				
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notice;
	}

	/*  관리자 기능 메소드 */
	
	// 몇개가 공개 되었는지 반환
	public int pubNoticeAll(int[] ids) {
		
		return 0;
	}
	// 몇개가 삭제 됐는지 반환
 	public int removeNoticeAll(int[] ids) {
 		int result = 0;
		String params = "";
		
		// params 변수에 id를 담음
		for (int i = 0; i < ids.length; i++) {
			params += ids;
			// ( 1, 2, 3, ) < 이렇게 들어가면 SQL문법오류 이므로 조건처리 
			if (i + 1 < ids.length)
				params += ",";
		}
		
 		String url = "jdbc:mysql://127.0.0.1:3306/hoseok";
		String sql = "delete * from noticec where id in (" + params + ")";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "hoseok", "!dlghtjr4948");
			Statement st = con.createStatement();
			
			
			result = st.executeUpdate(sql);
			
			
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		return result;
 	}
 	// 행이 삽입됐는지 반환 (영향을 준 레코드 개수)
 	public int insertNotice(Notice notice) {
 		return 0;
 	}
 	// 행이 삭제됐는지 반환 (영향을 준 레코드 개수)
	public int deleteNotice(int id) {
		return 0;
		
	}
	// 행이 업데이트 됐는지 (영향을 준 레코드 개수)
	public int updateNotice(Notice notice) {
		return 0;
	}
	// 새로운 공지사항을 반환해야하므로 List 반환
	List<Notice> getNoticeNewestList() {
		return null;
	}
	
}
