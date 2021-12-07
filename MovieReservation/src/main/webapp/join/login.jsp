<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>LogIn</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <style>
        /* 공통 : 홈 로고영역 */
        .header {
            position: relative;
            width: 1200px;
            margin: 0 auto;
        }

        .homelogo {
            width: 350px;
        }

        .navigation {
            height: 110px;
            width: 100%;
            border-bottom: 2px solid #e0e0e0;
        }

        .a1,
        .a2,
        .a3 {
            text-decoration: none;
            color: black;
            margin-left: 120px;

        }

        .hr1,
        .hr2,
        .hr3 {
            width: 80px;
            position: absolute;
            top: 120px;
            height: 3px;
            background-color: #428bca;
            display: none;
        }

        .a1:hover~.hr1 {
            display: block;
        }

        .a2:hover~.hr2 {
            display: block;
        }

        .a3:hover~.hr3 {
            display: block;
        }

        .table {
            margin-left: auto;
            margin-right: auto;
        }

        .content_div {
            margin: 0 auto;
            width: 1200px;
            height: 450px;
        }

        .poster_image {
            max-height: 300px;
            padding-top: 20px;
            position: absolute;
            z-index: 2;
            transition: 0.5s ease-in-out;
        }

        .poster_image:hover {
            cursor: pointer;
            opacity: 60%;
        }

        .movie_content_td {
            width: 270px;
        }

        .scheduletorelease_div {
            position: relative;
            margin: 0 auto;
            text-align: center;
        }

        .scheduletorelease_div img {
            height: 680px;
        }

        .container {
            width: 385px;
            line-height: 50px;
            margin: 60px auto;
        }

        h5 {
            text-align: center;
        }

        h5 span {
            color: teal;
        }

        .login {
            background-color: rgb(255, 80, 90);
            color: white;
            border-radius: 5px;
            border: 0;
            padding: 10px 172px;
        }

        #signup {
            background-color: white;
            color: teal;
            border: 0;
            font-size: 17px;
        }

        p {
            text-align: center;
        }

        i {
            color: lightgray;
        }

        #imail {
            position: absolute;
            top: 130px;
            margin: 0 355px;
        }

        #ipw {
            position: absolute;
            top: 180px;
            margin: 0 355px;
        }

        input {
            border: 1px solid lightgray;
            border-radius: 3px;
        }
    </style>
</head>

<body>
    <header class="header">
        <div style="text-align:right;">
            <a href="login">로그인</a>
        </div>
        <nav class="navigation">
            <a href="#" onclick="location.href='/index'"><img class="homelogo" src="/images/homelogo2.png"></a>
            <a href="#" onclick="alert('로그인하세요'); location.href='/join/login'" class="a1"><b>예매하기</b></a>
            <hr style="left: 467px;" class="hr1">
            <a href="/member/board/movie_chart" class="a2"><b>상영조회</b></a>
            <hr style="left: 657px;" class="hr2">
            <a href="#" onclick="alert('로그인하세요'); location.href='/join/login'" class="a3"><b>예매조회</b></a>
            <hr style="left: 847px;" class="hr3">
        </nav>
    </header>

    <div class="container">
        <h5><span>로그인</span> 페이지입니다.</h5>
        <hr />
        <!-- -------------JSP FORM------------------- -->
        <form action="login" method="post">
            <input type="text" placeholder="아이디" name="memberId" required style="height:30px; width: 380px" /><br />
            <input type="password" placeholder="비밀번호" name="pwd" required style="height:30px; width: 380px" /><br />
            <input type="submit" value="로그인" class="login" />
            <button onclick="location.href='/index.jsp';" class="login">HOME</button>
        </form>
        <!-- -------------JSP FORM------------------- -->

        <hr />
        <p><a href="join_in"><input type="button" value="회원가입" id="signup" /></a></p>
    </div>

    <c:if test="${idChk == -1}">
        <script>
            alert("존재하지 않는 아이디 입니다.");
        </script>
    </c:if>
    <c:if test="${idChk == 0}">
        <script>
            alert("비밀번호가 틀렸습니다.");
        </script>
    </c:if>
</body>

</html>