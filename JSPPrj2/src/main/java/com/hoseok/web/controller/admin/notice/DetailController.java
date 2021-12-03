// NoticeDetaiiController
package com.hoseok.web.controller.admin.notice;

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

import com.hoseok.web.entity.Notice;
import com.hoseok.web.service.NoticeService;

@WebServlet("/admin/board/notice/detail")
public class DetailController extends HttpServlet {
	// service함수보다는 특화된 서비스를 출력하는것이 바람직하다.
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get 방식으로 받아온 id값을 int id 변수에 담음
		// MVC MODEL 1 방식으로 변환하기

		int id = Integer.parseInt(request.getParameter("id")); 
		NoticeService service = new NoticeService();
		Notice notice = service.getNotice(id);
		request.setAttribute("notice", notice);
		
		// Servlet 에서 Servlet으로 전이하는 방법
		// 1. redirect : 서블릿 호출시 여기서 아예 다른페이지로 가버리는 방법 (로그인안하고 접근 시, 게시물 등록시 목록페이지로 전이)
		// 2. forward : 현재 서블릿에서 작업한 내용을 이어받아서 jsp에서 처리해야 하는경우
		// 절대경로
		//RequestDispatcher dispatcher = request.getRequestDispatcher(URL);
		//dispatcher.forward(request, response); 도 가능
		request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/detail.jsp").forward(request, response);
			
	}
}
