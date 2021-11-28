package com.hoseok.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO JAVADOCS: 클라이언트로 전송되는 응답의 문자 인코딩(MIME 문자 집합)을 설정
		response.setCharacterEncoding("UTF-8");
		
		// TODO JAVADOCS: 요청의 본문에 사용된 문자 인코딩의 이름을 재정의합니다. 이 메소드는 요청 매개변수를 읽거나 getReader()를 사용하여 입력을 읽기 전에 호출해야 합니다. 그렇지 않으면 효과가 없습니다.
		// 사용자의 입력값을 UTF 8 로 읽어들임
		//request.setCharacterEncoding("UTF-8");	필터로 설정을 빼는 작업할것이라 주석처리
		
		//클라이언트가 받고나서 어떻게 해석할것인가에 대한 정보를 전달
		// TODO JAVADOCS:  클라이언트로 전송되는 응답의 콘텐츠 유형을 설정합니다. 주어진 콘텐츠 유형에는 문자 인코딩 사양이 포함될 수 있습니다
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		// 입력도구(request) 이용 getParameter는 쿼리스트링의 키워드를 읽어옴(전달은 무조건 문자열로 전달됨)
		// 다만 기본값이 없으므로 쿼리스트링을 쓰지 않으면 오류가 난다.
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		out.println(title);
		out.println(content);
	}
}
