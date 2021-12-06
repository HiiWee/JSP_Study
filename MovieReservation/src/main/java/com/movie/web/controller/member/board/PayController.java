package com.movie.web.controller.member.board;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.web.entity.Payment;
import com.movie.web.service.PaymentService;


//movieName(movieName), movieId(pMovieId), totalPrice(pTotalPrice), 
// memberId(sessionId), audId(pAudId), seatName(pSeatName), screenDay(pScreenDay), manCount(manCount)

@WebServlet("/member/board/pay")
public class PayController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("pay.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터 받아와서 포장하고 db에 넣기
		String method = request.getParameter("method");
		HttpSession session = request.getSession();
		String movieId = (String) session.getAttribute("pMovieId");
		int totalPrice = (int) session.getAttribute("pTotalPrice");
		String memberId = (String) session.getAttribute("sessionId");
		String audiId = (String) session.getAttribute("pAudiId");
		String seatName = (String) session.getAttribute("pSeatName");
		String screenDay = (String) session.getAttribute("pScreenDay");
		Payment payment = new Payment();
		
		payment.setMovieId(movieId);
		payment.setMethod(method);
		payment.setTotalPrice(totalPrice);
		payment.setMemberId(memberId);
		payment.setAudiId(audiId);
		payment.setSeatName(seatName);
		payment.setScreenDay(screenDay);
		
		PaymentService service = new PaymentService();
		
		int result = service.insertPayment(payment);
		
		if (result == 1) {
			System.out.println("결제완료");
			request.setAttribute("payResult", result);
			response.sendRedirect("/member/index");
		}
		else {
			System.out.println("결제실패");
			request.setAttribute("payResult", result);
			response.sendRedirect("/member/index");
		}
	}
}
