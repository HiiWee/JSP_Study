package com.hoseok.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc-cookie")
public class Calc2Cookie extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 3.Cookie 객체
		Cookie[] cookies = request.getCookies();

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
			// int x = (Integer) application.getAttribute("value");
			// int x = (Integer) session.getAttribute("value"); // application과 동일
			int x = 0;

			for (Cookie c : cookies)
				if (c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}

			int y = v;
			// String operator = (String) application.getAttribute("op");
			// String operator = (String) session.getAttribute("op"); // application과 동일
			String operator = "";
			for (Cookie c : cookies)
				if (c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}

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
			// application.setAttribute("value", v);
			// application.setAttribute("op", op);

			// session.setAttribute("value", v);
			// session.setAttribute("op", op);

			// 쿠키 생성
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);
			// 쿠키를 calc4에서만 받을 수 있게 path제한을 둠
			// 특정 디렉토리에서만 쓰겠다 > /name/
			// 모든 경로에서 쓰겠다 > /
			valueCookie.setPath("/calc-cookie");
			opCookie.setPath("/calc-cookie");
			// 쿠키의 만료날짜 설정(초단위)
			valueCookie.setMaxAge(24 * 60 * 60);
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
			// 백지가 아닌 다른 페이지를 넘겨줌
//			response.sendRedirect("calc2.html");
		}

	}
}
