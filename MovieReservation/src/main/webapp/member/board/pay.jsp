<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- JSTL위한 라이브러리 불러오기 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML>

<html>

<head>
    <meta charset="utf-8">
    <meta name="description" content="dbproject">
    <meta name="keywords" content="HTML5, CSS, JavaScript">
    <script src="/scripts/common.js"></script>
    <script>
        var swp = 0;
    </script>
    <style type="text/css">
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

        /* 여기까지가 상단 바 영역 */
        .table {
            margin-left: auto;
            margin-right: auto;
            margin-top: 50px;
        }

        .table_content_td {
            padding-top: 30px;
        }

        .attribute_div {
            float: left;
            width: 35%;
        }

        .content_div {
            float: left;
            width: 65%;
        }

        .payment_button {
            width: 100%;
            height: 50px;
            background-color: #ff4040;
            color: white;
            font-size: 16px;
            border: 0px;
        }

        .price_div {
            width: 383px;
            height: 50px;
            margin-left: 1px;
            padding-left: 15px;
            background-color: #404040;
            color: white;
            font-size: 16px;
            border: 0px;
            outline: 1px solid gray;
        }

        .price_div label {
            line-height: 50px;
        }

        .price_div_label {
            float: right;
            padding-right: 15px;
        }

        .method_combo {
            width: 200px;
            height: 50px;
            float: right;
            background-color: #404040;
            color: white;
            text-align: right;
        }
    </style>

</head>

<body>
    <header class="header">
        <div style="text-align:right;">
            <span>${sessionScope.sessionId}님 반갑습니다. </span>
            <a href="/join/logout">[로그아웃]</a>
        </div>
        <nav class="navigation">
            <a href="#" onclick="location.href='/member/index'"><img class="homelogo" src="/images/homelogo2.png"></a>
            <a href="#" class="a1"><b>예매하기</b></a>
            <hr style="left: 467px;" class="hr1">
            <a href="movie_chart" class="a2"><b>상영조회</b></a>
            <hr style="left: 657px;" class="hr2">
            <a href="look_up" class="a3"><b>예매조회</b></a>
            <hr style="left: 847px;" class="hr3">
        </nav>
    </header>
    <div>
        <form action="pay" method="post">
            <table class="table">
                <tr style="height:40px;text-align:center;">
                    <td style="background-color:#404040;outline:1px solid gray;width:300px;"><b><label
                                style="color:white">예매정보</label></b></td>
                    <td style="background-color:#404040;outline:1px solid gray;width:400px;"><b><label
                                style="color:white">결제</label></b></td>
                </tr>
                <tr style="height:600px;outline:1px solid gray;vertical-align:top;">
                    <td class="table_content_td">
                        <div style="text-align:center;">
                            <b>
                                <p style="font-size:20px;">${sessionScope.movieName}</p>
                            </b>
                        </div>
                        <div style="margin-left: 50px;">
                            <div class="attribute_div">
                                <b><label style="line-height:2;color:gray;">상영관</label></b><br>
                                <b><label style="line-height:2;color:gray;">상영일시</label></b><br>
                                <b><label style="line-height:2;color:gray;">인원수</label></b><br>
                                <b><label style="line-height:2;color:gray;">좌석번호</label></b><br>
                            </div>
                            <div class="content_div">
                                <label style="line-height:2">${sessionScope.pAudiId}</label><br>
                                <label style="line-height:2">${sessionScope.pScreenDay }</label><br>
                                <label style="line-height:2">${sessionScope.manCount }</label><br>
                                <label style="line-height:2;border:0px;width:120px;">${sessionScope.pSeatName
                                    }</label><br>
                            </div>
                        </div>
                    </td>
                    <td style="vertical-align:bottom;">
                        <div class="price_div">
                            <label>결제수단</label>
                            <select name="method" class="method_combo">
                                <option value="신용카드">신용카드</option>
                                <option value="계좌이체">계좌이체</option>
                            </select>
                        </div>
                        <div class="price_div"><label>상품금액</label><label class="price_div_label">
                                <fmt:formatNumber type="number" pattern=",###" value="${sessionScope.pTotalPrice }" />
                                원</label></div>
                        <div class="price_div"><label>결제금액</label><label class="price_div_label">
                                <fmt:formatNumber type="number" pattern=",###" value="${sessionScope.pTotalPrice }" />
                                원</label></div>
                        <input type="submit" value="결제하기" class="payment_button">
                    </td>
                </tr>
            </table>
        </form>
    </div>

</body>

</html>