package com.hoseok.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class Add extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; utf-8");

		// PrintWriter out = response.getWriter();
		int x = 0;
		int y = 0;
		int result;
		String x_ = request.getParameter("x");
		String y_ = request.getParameter("y");

		if (x_ != null && !x_.equals("")) {
			x = Integer.parseInt(x_);
		}
		if (y_ != null && !y_.equals("")) {
			y = Integer.parseInt(y_);
		}

		result = x + y;
		response.getWriter().println("µ¡¼À °á°ú´Â " + result + "ÀÔ´Ï´Ù.");
	}
}
