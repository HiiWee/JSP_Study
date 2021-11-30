// Controller
package com.hoseok.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ��Ʈ�ѷ����� ���� �����͸� �� ������ �����ϱ� ���� ����� (�����)�ʿ�
@WebServlet("/spage")
public class Spag extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = 0;

		String num_ = request.getParameter("n");
		if (num_ != null && !num_.equals(""))
			num = Integer.parseInt(num_);

		String result;

		if (num % 2 == 0)
			result = "¦��";
		else
			result = "Ȧ��";

		request.setAttribute("result", result);

		// ELǥ��� �̿��� �迭 ����
		String[] names = {"newlec", "dragon"};
		request.setAttribute("names", names);
		
		// ELǥ��� �̿��� Map ����
		Map<String, Object> notice = new HashMap<String, Object>();
		notice.put("id", 1);
		notice.put("title", "EL expression");
		request.setAttribute("notice", notice);
		
		
		
		// Forwarding request�� jsp�� ����        �������� ������ webapp�̹Ƿ� / == webapp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/spag.jsp");
		dispatcher.forward(request, response);
	}
}
