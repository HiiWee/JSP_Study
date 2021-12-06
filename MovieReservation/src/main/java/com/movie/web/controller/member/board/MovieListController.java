package com.movie.web.controller.member.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.entity.Movie;
import com.movie.web.entity.MovieListView;
import com.movie.web.service.MovieService;

@WebServlet("/member/board/movie_list")
public class MovieListController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieService service = new MovieService();
		List<MovieListView> list = service.getMovieViewList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("movie_list.jsp").forward(request, response);
	}
}
