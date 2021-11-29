package com.hoseok.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc-session")
public class Calc2Session extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 2.Session 객체
		HttpSession session = request.getSession();
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; utf-8");

		// PrintWriter out = response.getWriter();
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		int v = 0;
		if (v_ != null && !v_.equals("")) {
			v = Integer.parseInt(v_);
		}

		// 값을 계산
		if (op.equals("=")) { // +, -는 값을 저장하기만 하면되지만 =은 계산을 해야하므로
			//int x = (Integer) application.getAttribute("value");
			int x = (Integer) session.getAttribute("value");	// application과 동일
			int y = v;
			//String operator = (String) application.getAttribute("op");
			String operator = (String) session.getAttribute("op"); // application과 동일
			int result = 0;

			if (operator.equals("+"))
				result = x + y;
			else
				result = x - y;
			response.getWriter().println("결과는 " + result + "입니다.");
		}
		// 값을 저장
		else {
			// Map Collection과 닮음
			//application.setAttribute("value", v);
			//application.setAttribute("op", op);
			session.setAttribute("value", v);
			session.setAttribute("op", op);
		}

	}
}
