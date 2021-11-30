<!-- 스파게티 코드를 만드는 JSP -->
<!-- MVC 모델 1 적용 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- --------------------------------Controller, View의 분리 -->
<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<title>Document</title>
</head>
<%
pageContext.setAttribute("result", "hello");
%>

<body>
	<!-- result == Model -->
	<%=request.getAttribute("result")%>
	<!-- EL표기법 : scope한정자 사용-->
	${requestScope.result}
	<!-- 배열형식 표현 : 키값[num]으로 배열처럼 사용할 수 있다. -->
	${names[1]}
	<!-- Map형식 표현 -->
	${notice.title}
	${result}
	<br />
	param, header값 뽑아보기 <br />
	${param.n}
	<br />
	${header.accept}  	<!-- accept는 브라우저 요청시 내가 읽어들일수 있는 문서 종류, 타입을 서버에 알려줌 -->


	<br /><br /><br /><br /><br />
	EL 연산자 사용하기 
	EL : >, gt <br />
	${param.n > 3} <br />
	${param.n gt 3} <br />
	<br />
	
	EL : >=, ge <br />
	${param.n >= 3} <br />
	${param.n ge 3} <br />
	<br />
	
	널이거나 빈문자이거나를 확인해서 참값 반환 empty <br />
	반대로 동작하고 싶으면 not empty <br />
	EL : empty <br />
	${empty param.n} <br /><br />
	3항연산자와 묶어서 사용가능 <br />
	${empty param.n? '값이 비어있습니다.' : param.n }
	<br /><br />
	
	
	${param.n/2 }
</body>
</html>





