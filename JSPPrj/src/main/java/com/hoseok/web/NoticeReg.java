package com.hoseok.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO JAVADOCS: Ŭ���̾�Ʈ�� ���۵Ǵ� ������ ���� ���ڵ�(MIME ���� ����)�� ����
		response.setCharacterEncoding("UTF-8");
		
		// TODO JAVADOCS: ��û�� ������ ���� ���� ���ڵ��� �̸��� �������մϴ�. �� �޼ҵ�� ��û �Ű������� �аų� getReader()�� ����Ͽ� �Է��� �б� ���� ȣ���ؾ� �մϴ�. �׷��� ������ ȿ���� �����ϴ�.
		// ������� �Է°��� UTF 8 �� �о����
		//request.setCharacterEncoding("UTF-8");	���ͷ� ������ ���� �۾��Ұ��̶� �ּ�ó��
		
		//Ŭ���̾�Ʈ�� �ް��� ��� �ؼ��Ұ��ΰ��� ���� ������ ����
		// TODO JAVADOCS:  Ŭ���̾�Ʈ�� ���۵Ǵ� ������ ������ ������ �����մϴ�. �־��� ������ �������� ���� ���ڵ� ����� ���Ե� �� �ֽ��ϴ�
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		// �Էµ���(request) �̿� getParameter�� ������Ʈ���� Ű���带 �о��(������ ������ ���ڿ��� ���޵�)
		// �ٸ� �⺻���� �����Ƿ� ������Ʈ���� ���� ������ ������ ����.
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		out.println(title);
		out.println(content);
	}
}
