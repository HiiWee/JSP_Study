<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <!-- <link rel="stylesheet" type="text/css" href="/css/style.css"> -->
    <title>회원정보 수정</title>

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

        /* 회원가입 영역 css */
        .container {
            width: 500px;
            margin: 60px auto;
            line-height: 16px;
        }

        h5 {
            text-align: center;
        }

        h5 span {
            color: teal;
        }

        .n {
            font-size: 13px;
        }

        #signup {
            background-color: rgb(255, 80, 90);
            color: white;
            border: 0;
            border-radius: 5px;
            padding: 10px 224px;
        }

        .bottom input {
            background-color: white;
            border: 0;
            color: teal;
            font-size: 16px;
        }

        input {
            border: 1px solid lightgray;
            border-radius: 3px;
        }
    </style>
</head>

<body>
    <header class="header">
        <div style="text-align: right;">
            <span>${sessionId}님 반갑습니다. </span> <a href="/join/logout">[로그아웃]</a>
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

    <main class="form">
        <div class="container">
            <h5><span>회원 수정</span> 페이지입니다.</h5>
            <hr /><br />
            <!-- -------------JSP FORM------------------- -->
            <form action="edit_member" method="post">
                <input type="text" value="${member.memberId}" name="memberId" required
                    style="height:30px; width: 495px" readonly/><br /><br />
                <input type="password" placeholder="비밀번호" name="pwd1" required
                    style="height:30px; width: 495px" /><br /><br />
                <input type="password" placeholder="비밀번호 확인" name="pwd2" required
                    style="height:30px; width: 495px" /><br /><br />
                <input type="text" value="${member.name }" name="name" required
                    style="height:30px; width: 495px" /><br /><br />
                <input type="text" value="${member.phone }" name="phone" />
                <p>
                    <input type="submit" value="변경하기" id="signup" /><br /><br />
                </p>
            </form>
            <!-- -------------JSP FORM------------------- -->
            <hr />
        </div>
    </main>

    <!-- 회원가입 실패시 메시지 출력 -->
    <c:if test="${pwdChk == -1 }">
        <script>
            alert("비밀번호와 비밀번호 확인이 다릅니다.");
        </script>
    </c:if>
    <c:if test="${pwdChk == 0 }">
        <script>
            alert("바뀐 정보가 없습니다");
        </script>
    </c:if>

</body>

</html>