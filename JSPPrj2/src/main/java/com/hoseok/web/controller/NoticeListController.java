package com.hoseok.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hoseok.web.entity.Notice;

// �� ������������ Model�� ����� ���� ����Ʈ ��ü �̿�
@WebServlet("/notice/list")
public class NoticeListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Notice> list = new ArrayList<>();
		
		String url = "jdbc:mysql://127.0.0.1:3306/hoseok";
		String sql = "select * from notice";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "hoseok", "!dlghtjr4948");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			
			while(rs.next()) { 
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String memberId = rs.getString("memberId");
				String content = rs.getString("content");
				Date regdate = rs.getDate("regdate");
				int hit = rs.getInt("hit");
				String files = rs.getString("files");
				
				Notice notice = new Notice(
						id,
						title,
						memberId,
						content,
						regdate,
						hit,
						files
						);
				
				// ����� ���� ����Ʈ ��ü�� ��Ƴ���
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
		request.setAttribute("list", list);
//		TODO VIEW page�� �����ߴµ� css, js������ ��� ������ �� ���ص� ����?
		request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp").forward(request, response);
	}
}
