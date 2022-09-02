<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>TAC(Try And Choice)</title>
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
			<div class="wrapper bg-white">
				<img id="logintitle" src="../../../resources/image/logo2.png">
				<div class="h4 text-muted text-center pt-2">로그인 정보를 입력하세요</div>
				<form class="pt-3" method="post" name="FormLogin" action="/login_result">
					<div class="form-group py-2">
						<div class="input-field"> <span class="far fa-user p-2"></span> <input type="text" name="id"
								placeholder="Enter your ID" required class=""> </div>
					</div>
					<div class="form-group py-1 pb-2">
						<div class="input-field"> <span class="fas fa-lock p-2"></span> <input type="password"
								name="password" placeholder="Enter your Password" required class="">
						</div>
					</div>
					<button class="btn btn-block text-center my-3" type="submit">Log in</button>
					<div class="text-center pt-3 text-muted">Not a member? <a href="/signup">Sign up</a></div>
				</form>
			</div>
		</body>

		</html>