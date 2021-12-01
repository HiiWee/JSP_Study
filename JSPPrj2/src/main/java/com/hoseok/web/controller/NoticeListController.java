package com.hoseok.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hoseok.web.entity.Notice;
import com.hoseok.web.service.NoticeService;

// 이 페이지에서의 Model은 목록임 따라서 리스트 객체 이용
@WebServlet("/notice/list")
public class NoticeListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//list?f=field&q=query 가 전달옴
		
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		
		String field = "title";
		if (field_ != null)
			field = field_;

		String query = "";
		if(query_ != null)
			query = query_;
		
		NoticeService service = new NoticeService();
		
		List<Notice> list = service.getNoticeList(field, query, 1);
	
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp").forward(request, response);
	}
}
