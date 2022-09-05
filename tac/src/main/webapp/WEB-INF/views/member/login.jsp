<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<head>
			<!-- anti-flicker snippet (recommended)  -->
			<style>.async-hide { opacity: 0 !important} </style>
			<script>(function(a,s,y,n,c,h,i,d,e){s.className+=' '+y;h.start=1*new Date;
			h.end=i=function(){s.className=s.className.replace(RegExp(' ?'+y),'')};
			(a[n]=a[n]||[]).hide=h;setTimeout(function(){i();h.end=null},c);h.timeout=c;
			})(window,document.documentElement,'async-hide','dataLayer',100,
			{'CONTAINER_ID':true});</script>
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
			<!-- <link rel="stylesheet" href="/resources/css/common/common.css" /> -->
			<link rel="stylesheet" href="/resources/css/member/before/login.css" />
			<link rel="stylesheet" href="/resources/css/header.css" />
		</head>

		<body>
			<jsp:include page="/resources/component/header.jsp"></jsp:include>
			<div id="loginbox" class="wrapper bg-white">
				<img id="logintitleimg" src="../../../resources/image/logo/logo5.png">
				<div id="logintitletext" class="h4 text-muted text-center pt-2">다른 카드를 체험하고 당신의 지출을 분석하세요</div>
				<form class="pt-3" method="post" name="FormLogin" action="/login_result">
					<div class="form-group py-2">
						<div class="input-field"> <span class="far fa-user p-2"></span> <input type="text" name="id"
								placeholder="ID" required class=""> </div>
					</div>
					<div class="form-group py-1 pb-2">
						<div class="input-field"> <span class="fas fa-lock p-2"></span> <input type="password"
								name="password" placeholder="PASSWORD" required class="">
						</div>
					</div>
					<button class="btn btn-block text-center my-3 regibtn" type="submit">로그인</button>
					<span style="margin-left: 2rem"></span>
					<button id="singupbtn"  class="btn btn-block text-center my-3 regibtn" onclick="goRegister()">회원가입</button>
				</form>
			</div>
			<!-- <div id="load">
	    		<img src="/resources/image/test/loading.gif" alt="loading">
			</div>
			<script src="/resources/js/common.js"></script> -->
		</body>
		<script>
			function goRegister() {
				location.href = '/signup';
			}

		</script>

		</html>