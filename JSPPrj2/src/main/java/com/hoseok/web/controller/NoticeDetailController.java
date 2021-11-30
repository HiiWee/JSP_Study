// NoticeDetaiiController
package com.hoseok.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet {
	// service함수보다는 특화된 서비스를 출력하는것이 바람직하다.
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get 방식으로 받아온 id값을 int id 변수에 담음
		// MVC MODEL 1 방식으로 변환하기

		int id = Integer.parseInt(request.getParameter("id")); 

		String url = "jdbc:mysql://127.0.0.1:3306/hoseok";
		String sql = "select * from notice where ID = ?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "hoseok", "!dlghtjr4948");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			rs.next();

			// Model : view단에 넘겨줘야함 어떻게 넘길까?
			// 2가지 문제가 있다.
			// 1. detail.jsp로 흐름이 전이되어야 하는데 흐름을 전달할 수 있는 방법이 있나? 
			//(list.jsp가 반드시 선행되어 실행해야함) Controller에서 detail.jsp가 실행되어야함 반드시!!
			String title = rs.getString("title");
			Date regdate = rs.getDate("regdate");
			String memberId = rs.getString("memberId");
			int hit = rs.getInt("hit");
			String files = rs.getString("files");
			String content = rs.getString("content");

			//forward하기전에 Model값들 저장함
			request.setAttribute("title", title);
			request.setAttribute("regdate", regdate);
			request.setAttribute("memberId", memberId);
			request.setAttribute("hit", hit);
			request.setAttribute("files", files);
			request.setAttribute("content", content);
			request.getAttribute(content);
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
		
		
		// Servlet 에서 Servlet으로 전이하는 방법
		// 1. redirect : 서블릿 호출시 여기서 아예 다른페이지로 가버리는 방법 (로그인안하고 접근 시, 게시물 등록시 목록페이지로 전이)
		// 2. forward : 현재 서블릿에서 작업한 내용을 이어받아서 jsp에서 처리해야 하는경우
		// 절대경로
		//RequestDispatcher dispatcher = request.getRequestDispatcher(URL);
		//dispatcher.forward(request, response); 도 가능
		request.getRequestDispatcher("/notice/detail.jsp").forward(request, response);
			
	}
}
