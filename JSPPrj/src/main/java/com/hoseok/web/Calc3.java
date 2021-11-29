package com.hoseok.web;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc3")
public class Calc3 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 3.Cookie ��ü
		Cookie[] cookies = request.getCookies();

		// ����� ���� ����
		// response.setCharacterEncoding("utf-8");
		// response.setContentType("text/html; utf-8");

		// PrintWriter out = response.getWriter();

		// �츮�� ����ڰ� ������ ���� ������ ǥ���� ���� ��Ű�� �����ϰ� redirection�Ѵ�
		// �Ʒ� 3���� �ϳ��� ���޵ǰ� ������ NULL�� ���� > null �̾ƴѰ��� �����ϴ� ���
		String value = request.getParameter("value");
		String operator = request.getParameter("operator");
		String dot = request.getParameter("dot");

		String exp = "";
		if (cookies != null)
			for (Cookie c : cookies)
				if (c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
		// ��� ����
		if (operator != null && operator.equals("=")) {
			// �ڹٽ�ũ��Ʈ�� ������ �� �ִ� ������ü
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("graal.js");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				e.printStackTrace();
			}
		}
		// ��� ���� : ���⼭�� exp�� ���� ����ش� Ȥ�ó��ϴ� ������ġ ����
		else if (operator != null && operator.equals("C")) {
			exp = "";
		}
		else {
			exp += (value == null) ? "" : value;
			exp += (dot == null) ? "" : dot;
			exp += (operator == null) ? "" : operator;
		}
		

		Cookie expCookie = new Cookie("exp", exp);
		// ��� ���� : ���⼭�� ��Ű�� ������� ���ش�.(���� 0�̸� ��Ű ������)
		if (operator != null && operator.equals("C")) {
			expCookie.setMaxAge(0);
		}
		expCookie.setPath("");
		response.addCookie(expCookie);
		response.sendRedirect("/calcpage"); // ������ο� �����Ƿ� ��� ���� ������ �ʾƵ��� "calcpage" �̷���

	}
}
