﻿package com.hoseok.web.controller;

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
		int totalNotice = service.getNoticeCount(field, query);
		if (totalNotice == 0)
			totalNotice = 1;
		
		
		List<Notice> list = service.getNoticeList(field, query, page);
	
		request.setAttribute("list", list);
//		request.setAttribute();
		request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp").forward(request, response);
	}
}
