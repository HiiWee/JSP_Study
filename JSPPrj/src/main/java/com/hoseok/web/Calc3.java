package com.hoseok.web;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc3")
public class Calc3 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 3.Cookie 객체
		Cookie[] cookies = request.getCookies();

		// 출력할 일이 없음
		// response.setCharacterEncoding("utf-8");
		// response.setContentType("text/html; utf-8");

		// PrintWriter out = response.getWriter();

		// 우리는 사용자가 전달한 값을 가지고 표현을 만들어서 쿠키에 저장하고 redirection한다
		// 아래 3개중 하나만 전달되고 나머진 NULL값 들어옴 > null 이아닌값을 누적하는 방식
		String value = request.getParameter("value");
		String operator = request.getParameter("operator");
		String dot = request.getParameter("dot");

		String exp = "";
		if (cookies != null)
			for (Cookie c : cookies)
				if (c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
		// 계산 연산
		if (operator != null && operator.equals("=")) {
			// 자바스크립트를 실행할 수 있는 엔진객체
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("graal.js");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				e.printStackTrace();
			}
		}
		// 취소 연산 : 여기서는 exp의 값을 비워준다 혹시나하는 이중장치 역할
		else if (operator != null && operator.equals("C")) {
			exp = "";
		}
		else {
			exp += (value == null) ? "" : value;
			exp += (dot == null) ? "" : dot;
			exp += (operator == null) ? "" : operator;
		}
		

		Cookie expCookie = new Cookie("exp", exp);
		// 취소 연산 : 여기서는 쿠키를 만료시켜 없앤다.(값이 0이면 쿠키 삭제됨)
		if (operator != null && operator.equals("C")) {
			expCookie.setMaxAge(0);
		}
		expCookie.setPath("");
		response.addCookie(expCookie);
		response.sendRedirect("/calcpage"); // 같은경로에 있으므로 경로 따로 붙이지 않아도됨 "calcpage" 이렇게

	}
}
