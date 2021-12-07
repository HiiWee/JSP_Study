<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- JSTL위한 라이브러리 불러오기 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <!-- <link rel="stylesheet" href="../../css/style.css"> -->
    <title>영화 예매하기</title>

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


        * {
            box-sizing: border-box
        }

        .table {
            margin-left: auto;
            margin-right: auto;
            margin-top: 50px;
        }

        .tdattribute {
            background-color: #404040;
            color: white;
            height: 35px;
        }

        .tdentity {
            background-color: #f2f0e5;
            height: 600px;
            vertical-align: top;
        }

        .purchasebutton {
            float: right;
            background-color: white;
            width: 120px;
            height: 30px;
            margin-right: 20px;
            border: 1px solid gray;
            transition: 0.6s ease-in-out;
        }









        input[id="a01"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="a01"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="a01"] {
            display: none;
        }

        input[id="a02"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="a02"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="a02"] {
            display: none;
        }

        input[id="a03"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="a03"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="a03"] {
            display: none;
        }

        input[id="a04"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="a04"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="a04"] {
            display: none;
        }

        input[id="a05"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="a05"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="a05"] {
            display: none;
        }

        input[id="a06"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="a06"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="a06"] {
            display: none;
        }

        input[id="a07"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="a07"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="a07"] {
            display: none;
        }

        input[id="a08"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="a08"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="a08"] {
            display: none;
        }

        input[id="a09"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="a09"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="a09"] {
            display: none;
        }

        input[id="a10"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="a10"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="a10"] {
            display: none;
        }

        input[id="b01"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="b01"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="b01"] {
            display: none;
        }

        input[id="b02"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="b02"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="b02"] {
            display: none;
        }

        input[id="b03"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="b03"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="b03"] {
            display: none;
        }

        input[id="b04"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="b04"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="b04"] {
            display: none;
        }

        input[id="b05"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="b05"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="b05"] {
            display: none;
        }

        input[id="b06"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="b06"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="b06"] {
            display: none;
        }

        input[id="b07"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="b07"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="b07"] {
            display: none;
        }

        input[id="b08"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="b08"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="b08"] {
            display: none;
        }

        input[id="b09"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="b09"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="b09"] {
            display: none;
        }

        input[id="b10"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="b10"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="b10"] {
            display: none;
        }

        input[id="c01"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="c01"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="c01"] {
            display: none;
        }

        input[id="c02"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="c02"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="c02"] {
            display: none;
        }

        input[id="c03"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="c03"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="c03"] {
            display: none;
        }

        input[id="c04"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="c04"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="c04"] {
            display: none;
        }

        input[id="c05"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="c05"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="c05"] {
            display: none;
        }

        input[id="c06"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="c06"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="c06"] {
            display: none;
        }

        input[id="c07"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="c07"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="c07"] {
            display: none;
        }

        input[id="c08"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="c08"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="c08"] {
            display: none;
        }

        input[id="c09"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="c09"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="c09"] {
            display: none;
        }

        input[id="c10"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="c10"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="c10"] {
            display: none;
        }

        input[id="d01"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="d01"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="d01"] {
            display: none;
        }

        input[id="d02"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="d02"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="d02"] {
            display: none;
        }

        input[id="d03"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="d03"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="d03"] {
            display: none;
        }

        input[id="d04"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="d04"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="d04"] {
            display: none;
        }

        input[id="d05"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="d05"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="d05"] {
            display: none;
        }

        input[id="d06"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="d06"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="d06"] {
            display: none;
        }

        input[id="d07"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="d07"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="d07"] {
            display: none;
        }

        input[id="d08"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="d08"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="d08"] {
            display: none;
        }

        input[id="d09"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="d09"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="d09"] {
            display: none;
        }

        input[id="d10"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="d10"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="d10"] {
            display: none;
        }

        input[id="e01"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="e01"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="e01"] {
            display: none;
        }

        input[id="e02"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="e02"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="e02"] {
            display: none;
        }

        input[id="e03"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="e03"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="e03"] {
            display: none;
        }

        input[id="e04"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="e04"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="e04"] {
            display: none;
        }

        input[id="e05"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="e05"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="e05"] {
            display: none;
        }

        input[id="e06"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="e06"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="e06"] {
            display: none;
        }

        input[id="e07"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="e07"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="e07"] {
            display: none;
        }

        input[id="e08"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="e08"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="e08"] {
            display: none;
        }

        input[id="e09"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="e09"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="e09"] {
            display: none;
        }

        input[id="e10"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="e10"]:checked+label {
            background-color: #666666;
            color: white;
        }

        input[id="e10"] {
            display: none;
        }

        input[id="a11"]+label {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #bcbcbc;
            cursor: pointer;
            font-size: 12px;
        }

        input[id="a11"]:checked+label {
            background-color: red;
            color: white;
        }

        input[id="a11"] {
            display: none;
        }
    </style>

    <script type="text/javascript" src="/scripts/common.js"></script>
</head>

