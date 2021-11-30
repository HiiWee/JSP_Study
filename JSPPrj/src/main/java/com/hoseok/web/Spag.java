// Controller
package com.hoseok.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 컨트롤러에서 만든 데이터를 뷰 단으로 연결하기 위한 연결고리 (저장소)필요
@WebServlet("/spage")
public class Spag extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = 0;

		String num_ = request.getParameter("n");
		if (num_ != null && !num_.equals(""))
			num = Integer.parseInt(num_);

		String result;

		if (num % 2 == 0)
			result = "짝수";
		else
			result = "홀수";

		request.setAttribute("result", result);

		// EL표기법 이용한 배열 전달
		String[] names = {"newlec", "dragon"};
		request.setAttribute("names", names);
		
		// EL표기법 이용한 Map 전달
		Map<String, Object> notice = new HashMap<String, Object>();
		notice.put("id", 1);
		notice.put("title", "EL expression");
		request.setAttribute("notice", notice);
		
		
		
		// Forwarding request를 jsp와 공유        절대경로의 시작은 webapp이므로 / == webapp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/spag.jsp");
		dispatcher.forward(request, response);
	}
}
