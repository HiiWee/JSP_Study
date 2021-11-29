// ���� ���α׷��� �ϳ��� �������� ��ġ��
// calc3.java�� calcPage.java�� doGet(), doPost() �޼ҵ带 �̿��Ͽ� ��ġ��

package com.hoseok.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// GET ��û�� POST ��û�� �����ؼ� �ۼ��ϱ�
// 1. service�Լ����� �������� �����
// 2. get��û�� post ��û�� Ưȭ�� �޼ҵ�
@WebServlet("/calculator")
public class Calculator extends HttpServlet {
//	@Override
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		// 1. service�Լ����� �������� ���
//		// �޼ҵ��� ��û�� get�̳� post�� ��ȯ����
//		// ������ html�� method �ɼǰ��� ���޵Ǿ� �Ѿ���°� �ƴϹǷ� �빮�ڷ� ���
//		if (request.getMethod().equals("GET")) {
//			System.out.println("GET ��û�� �Խ��ϴ�.");
//		}
//		else if (request.getMethod().equals("POST")) {
//			System.out.println("POST ��û�� �Խ��ϴ�.");
//		}
//		
//		// 2. �� �ٸ� ��� get��û�� post ��û�� Ưȭ�� �޼ҵ�
//		// �θ� ���� service�Լ��� get���� post���� Ȯ���ؼ� doGet(), doPost() �޼ҵ带 ������ ������
//		// �ٸ� HttpServlet�� �߻�Ŭ�����̹Ƿ� �޼ҵ���� �������̵� �������
//		super.service(request, response);
//		
//	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();
		// ������� �̱� ����
		String exp = "0";
		if (cookies != null)
			for (Cookie c : cookies)
				if (c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; utf-8");
		PrintWriter out = response.getWriter();
		// <!-- <------------------------------ ������ ������(���� ������)�� �ʿ伺
		// -----------------------------==> -->
		// <!-- ó������ ���������� ������ ������ �������� ���� ����� -->

		out.write("<!doctype html>");
		out.write("<html lang=\"ko\">");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\" />");
		out.write("<title>calc program</title>");
		out.write("</head>");
		out.write("<style>");
		out.write("	input {");
		out.write("		width: 50px;");
		out.write("		height: 50px;");
		out.write("	}");
		out.write("	.output {");
		out.write("		height: 50px;");
		out.write("		background-color: #e9e9e9;");
		out.write("		font-size: 24px;");
		out.write("		font-weight: bold;");
		out.write("		text-align: right;");
		out.write("		padding: 0px 5px;");
		out.write("	}");
		out.write("</style>");
		out.write("<body>");
		out.write("	<div>");
		// action�������� : ���� �������� post�� url�� �����Ƿ� ���� ���� �ʾƵ���
		out.write("		<form method=\"post\">");
		out.write("			<table>");
		out.write("				<tr>");
		out.printf("					<td class=\"output\" colspan=\"4\">%s</td>", exp);
		out.write("				</tr>");
		out.write("				<tr>");
		out.write("					<td><input type=\"submit\" name=\"operator\" value=\"CE\"/></td>");
		out.write("					<td><input type=\"submit\" name=\"operator\" value=\"C\"/></td>");
		out.write("					<td><input type=\"submit\" name=\"operator\" value=\"BS\"/></td>");
		out.write("					<td><input type=\"submit\" name=\"operator\" value=\"/\"/></td>");
		out.write("				</tr>");
		out.write("				<tr>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"7\"/></td>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"8\"/></td>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"9\"/></td>");
		out.write("					<td><input type=\"submit\" name=\"operator\" value=\"*\"/></td>");
		out.write("				</tr>");
		out.write("				<tr>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"4\"/></td>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"5\"/></td>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"6\"/></td>");
		out.write("					<td><input type=\"submit\" name=\"operator\" value=\"-\"/></td>");
		out.write("				</tr>");
		out.write("				<tr>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"1\"/></td>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"2\"/></td>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"3\"/></td>");
		out.write("					<td><input type=\"submit\" name=\"operator\" value=\"+\"/></td>");
		out.write("				</tr>");
		out.write("				<tr>");
		out.write("					<td></td>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"0\"/></td>");
		out.write("					<td><input type=\"submit\" name=\"dot\" value=\".\"/></td>");
		out.write("					<td><input type=\"submit\" name=\"operator\" value=\"=\"/></td>");
		out.write("				</tr>");
		out.write("			</table>");
		out.write("		</form>");
		out.write("	</div>");
		out.write("</body>");
		out.write("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
		} else {
			exp += (value == null) ? "" : value;
			exp += (dot == null) ? "" : dot;
			exp += (operator == null) ? "" : operator;
		}
		
		Cookie expCookie = new Cookie("exp", exp);
		// ��� ���� : ���⼭�� ��Ű�� ������� ���ش�.(���� 0�̸� ��Ű ������)
		if (operator != null && operator.equals("C")) {
			expCookie.setMaxAge(0);
		}
		expCookie.setPath("/calculator");
		response.addCookie(expCookie);
		// �ڱ� �ڽ��� �������� �����̷�Ʈ (�ڱⰡ �ڽ��� ȣ���ص� get��û�� �ǹ��Ѵ� >> doGet()�Լ� ȣ��� >> �ٽ� ���� html ���)
		response.sendRedirect("calculator");
		
	}
}
