<%@page import="com.service.tac.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" href="/resources/css/login.css" />
<link rel="stylesheet" href="/resources/css/header.css" />
<script>
	var result=confirm('정말 로그아웃 하시겠습니까?');
	console.log(result);
	if(result){

	}
	else{
		history.back();
	}
</script>
</head>
<body>
	<%
		Member member = (Member) session.getAttribute("member");
		if ( member != null ) {
			session.invalidate();
		}
	%>
	<jsp:include page="/resources/component/header.jsp"></jsp:include>
	<div class="wrapper bg-white">
	    <div class="h2 text-center">TAC</div>
	    <div class="h4 text-muted text-center pt-2">로그아웃되었습니다.</div>
	    <button class="btn btn-block text-center my-3" onclick="location.href='/main'" >HOME</button>   
</div>
</body>
</html>