<body>
    <header class="header">
        <div style="text-align:right;">
            <span>${sessionId}님 반갑습니다. </span>
            <a href="/join/logout">[로그아웃]</a>
        </div>
        <nav class="navigation">
            <a href="#" onclick="location.href='/member/index'"><img class="homelogo" src="/images/homelogo2.png"></a>
            <a href="reservate" class="a1"><b>예매하기</b></a>
            <hr style="left: 467px;" class="hr1">
            <a href="movie_chart" class="a2"><b>상영조회</b></a>
            <hr style="left: 657px;" class="hr2">
            <a href="look_up" class="a3"><b>예매조회</b></a>
            <hr style="left: 847px;" class="hr3">
        </nav>
    </header>
    <div>
        <form action="reservate" method="post">
            <!-- 값 숨겨놓기 -->
            <table class="table">
                <tr style="text-align:center;">
                    <td class="tdattribute" width="1000px"><b>인원 / 좌석</b></td>
                </tr>
                <tr>
                    <td style="background-color:#f2f0e5;height:100px;vertical-align:top;border-bottom:2px solid gray;">
                        <div style="float:left;width:50%;border-right:1px solid gray;height:90%;margin-top:5px;">
                            <label style="margin-left:40%;">성인</label>
                            <!-- 사람인원수 전달 -->
                            <select id="combnum" name="manCount"
                                style="background-color:white;width:100px;border-width:0px;margin-top:30px;"
                                onchange="num_of_seat()">
                                <option value="1">1명</option>
                                <option value="2">2명</option>
                                <option value="3">3명</option>
                                <option value="4">4명</option>
                                <option value="5">5명</option>
                                <option value="6">6명</option>
                                <option value="7">7명</option>
                                <option value="8">8명</option>
                            </select>
                        </div>
                        <div style="float:right;width:50%;height:90%;margin-top:5px;">
                            <!-- get으로 받아온 데이터 뿌리기 -->
                            <label style="margin-left:10px;">장소:</label><label
                                style="margin-left:10px;">${requestScope.audi}</label><br>
                            <label style="margin-left:10px;">날짜/시간 : ${requestScope.day}</label><br>
                            <label style="margin-left:10px;">가격: </label><label style="margin-left:10px;"
                                id="price">14000</label>
                            <input type="submit" onclick="is_fit_num()" class="purchasebutton" value="다음" />
                        </div>
                    </td>
                </tr>

                <tr style="text-align:center;">
                    <td style="background-color:#fff6ea;height:400px;vertical-align: top;">
                        <br><b><button
                                style="border:1px solid gray; width:500px; background-color:#F0F0F0;height:30px;">S C R
                                E E
                                N</button></b><br><br><br><br>
                        <b><label>A</label></b>
                        <c:forEach var="seatList" items="${seatList}" varStatus="st">
                            <c:if test="${st.count == 11 }">
                                <br /><b><label>B</label></b>
                            </c:if>
                            <c:if test="${st.count == 21 }">
                                <br /><b><label>C</label></b>
                            </c:if>
                            <c:if test="${st.count == 31 }">
                                <br /><b><label>D</label></b>
                            </c:if>
                            <c:if test="${st.count == 41 }">
                                <br /><b><label>E</label></b>
                            </c:if>

                            <c:set var="open" value="" />
                            <c:set var="seperate" value="id='${seatList.seatId }'" />
                            <c:set var="labelSep" value="for='${seatList.seatId }'" />
                            <c:set var="alreadySeat" value="seat" />
                            <c:set var="valueSep" value="${seatList.seatId}" />

                            <c:if test="${seatList.pub == false}">
                                <c:set var="open" value="checked disabled" />
                                <c:set var="seperate" value="id='a11'" />
                                <c:set var="labelSep" value="for='a11'" />
                                <c:set var="alreadySeat" value="alreadySeat" />
                                <c:set var="valueSep" value="a11" />
                            </c:if>
                            <c:if test="${st.count < 11 }">
                                <input type="checkbox" ${seperate } name="${alreadySeat}" ${open}
                                    value="${valueSep}"><label ${labelSep }>${st.count % 11 }</label>
                            </c:if>
                            <c:if test="${st.count >= 11 && st.count < 21 }">
                                <input type="checkbox" ${seperate } name="${alreadySeat}" ${open}
                                    value="${valueSep}"><label ${labelSep }>${st.count % 11 + 1 }</label>
                            </c:if>
                            <c:if test="${st.count >= 21 && st.count < 31 }">
                                <input type="checkbox" ${seperate } name="${alreadySeat}" ${open}
                                    value="${valueSep}"><label ${labelSep }>${st.count % 21 + 1}</label>
                            </c:if>
                            <c:if test="${st.count >= 31 && st.count < 41 }">
                                <input type="checkbox" ${seperate } name="${alreadySeat}" ${open}
                                    value="${valueSep}"><label ${labelSep }>${st.count % 31 + 1}</label>
                            </c:if>
                            <c:if test="${st.count >= 41 && st.count < 51 }">
                                <input type="checkbox" ${seperate } name="${alreadySeat}" ${open}
                                    value="${valueSep}"><label ${labelSep }>${st.count % 41 + 1}</label>
                            </c:if>
                        </c:forEach>
                    </td>
                </tr>
            </table>
        </form>
    </div>




</body>
</body>

</html>