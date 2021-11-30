// 계산기 프로그램을 하나의 서블릿으로 합치기
// calc3.java와 calcPage.java를 doGet(), doPost() 메소드를 이용하여 합치기

package com.hoseok.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// GET 요청과 POST 요청을 구분해서 작성하기
// 1. service함수에서 구분짓는 방법과
// 2. get요청과 post 요청에 특화된 메소드
@WebServlet("/calculator")
public class Calculator extends HttpServlet {
//	@Override
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		// 1. service함수에서 구분짓는 방법
//		// 메소드의 요청이 get이냐 post냐 반환해줌
//		// 하지만 html의 method 옵션값이 전달되어 넘어오는게 아니므로 대문자로 사용
//		if (request.getMethod().equals("GET")) {
//			System.out.println("GET 요청이 왔습니다.");
//		}
//		else if (request.getMethod().equals("POST")) {
//			System.out.println("POST 요청이 왔습니다.");
//		}
//		
//		// 2. 또 다른 방법 get요청과 post 요청에 특화된 메소드
//		// 부모가 가진 service함수는 get인지 post인지 확인해서 doGet(), doPost() 메소드를 구분해 실행함
//		// 다만 HttpServlet은 추상클래스이므로 메소드들을 오버라이드 해줘야함
//		super.service(request, response);
//		
//	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();
		// 연산식을 뽑기 위해
		String exp = "0";
		if (cookies != null)
			for (Cookie c : cookies)
				if (c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; utf-8");
		PrintWriter out = response.getWriter();
		// <!-- <------------------------------ 동적인 페이지(서버 페이지)의 필요성
		// -----------------------------==> -->
		// <!-- 처음이자 마지막으로 동적인 페이지 서블릿으로 직접 만들기 -->

		out.write("<!doctype html>");
		out.write("<html lang=\"ko\">");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\" />");
		out.write("<title>calc program</title>");
		out.write("</head>");
		out.write("<style>");
		out.write("	input {");
		out.write("		width: 50px;");
		out.write("		height: 50px;");
		out.write("	}");
		out.write("	.output {");
		out.write("		height: 50px;");
		out.write("		background-color: #e9e9e9;");
		out.write("		font-size: 24px;");
		out.write("		font-weight: bold;");
		out.write("		text-align: right;");
		out.write("		padding: 0px 5px;");
		out.write("	}");
		out.write("</style>");
		out.write("<body>");
		out.write("	<div>");
		// action지워도됨 : 현재 페이지와 post할 url이 같으므로 굳이 넣지 않아도됨
		out.write("		<form method=\"post\">");
		out.write("			<table>");
		out.write("				<tr>");
		out.printf("					<td class=\"output\" colspan=\"4\">%s</td>", exp);
		out.write("				</tr>");
		out.write("				<tr>");
		out.write("					<td><input type=\"submit\" name=\"operator\" value=\"CE\"/></td>");
		out.write("					<td><input type=\"submit\" name=\"operator\" value=\"C\"/></td>");
		out.write("					<td><input type=\"submit\" name=\"operator\" value=\"BS\"/></td>");
		out.write("					<td><input type=\"submit\" name=\"operator\" value=\"/\"/></td>");
		out.write("				</tr>");
		out.write("				<tr>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"7\"/></td>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"8\"/></td>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"9\"/></td>");
		out.write("					<td><input type=\"submit\" name=\"operator\" value=\"*\"/></td>");
		out.write("				</tr>");
		out.write("				<tr>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"4\"/></td>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"5\"/></td>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"6\"/></td>");
		out.write("					<td><input type=\"submit\" name=\"operator\" value=\"-\"/></td>");
		out.write("				</tr>");
		out.write("				<tr>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"1\"/></td>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"2\"/></td>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"3\"/></td>");
		out.write("					<td><input type=\"submit\" name=\"operator\" value=\"+\"/></td>");
		out.write("				</tr>");
		out.write("				<tr>");
		out.write("					<td></td>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"0\"/></td>");
		out.write("					<td><input type=\"submit\" name=\"dot\" value=\".\"/></td>");
		out.write("					<td><input type=\"submit\" name=\"operator\" value=\"=\"/></td>");
		out.write("				</tr>");
		out.write("			</table>");
		out.write("		</form>");
		out.write("	</div>");
		out.write("</body>");
		out.write("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
		} else {
			exp += (value == null) ? "" : value;
			exp += (dot == null) ? "" : dot;
			exp += (operator == null) ? "" : operator;
		}
		
		Cookie expCookie = new Cookie("exp", exp);
		// 취소 연산 : 여기서는 쿠키를 만료시켜 없앤다.(값이 0이면 쿠키 삭제됨)
		if (operator != null && operator.equals("C")) {
			expCookie.setMaxAge(0);
		}
		expCookie.setPath("/calculator");
		response.addCookie(expCookie);
		// 자기 자신의 페이지로 리다이렉트 (자기가 자신을 호출해도 get요청을 의미한다 >> doGet()함수 호출됨 >> 다시 위의 html 출력)
		response.sendRedirect("calculator");
		
	}
}
