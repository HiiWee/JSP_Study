<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <title>상영조회</title>
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
        /* 메인 영역 */
        main {
            overflow: hidden;
            background-color: white;
        }

        ul {
            list-style-type: none;
        }

        main ul img {
            /* border: red 1px solid; */
            height: 400px;
        }

        main ul {
            float: left;
            /* background-color: red; */
            margin: 0 auto;
            padding: 15px;

        }

        main .moviesInfo {
            background-color: rgb(223, 215, 205);
            width: 820px;
            overflow: hidden;
            border-radius: 12px;
            margin: 100px auto;
        }
        main .movieInfo {
            width: 420px;
        }

        main .name {
            font-size: 42px;
            font-family: Arial, Helvetica, sans-serif;
        }

        main .genre {
            margin-top: 15px;
            font-size: 15px;
            font-family: Arial, Helvetica, sans-serif;
        }

        main .info {
            margin-top: 15px;
            font-size: 12px;
            font-family: Arial, Helvetica, sans-serif;
        }
    </style>
</head>

<body>
  	<header class="header">
		<div style="text-align:right;">
			<a href="/join/login">로그인</a>
		</div>
		<nav class="navigation">
			<a href="#" onclick="location.href='/index'"><img class="homelogo" src="/images/homelogo2.png"></a>
			<a href="#" onclick="alert('로그인하세요'); location.href='/join/login'" class="a1"><b>예매하기</b></a>
			<hr style="left: 467px;" class="hr1">
			<a href="movie_chart" class="a2"><b>상영조회</b></a>
			<hr style="left: 657px;" class="hr2">
			<a href="#" onclick="alert('로그인하세요'); location.href='/join/login'" class="a3"><b>예매조회</b></a>
			<hr style="left: 847px;" class="hr3">
		</nav>
	</header>
    <main>
    	<c:forEach var="movie" items="${list}">
        <div class="moviesInfo">

            <ul class="movieImg">
                <li>
                	<img src="/images/Movies/${movie.files}">
                </li>
            </ul>
            <ul class="movieInfo">
                <li class="name">
                    ${movie.name }
                </li>
                <hr>
                <li class="genre">
                    ${movie.genre }/ ${movie.openDay}
                </li>
                <li class="info">
                    ${movie.content }
                </li>
            </ul>
        </div>
    	</c:forEach>
    </main>
</body>

</html>