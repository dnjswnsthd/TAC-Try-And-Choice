<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>회원탈퇴</title>
			<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />

			<!-- jQuery library -->
			<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>

			<!-- Popper JS -->
			<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

			<!-- Latest compiled JavaScript -->
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
			<script src="/resources/js/card.js" rel="text/javascript"></script>
			<link rel="stylesheet" href="/resources/css/login.css" />
			<link rel="stylesheet" href="/resources/css/header.css" />
		</head>

		<body>
			<jsp:include page="/resources/component/header.jsp"></jsp:include>
			<div id="loginbox" class="wrapper bg-white">
				<img id="logintitleimg" src="../../../resources/image/WhereAreyougoing.png">
				<div id="logintitletext" class="h4 text-muted text-center pt-2">진짜 가?</div>
				<button id="singupbtn"  class="btn btn-block text-center my-3 regibtn" onclick="deletemember()">간다~</button>
				<button id="singupbtn"  class="btn btn-block text-center my-3 regibtn" onclick="gomain()">안갈게!</button>
			</div>
		</body>
		<script>
			function deletemember() {
				location.href = '/deleteMember';
			}
			function gomain(){
				location.href = '/main';
			}
		</script>

		</html>