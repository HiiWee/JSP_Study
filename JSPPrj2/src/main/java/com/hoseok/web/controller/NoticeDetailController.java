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
	// service�Լ����ٴ� Ưȭ�� ���񽺸� ����ϴ°��� �ٶ����ϴ�.
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get ������� �޾ƿ� id���� int id ������ ����
		// MVC MODEL 1 ������� ��ȯ�ϱ�

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

			// Model : view�ܿ� �Ѱ������ ��� �ѱ��?
			// 2���� ������ �ִ�.
			// 1. detail.jsp�� �帧�� ���̵Ǿ�� �ϴµ� �帧�� ������ �� �ִ� ����� �ֳ�? 
			//(list.jsp�� �ݵ�� ����Ǿ� �����ؾ���) Controller���� detail.jsp�� ����Ǿ���� �ݵ��!!
			String title = rs.getString("title");
			Date regdate = rs.getDate("regdate");
			String memberId = rs.getString("memberId");
			int hit = rs.getInt("hit");
			String files = rs.getString("files");
			String content = rs.getString("content");

			//forward�ϱ����� Model���� ������
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
		
		
		// Servlet ���� Servlet���� �����ϴ� ���
		// 1. redirect : ���� ȣ��� ���⼭ �ƿ� �ٸ��������� �������� ��� (�α��ξ��ϰ� ���� ��, �Խù� ��Ͻ� ����������� ����)
		// 2. forward : ���� �������� �۾��� ������ �̾�޾Ƽ� jsp���� ó���ؾ� �ϴ°��
		// ������
		//RequestDispatcher dispatcher = request.getRequestDispatcher(URL);
		//dispatcher.forward(request, response); �� ����
		request.getRequestDispatcher("/notice/detail.jsp").forward(request, response);
			
	}
}
