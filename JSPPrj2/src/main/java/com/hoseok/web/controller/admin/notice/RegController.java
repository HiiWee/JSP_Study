package com.hoseok.web.controller.admin.notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hoseok.web.entity.Notice;
import com.hoseok.web.service.NoticeService;

@WebServlet("/admin/board/notice/reg")
public class RegController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/reg.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 일단 jsp 파일을 가서 name값을 얻어와야 함
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String isOpen = request.getParameter("open");
		
		// Notice에 데이터 포장
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		// isOpen 컬럼을 추가해야하므로 수정이 꽤 많아짐 먼저 entity에 컬럼 변수 추가..
		
		NoticeService service = new NoticeService();
		
		// TODO JAVADOCS: 클라이언트로 전송되는 응답의 문자 인코딩(MIME 문자 집합)을 설정
		response.setCharacterEncoding("UTF-8");
		//클라이언트가 받고나서 어떻게 해석할것인가에 대한 정보를 전달
		// TODO JAVADOCS:  클라이언트로 전송되는 응답의 콘텐츠 유형을 설정합니다. 주어진 콘텐츠 유형에는 문자 인코딩 사양이 포함될 수 있습니다
		response.setContentType("text/html; charset=UTF-8");
	
		
		
		PrintWriter out = response.getWriter();
		out.printf(title);
		out.printf(content);
		out.printf(isOpen);
	}
}
