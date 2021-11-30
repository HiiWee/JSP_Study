package com.hoseok.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; utf-8");

		// PrintWriter out = response.getWriter();
		int x = 0;
		int y = 0;
		int result = 0;
		String x_ = request.getParameter("x");
		String y_ = request.getParameter("y");
		String op = request.getParameter("operator");
		if (x_ != null && !x_.equals("")) {
			x = Integer.parseInt(x_);
		}
		if (y_ != null && !y_.equals("")) {
			y = Integer.parseInt(y_);
		}
		
		if (op.equals("덧셈"))
			result = x + y;
		else
			result = x - y;
			
		response.getWriter().println("결과는 " + result + "입니다.");
	}
}
