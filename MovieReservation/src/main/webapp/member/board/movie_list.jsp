<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE HTML>

<html>

<head>
    <meta charset="utf-8">
    <meta name="description" content="dbproject">
    <meta name="keywords" content="HTML5, CSS, JavaScript">
    <script src="common.js"></script>
    <style type="text/css">
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

        /* 여기까지가 상단바 */
        .main {
            position: relative;
            width: 800px;
            margin: 50px auto;
            padding-top: 20px;
        }

        .maindiv {
            outline: 1px solid gray;
            border-radius: 5px;
            background: linear-gradient(to bottom, #c1a896, #f7f3f2)
        }

        .titlediv {
            padding-left: 10px;
            padding-top: 20px;
        }

        .titlediv label {
            color: white;
        }

        .titlediv button {
            background-color: transparent;
            border-radius: 10px;
            border: 1px solid white;
            color: white;
            margin-left: 10px;
        }

        .title_label {
            color: white;
        }

        .stripeline {
            height: 175px;
            float: left;
            margin-left: 10px;
            margin-right: 20px;
            margin-top: 10px;
        }

        .nav {
            height: 50px;
            width: 100%;
            text-align: center;
            overflow: hidden;
            padding-top: 10px;
        }

        .nav_div {
            float: left;
            margin-right: 15px;
            border-radius: 2px;
            padding-top: 4px;
            padding-bottom: 4px;
            padding-left: 8px;
            padding-right: 8px;
        }

        .detail_div {
            margin-left: 10px;
            padding-top: 1px;
            padding-left: 5px;
            border-radius: 10px;
            background-color: white;
            margin-right: 10px;
            height: 330px;
        }

        .movieposter {
            width: 140px;
            float: right;
            margin-right: 70px;
            margin-top: 10px;
            border-radius: 5px;
        }

        .attribute_div {
            float: left;
            width: 10%;
        }

        .attribute_div label {
            color: gray;
            line-height: 2;
        }

        .content_div {
            float: left;
        }

        .content_div label {
            line-height: 2;
        }

        .introduce_div {
            margin-left: 10px;
            padding-top: 1px;
            padding-left: 15px;
            border-radius: 10px;
            background-color: white;
            margin-right: 10px;
            height: 200px;
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
			<a href="movie_list" class="a1"><b>예매하기</b></a>
			<hr style="left: 467px;" class="hr1">
			<a href="movie_chart" class="a2"><b>상영조회</b></a>
			<hr style="left: 657px;" class="hr2">
			<a href="look_up" class="a3"><b>예매조회</b></a>
			<hr style="left: 847px;" class="hr3">
		</nav>
	</header>
	
	
    <c:forEach var="movie" items="${list}">
        <form action="reservate" method="get">
            <main class="main">
                <!-- form데이터 -->
                <!-- 세션저장 -->
                <input type="hidden" name="movieId" value="${movie.movieId }" />
                <input type="hidden" name="name" value="${movie.name }" />
                <input type="hidden" name="audiId" value="${movie.audiId }" />
                
                <input type="hidden" name="screenDay" value="${movie.screenDay }" />
                <div class="maindiv">
                    <div class="titlediv">
                        <b><label style="font-size: 20px;">${movie.name }</label></b><button><b>상영중</b></button><br>
                        <label>영화 </label><label>l</label><label> 2021 </label>
                        <nav class="nav">
                            <div id="nav_2" class="nav_div" style="background-color: #846149" onclick="selectnav(2)">
                                <label>기본정보</label>
                            </div>
                        </nav>
                    </div>
                    <div class="detail_div">
                        <br>
                        <image src="/images/stripeline.png" class="stripeline">
                            <image src="/images/Movies/${movie.files}" class="movieposter">
                                <div class="attribute_div">
                                    <b><label>개봉 </label></b><br>
                                    <b><label>장르 </label></b><br>
                                    <b><label>상영일 </label></b><br>
                                    <b><label>상영관 </label></b><br>
                                    <b><label>남은좌석 </label></b><br>
                                </div>
                                <div class="content_div">
                                    <label>${movie.openDay } </label><br>
                                    <label>${movie.genre } </label><br>
                                    <label>${movie.screenDay } </label><br>
                                    <label>${movie.audiId } </label><br>
                                    <label>${movie.totalSeat } </label><br>
                                </div>
                                <!-- 버튼 -->
                                <div><input type="submit" value="예매하기"
                                        style="width: 120px; position:relative; top:220px; right:-385px;"></div>
                    </div>
                    <label style="color:white">.</label>
                    <div class="introduce_div">
                        <b>
                            <p>소개</p>
                        </b>
                        <label>${movie.content }</label>
                    </div>
                    <label style="color:white">.</label>
                </div>
            </main>
        </form>
    </c:forEach>
</body>

</html>