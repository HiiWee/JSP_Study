package com.movie.web.controller.join;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.web.entity.Member;
import com.movie.web.service.MemberService;

@WebServlet("/join/join_in")
public class SignInController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("join_in.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId_ = request.getParameter("memberId");
		String pwd1_ = request.getParameter("pwd1");
		String pwd2_ = request.getParameter("pwd2");
		String name_ = request.getParameter("name");
		String phone1_ = request.getParameter("phone1");
		String phone2_ = request.getParameter("phone2");
		String phone3_ = request.getParameter("phone3");

		String memberId = "";
		String pwd ="";
		String name = "";
		String phone = "";
		
		
		if (memberId_ != null && !memberId_.equals(""))
			memberId = memberId_;
		
		if (pwd1_.equals(pwd2_))
			if (pwd1_ != null && !pwd1_.equals(""))
				if (pwd2_ != null && !pwd2_.equals(""))
					pwd = pwd2_;
		
		if (name_ != null && !name_.equals(""))
			name = name_;
		
		if (phone1_ !=null && !phone1_.equals(""))
			phone += phone1_ + "-";
		
		if (phone2_ !=null && !phone2_.equals(""))
			phone += phone2_ + "-";
		
		if (phone3_ !=null && !phone3_.equals(""))
			phone += phone3_;
		
		Member member = new Member(memberId, name, pwd, phone, false);
		MemberService service = new MemberService();
		int result = service.insertMember(member);
		
		// insert로 회원가입하면 result값 1반환 되는데
		// 그래서 id값을 세션 객체에 저장하고
		if (result == 1) {
			System.out.println("회원가입 성공");
			response.sendRedirect("/index");
		}
		else if (result == -1) {
			System.out.println("비밀번호와 비밀번호 확인이 다릅니다.");
			request.setAttribute("pwdChk", result);
			request.getRequestDispatcher("join_in.jsp").forward(request, response);
		}
		else if (result == 0) {
			System.out.println("아이디가 중복됩니다.");
			request.setAttribute("pwdChk", result);
			request.getRequestDispatcher("join_in.jsp").forward(request, response);
		}
	}
	
	
}
