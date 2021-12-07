package com.movie.web.controller.join;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.web.entity.Member;
import com.movie.web.service.MemberService;

@WebServlet("/join/login")
public class LogInController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId_ = request.getParameter("memberId");
		String pwd_ = request.getParameter("pwd");
		
		String memberId = "";
		String pwd = "";
		
		if (memberId_ != null && !memberId_.equals(""))
			memberId = memberId_;
		
		if (pwd_ != null && !pwd_.equals(""))
			pwd = pwd_;
	
		
		MemberService service = new MemberService();
		int result = service.logInMember(memberId, pwd);
		HttpSession session = request.getSession();
		
		if (result == 1) {
			System.out.println("로그인 성공");
			session.setAttribute("sessionId", memberId);
			response.sendRedirect("/member/index");
		}
		else if (result == -1) {
			System.out.println("존재하지 않는 아이디 입니다.");
			session.setAttribute("logInChk", result);
			response.sendRedirect("login");
		}
		else if (result == 0) {
			System.out.println("비밀번호가 틀렸습니다.");
			session.setAttribute("logInChk", result);
			response.sendRedirect("login");
		}
	}
}
