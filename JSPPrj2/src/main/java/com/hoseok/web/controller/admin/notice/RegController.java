package com.hoseok.web.controller.admin.notice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.hoseok.web.entity.Notice;
import com.hoseok.web.service.NoticeService;

// 파일 경로, 사이즈, 한번에 보내는 사이즈, 총 사이즈 설정
@MultipartConfig (
	//location="/tmp",		
	fileSizeThreshold=1024*1024,
	maxFileSize=1024*1024*50,	
	maxRequestSize=1024*1024*50*5
)
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
		
		
		/* 파일업로드 과정 */
		// 여러파일 가져오기(컬렉션통채로)
		Collection<Part> parts = request.getParts();
		StringBuilder builder = new StringBuilder();
		for (Part p : parts) {
			if (!p.getName().equals("file")) continue;		// 파일이 아니면 pass
			if (p.getSize() == 0) continue;
			
			// 파일명 가져옴 
			Part filePart = p;
			String fileName = filePart.getSubmittedFileName();
			// 파일명 업로드 위해 builder에 붙임
			builder.append(fileName);
			builder.append(",");
			InputStream fis = filePart.getInputStream();
			
			String realPath = request.getServletContext().getRealPath("/upload");
			System.out.println(realPath);
			
			// 경로를 만듬 : File path는 업로드라는 디렉토리가 실제 물리적으로 얻어졌을때 물리적인 경로에 실제로 있는지 알아보는 기능이 있다.
			File path = new File(realPath);
			// 경로가 존재하는지 확인하고 없으면 만듬 > mkdir()은 경로를 만들고, mkdirs()는 부모 경로가 없으면 그것도 같이 만들어줌
			if (!path.exists())
				path.mkdir();
			
			String filePath = realPath + File.separator + fileName;
			FileOutputStream fos = new FileOutputStream(filePath);
			
			byte[] buf = new byte[1024];
			int size = 0;
			// 읽다가 사이즈값 반환 다 읽으면 -1
			while ((size = fis.read(buf))!= -1) {
				fos.write(buf, 0, size);
			}
			
			fos.close();
			fis.close();
			/* 파일 업로드 끝 */
		}
		// 파일명 목록에서 마지막 쉼표 뺴주기
		builder.delete(builder.length() - 1, builder.length());
		
		
		
		
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
		notice.setFiles(builder.toString());
		
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
