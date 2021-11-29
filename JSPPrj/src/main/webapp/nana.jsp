<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 출력방식은 UTF-8 -->
<!-- 브라우져가 html, utf-8로 인식 -->


<%
// 출력도구를 직접 안만들어도됨 > 내장객체 있기때문
//response.setCharacterEncoding("UTF-8");		지시자를 통해 이미 인코딩방식 설정함
//response.setContentType("text/html; charset=UTF-8");
/* PrintWriter out = response.getWriter(); out 내장객체 이미 존재하므로 없앰*/

String cnt_ = request.getParameter("cnt");
int cnt = 10;
if (cnt_ != null && !cnt_.equals(""))
	cnt = Integer.parseInt(cnt_);
%>




<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<title>Document</title>
</head>
<body>
	<%
	// 한 문장이어도 jsp는 두문장이라 생각하고 코드블록을 꼭 써줘야함
	for (int i = 0; i < cnt; i++) {
	%>
	안녕 Servlet!!
	<br>
	<%
	}
	%>
</body>
</html>