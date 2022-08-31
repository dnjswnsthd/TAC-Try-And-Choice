<%@page import="com.service.tac.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;700;900&display=swap" rel="stylesheet" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" />
<link href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css" rel="stylesheet" />
<link href="/resources/css/header.css" rel="stylesheet" />
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light" id="header">
		<div class="container">
			<a class="navbar-brand" href="/main"><img id="logo"
				src="/resources/image/logo1.png" /><img id="logo2"
				src="/resources/image/logo3.gif" /></a>
			<button aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation" class="navbar-toggler"
				data-bs-target="#navbarSupportedContent" data-bs-toggle="collapse"
				type="button">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="/compare">CONSUME</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/analysis">ANALYSE</a>
					</li>
					<%
						Member member = (Member) session.getAttribute("member");
						if ( member == null ) {	
					%>
						<li class="nav-item"><a class="nav-link" href="/login">LOGIN</a></li>
						<li class="nav-item"><a class="nav-link" href="/signup">SIGNUP</a></li>
					<%
						} 
						if( member != null && member.getGrade() == 1 ){
					%>
						<li class="nav-item"><a class="nav-link" href="/manage_card">ADDCARD</a></li>
					<%
						}
						if( member != null ){
					%>
						<li class="nav-item"><a class="nav-link" href="/mypage">MYPAGE</a>
						<li class="nav-item"><a class="nav-link" href="/logout">LOGOUT</a></li>
					<%
						}
					%>
					
					
					
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>