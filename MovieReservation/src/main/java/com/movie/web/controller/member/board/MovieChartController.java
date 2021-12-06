package com.movie.web.controller.member.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.web.entity.Movie;
import com.movie.web.service.MovieService;

@WebServlet("/member/board/movie_chart")
public class MovieChartController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("sessionId");
		MovieService service = new MovieService();
		List<Movie> list = service.getMovieList();
		if (sessionId != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("movie_chart.jsp").forward(request, response);
		}
		else {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/common/movie_chart.jsp").forward(request, response);
		}
	}

}
