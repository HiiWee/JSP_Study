package com.hoseok.web.controller.admin.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hoseok.web.entity.NoticeView;
import com.hoseok.web.service.NoticeService;

// 이 페이지에서의 Model은 목록임 따라서 리스트 객체 이용
@WebServlet("/admin/board/notice/list")
public class ListController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] openIds = request.getParameterValues("open-id"); // 3, 5, 8
		String[] delIds = request.getParameterValues("del-id");
		String cmd = request.getParameter("cmd");
		// 공개목록위한 id값 받아오고 배열로 파싱
		String ids_ = request.getParameter("ids");
		String[] ids = ids_.split(" ");		// 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
		
		NoticeService service = new NoticeService();
		int result;
		
		switch (cmd) {
		case "일괄공개":
			// openIds와 ids를 비교하며 체크된것과 안된것들을 비교한다.
			for(int i = 0; i <ids.length; i++) {
				//CHK1 : 현재 id가 open된 상태냐 (openIds가 ids에 포함되냐를 확인)
				if (ids[i])
			}
			break;
		
		case "일괄삭제": 
			int[] newDelIds = new int[delIds.length];
			
			for (int i = 0; i < delIds.length; i++)
				newDelIds[i] = Integer.parseInt(delIds[i]);
			
			result = service.removeNoticeAll(newDelIds);
			System.out.println(result + "개가 삭제 됐습니다.");
			break;
		}
		// 클라이언트가 아닌 서버쪽에서 서버를 요청하듯이 이용
		response.sendRedirect("list");

	
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//list?f=field&q=query 가 전달옴

		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		String page_ = request.getParameter("p");
		
		String field = "title";
		// 꼭 null과 "" 체크 둘다 해주기!!
		if (field_ != null && !field_.equals(""))
			field = field_;

		String query = "";
		// 꼭 null과 "" 체크 둘다 해주기!!
		if(query_ != null && !query_.equals(""))
			query = query_;
		
		int page = 1;
		// 꼭 null과 "" 체크 둘다 해주기!!
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);

		
		NoticeService service = new NoticeService();
		int count = service.getNoticeCount(field, query);
		// count값이 0이면 올림을해도 0이므로 1로 처리
		if (count == 0)
			count = 1;
		
		
		List<NoticeView> list = service.getNoticeViewList(field, query, page);
	
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/list.jsp").forward(request, response);
	}
}
