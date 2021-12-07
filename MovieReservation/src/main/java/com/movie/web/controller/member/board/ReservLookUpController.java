package com.movie.web.controller.member.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.web.entity.PaymentView;
import com.movie.web.service.PaymentService;

@WebServlet("/member/board/look_up")
public class ReservLookUpController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("sessionId");
		
		PaymentService service = new PaymentService();
		List<PaymentView> list = service.getUserPayListAll(memberId);
		boolean listEmpty = list.isEmpty();
		request.setAttribute("list", list);
		request.setAttribute("listEmpty", listEmpty);
		request.getRequestDispatcher("look_up.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String audiId_ = request.getParameter("hiddenAudiId");
		String seatName_ = request.getParameter("hiddenSeatName");
		String payId_ = request.getParameter("hiddenPayId");
		String audiId = "";
		String seatName = "";
		String payId = "";
		
		if (payId_ != null && !payId_.equals(""))
			payId = payId_;
		if (audiId_ != null && !audiId_.equals(""))
			audiId = audiId_;
		if (seatName_ != null && !seatName_.equals(""))
			seatName = seatName_;
		
		PaymentService service = new PaymentService();
		int result = service.deleteReservation(payId, audiId, seatName);
		
		if (result == 1) {
			System.out.println("예매취소 완료");
			request.setAttribute("cancelResult", result);
			response.sendRedirect("/member/board/look_up");
		}
		else {
			System.out.println("예매취소 실패");
			request.setAttribute("cacelResult", result);
			response.sendRedirect("/member/board/look_up");
		}
	
	}
	
	
}
