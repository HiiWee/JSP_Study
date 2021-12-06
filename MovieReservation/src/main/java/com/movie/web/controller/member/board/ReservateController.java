package com.movie.web.controller.member.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.web.entity.Seat;
import com.movie.web.service.SeatService;

// movieName(movieName), movieId(pMovieId), totalPrice(pTotalPrice), memberId(sessionId), audId(pAudId), seatName(pSeatName), screenDay(pScreenDay), manCount(manCount)
@WebServlet("/member/board/reservate")
public class ReservateController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String[] seatName_ = request.getParameterValues("seat");
		int manCount = Integer.parseInt(request.getParameter("manCount"));
		
		// 인원수 체크
		if (manCount != seatName_.length) {
			System.out.println("선택한 좌석과 인원수가 맞지 않습니다.");
			response.sendRedirect("movie_list");
			return;
		}
		String seatName = "";
		if (seatName_ != null) {
			for (int i = 0; i < seatName_.length; i++) {
				if (i == seatName_.length - 1) {
					seatName += "'" + seatName_[i] + "'";
					break;
				}
				seatName += "'" + seatName_[i] + "'" + ",";
			}
		}
		
		
		
		int totalPrice = 14000 * manCount;
		session.setAttribute("pSeatName", seatName);
		session.setAttribute("manCount", manCount);
		session.setAttribute("pTotalPrice", totalPrice);
		response.sendRedirect("pay");

	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pMovieId = request.getParameter("movieId");
		String pName = request.getParameter("name");
		String pAudiId = request.getParameter("audiId");
		String pScreenDay = request.getParameter("screenDay");
		HttpSession session = request.getSession();
		// 위의 post에서 쓸 데이터 저장
		session.setAttribute("pMovieId", pMovieId);
		session.setAttribute("movieName", pName);
		session.setAttribute("pAudiId", pAudiId);
		session.setAttribute("pScreenDay", pScreenDay);
		
		SeatService service = new SeatService();
		List<Seat> list = service.getCertainAudiSeatList(pAudiId);
		
		request.setAttribute("id", pMovieId);
		request.setAttribute("audi", pAudiId);
		request.setAttribute("day", pScreenDay);
		request.setAttribute("seatList", list);
		request.getRequestDispatcher("reservate.jsp").forward(request, response);
		
	}
}
  