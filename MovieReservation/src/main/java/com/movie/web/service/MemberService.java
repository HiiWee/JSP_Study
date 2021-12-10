package com.movie.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.movie.web.entity.Member;

public class MemberService {

	
	// 회원가입 메소드
	public int insertMember(Member member) {

		int result = 0;
		
		String url = "jdbc:mysql://127.0.0.1:3306/theater_db";
		String sql = "insert into member values (?, ?, ?, ?, ?) ";
		
		// 가입시 비밀번호가 다르면 -1 반환
		if (member.getPwd().equals("")) {
			return -1;
		}
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "hoseok", "!dlghtjr4948");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, member.getMemberId());
			st.setString(2, member.getName());
			st.setString(3, member.getPwd());
			st.setString(4, member.getPhone());
			st.setBoolean(5, member.getAuth());
			result = st.executeUpdate();

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
	
	
	// 로그인 메소드
	public int logInMember(String memberId, String pwd) {
		
		String url = "jdbc:mysql://127.0.0.1:3306/theater_db";
		String sql = "select pwd from member where memberId = ?";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "hoseok", "!dlghtjr4948");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, memberId);
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				if (rs.getString("pwd").equals(pwd))
					return 1; // 로그인 인증 성공
				else
					return 0; // password 다름
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

		return -1;	// 없는 아이디
	}


	public Member getMember(String id) {
		
		String url = "jdbc:mysql://127.0.0.1:3306/theater_db";
		String sql = "select * from member where memberId = ?";
		
		Member member = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "hoseok", "!dlghtjr4948");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			
			rs.next();
			String memberId = rs.getString("memberId");
			String name = rs.getString("name");
			String pwd = rs.getString("pwd");
			String phone = rs.getString("phone");
			
			member = new Member(memberId, name, pwd, phone, false);
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

		return member;
	}


	public int updateMember(Member member) {
		int result = 0;
		
		String url = "jdbc:mysql://127.0.0.1:3306/theater_db";
		String sql = "update member set name=?, pwd=?, phone=?  where memberId = ?";
		
		// 가입시 비밀번호가 다르면 -1 반환
		if (member.getPwd().equals("")) {
			return -1;
		}
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "hoseok", "!dlghtjr4948");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, member.getName());
			st.setString(2, member.getPwd());
			st.setString(3, member.getPhone());
			st.setString(4, member.getMemberId());
			result = st.executeUpdate();

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



}

// 회원가입을 위한 서비스
// insertMember()
// 로그인을 위한 서비스
// logInMember();