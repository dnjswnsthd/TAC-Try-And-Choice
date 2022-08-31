<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.service.tac.model.vo.Member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TAC(Try And Choice)</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />

<!-- jQuery library -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script src="/resources/js/card.js" rel="text/javascript"></script>
<link rel="stylesheet" href="/resources/css/header.css" />
<link rel="stylesheet" href="/resources/css/login_result.css" />
</head>
<body>
	<jsp:include page="/resources/component/header.jsp"></jsp:include>
	
	<div class="wrapper bg-white">
	    <div class="h4 text-muted text-center pt-2">${member.memberId}님 로그인 성공!</div>
	    <div class="serviceBtn">
		    <button type="button" class="btn btn-block text-center my-3" >내 소비정보보기</button>
			<button type="button" class="btn btn-block text-center my-3" > 카드비교하기</button>
		</div>
	</div>
	<%
		//세션 받아오기
		Object id=session.getAttribute("id");
	%>

</body>
</html>