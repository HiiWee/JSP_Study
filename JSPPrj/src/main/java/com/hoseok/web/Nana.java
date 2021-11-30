package com.hoseok.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class Nana extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO JAVADOCS: 클라이언트로 전송되는 응답의 문자 인코딩(MIME 문자 집합)을 설정
		response.setCharacterEncoding("UTF-8");
		//클라이언트가 받고나서 어떻게 해석할것인가에 대한 정보를 전달
		// TODO JAVADOCS:  클라이언트로 전송되는 응답의 콘텐츠 유형을 설정합니다. 주어진 콘텐츠 유형에는 문자 인코딩 사양이 포함될 수 있습니다
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		// 입력도구(request) 이용 getParameter는 쿼리스트링의 키워드를 읽어옴(전달은 무조건 문자열로 전달됨)
		// 다만 기본값이 없으므로 쿼리스트링을 쓰지 않으면 오류가 난다.
		String cnt_ = request.getParameter("cnt");			// 임시변수 : null, ""값 들어왔을때 오류방지를 위한 임시변수
		int cnt = 10;
		if (cnt_ != null && !cnt_.equals(""))
			cnt = Integer.parseInt(cnt_);
		
		 
		for (int i = 0; i < cnt; i++) {
			out.println((i + 1) + ": 안녕 Servlet!!<br>");
		}
	}
}
