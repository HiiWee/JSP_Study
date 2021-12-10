package com.movie.web.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.web.entity.Member;
import com.movie.web.service.MemberService;

@WebServlet("/member/edit_member")
public class EditMemberController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("sessionId");
		MemberService service = new MemberService();
		Member member = service.getMember(memberId);
		
		request.setAttribute("member", member);
		request.getRequestDispatcher("/member/edit_member.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId_ = request.getParameter("memberId");
		String pwd1_ = request.getParameter("pwd1");
		String pwd2_ = request.getParameter("pwd2");
		String name_ = request.getParameter("name");
		String phone_ = request.getParameter("phone");

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
		
		if (phone_ !=null && !phone_.equals(""))
			phone += phone_;
		
		
		Member member = new Member(memberId, name, pwd, phone, false);
		MemberService service = new MemberService();
		int result = service.updateMember(member);
		
		if (result == 1) {
			System.out.println("회원정보 수정 성공");
			response.sendRedirect("index");
		}
		else if (result == -1) {
			System.out.println("비밀번호와 비밀번호 확인이 다릅니다.");
			request.setAttribute("pwdChk", result);
			request.getRequestDispatcher("edit_member.jsp").forward(request, response);
		}
		else if (result == 0) {
			System.out.println("바뀐 정보가 없습니다.");
			request.setAttribute("pwdChk", result);
			request.getRequestDispatcher("edit_member.jsp").forward(request, response);
		}
	}
	
}
