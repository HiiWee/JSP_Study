<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	

<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <title>로그인 영화 메인 페이지</title>
  <style>
    /* 공통 : 홈 로고영역 */
	.header{
		position: relative;
		width: 1200px;
		margin: 0 auto;
	}
	.homelogo{
		width: 350px;
	}
    .navigation {
      height: 110px;
	  width: 100%;
	  border-bottom: 2px solid #e0e0e0;
    }
	.a1, .a2, .a3{
		text-decoration: none;
		color: black;
		margin-left: 120px;
		
	}
	.hr1, .hr2, .hr3{
		width: 80px;
		position: absolute;		
		top: 120px;
		height: 3px;
		background-color: #428bca;
		display: none;
	}
	.a1:hover ~ .hr1{
		display:block;
	}
	.a2:hover ~ .hr2{
		display:block;
	}
	.a3:hover ~ .hr3{
		display:block;
	}
	.table{
		margin-left: auto;
		margin-right: auto;
	}
	.content_div{
		margin: 0 auto;
		width: 1200px;
		height: 450px;
	}
	.poster_image{
		max-height:300px;
		padding-top: 20px;
		position: absolute;
		z-index:2;
		transition:0.5s ease-in-out;
	}
	.poster_image:hover{
		cursor: pointer;
		opacity: 60%;
	}
	.movie_content_td{
		width: 270px;
	}
	.scheduletorelease_div{
		position: relative;
		margin: 0 auto;
		text-align: center;
	}
	.scheduletorelease_div img{
		height: 680px;
	}
  </style>
</head>

<body>
		
	<header class="header">
		<div style="text-align:right;">
			<span>${sessionId}님 반갑습니다. </span>
			<a href="/join/logout">[로그아웃]</a>
		</div>
		<nav class="navigation">
			<a href="#" onclick="location.href='/member/index'"><img class="homelogo" src="/images/homelogo2.png"></a>
			<a href="board/movie_list" class="a1"><b>예매하기</b></a>
			<hr style="left: 467px;" class="hr1">
			<a href="board/movie_chart" class="a2"><b>상영조회</b></a>
			<hr style="left: 657px;" class="hr2">
			<a href="board/look_up" class="a3"><b>예매조회</b></a>
			<hr style="left: 847px;" class="hr3">
		</nav>
	</header>
	<br><br>
	<div class="content_div">
		<br>
		<div style="text-align:center;"><label style="font-size:30px; color:black;"><b>인기영화</b></label></div>
		<table class="table">
			<tr>
				<td class="movie_content_td"><img src="/images/Movies/eternals_poster.jpg" class="poster_image"></td>
				<td class="movie_content_td"><img src="/images/Movies/out_of_body_poster.jpg" class="poster_image"></td>
				<td class="movie_content_td"><img src="/images/Movies/romance_without_love_poster.jpg" class="poster_image"></td>
				<td class="movie_content_td"><img src="/images/Movies/encanto_poster.jpg" class="poster_image"></td>
				<td class="movie_content_td"><img src="/images/Movies/dune_poster.jpg" class="poster_image"></td>
			</tr>
		</table>
	</div>
	<div class="scheduletorelease_div">
		<label style="font-size:30px;  color:black;"><b>개봉예정 영화</b></label><br><br>
		<a href="https://www.youtube.com/watch?v=yFZh-Wqi7RI" target="_blank"><img src="/images/Movies/spiderman_poster.jpg"></a>
		<a href="https://www.youtube.com/watch?v=yEPgqn5f1uk" target="_blank"><img src="/images/Movies/matrix_poster.jpg"></a>
		<a href="https://www.youtube.com/watch?v=DJs_ihmMZfg" target="_blank"><img src="/images/Movies/encanto_poster.jpg"></a>
	</div>	
	
	<main>
	
	</main>
</body>

</html>