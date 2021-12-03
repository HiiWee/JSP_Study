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
		
		System.out.print("title : ");
		System.out.println(title);
		
		String content = request.getParameter("content");
		String isOpen = request.getParameter("open");
		
		// 체크박스가 체크됐으면 true값 넣음
		boolean pub = false;
		if (isOpen != null)
			pub = true;
		
		// Notice에 데이터 포장
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setPub(pub);
		// 로그인 처리를 구현하게 되면 인증을 처리한 사용자의 아이디로 바뀜
		notice.setMemberId("hoseok");
		
		NoticeService service = new NoticeService();
		service.insertNotice(notice);
		
		// TODO JAVADOCS: 클라이언트로 전송되는 응답의 문자 인코딩(MIME 문자 집합)을 설정
		response.setCharacterEncoding("UTF-8");
		//클라이언트가 받고나서 어떻게 해석할것인가에 대한 정보를 전달
		// TODO JAVADOCS:  클라이언트로 전송되는 응답의 콘텐츠 유형을 설정합니다. 주어진 콘텐츠 유형에는 문자 인코딩 사양이 포함될 수 있습니다
		response.setContentType("text/html; charset=UTF-8");
		
		
		// 경로지정안하고 호출하면 자신의 url에 마지막에 list로 바귐 (reg -> list)
		response.sendRedirect("list");
	}
}
