package com.hoseok.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add2")
public class Add2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; utf-8");

		// PrintWriter out = response.getWriter();
		String[] num_ = request.getParameterValues("num");
		int result = 0;
		
		for (int i = 0; i < num_.length; i++) {
			int num = Integer.parseInt(num_[i]);	// 연산은 반복되지만 선언은 반복되지 않음
			result += num;
		}
		response.getWriter().println("덧셈 결과는 " + result + "입니다.");
	}
}
