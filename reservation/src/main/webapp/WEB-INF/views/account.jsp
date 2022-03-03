<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width">
        <title>Account</title>
    	<link rel="shortcut icon" href="img/favicon.ico">
        <link rel="stylesheet" href="src/account.css" type="text/css">
        <script src="src/account.js"></script>
    </head>
    <body>
        <div>
            <div id="top">
                <span id="white_green">N</span><span id="black_bold">예약</span>
            </div>
            <c:choose>
                <c:when test="${sessionScope.account != null}">
                <form method="get" action="logOut">
                    <div id="bold">현재 사용중인 계정</div>
                    <hr>
                    <div id="gray">${sessionScope.account}</div>
                    <hr>
                    <div id="check">내 예약 확인</div>
                    <input id="red_white" type="submit" value="로그아웃">
                </form>
                </c:when>
                <c:otherwise>
                    <form method="get" action="logIn">
                        <div id="bold">비회원 예약확인</div>
                        <hr>
                        <input id="email_form" type="email" name="mail" value="예약자 이메일 입력">
                        <br>
                        <input id="green_white" type="submit" value="내 예약 확인">
                    </form>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>