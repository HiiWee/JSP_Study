package com.hoseok.web.controller.admin.notice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
		// 초기 빈공백이 배열화 되는것을 막기위해 트림으로 양쪽 공백을 지우고 파싱
		String[] ids = ids_.trim().split(" ");		// 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
		
		NoticeService service = new NoticeService();
		int result;
		
		switch (cmd) {
		case "일괄공개":
			if (openIds == null) {
				System.out.println("아무 값도 체크하지 않았습니다.");
				break;
			}
			// openIds와 ids를 비교하며 체크된것과 안된것들을 비교한다.
			// 배열을 리스트 형태로 바꿀때 이용한다, openIds, ids 둘다 리스트형태로 만들고 빼기연산
			List<String> oids = Arrays.asList(openIds);
			// ids를 리스트로만들고 oids를 지워라 하지만 정적길이 리스트 모양이므로 새로운 객체에 담아 쓴다.
			List<String> cids = new ArrayList<>(Arrays.asList(ids));
			cids.removeAll(oids);
			// Transaction 처리
			service.pubNoticeAll(oids, cids);
			break;
		
		case "일괄삭제": 
			if (delIds == null) {
				System.out.println("아무 값도 체크하지 않았습니다.");
				break;
			}
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
