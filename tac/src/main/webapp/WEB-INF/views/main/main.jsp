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
<link rel="stylesheet" href="/resources/css/main/main.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/resources/js/card.js" rel="text/javascript"></script>
</head>
<body>
	<div class="topSection">
		<jsp:include page="/resources/component/header.jsp"></jsp:include>
		<div class="maintext">
			<h2><b>Puzzle 맞추듯</b></h2>
			<h2><b>카드를 나에게</b></h2>
			<h2><b>'TAC' 맞추다</b></h2>
			<!-- <div class="mainButton">
				<button id="moveBtn" type="button" class="btn btn-dark">회원가입</button>
				<button id="moveBtn" type="button" class="btn btn-dark">로그인</button>
			</div> -->
		</div>


		<div id="carouselExampleIndicators" class="carousel slide"
			data-ride="carousel" data-interval="false">
			<span><h2 id="cardText">카드 체험</h2>
				<h2 id="dot">.</h2></span>
			<div class="d-flex" id="moveBtn1">
				<a href="#carouselExampleIndicators" role="button" data-slide="prev">
					<div class="carousel-nav-icon">
						<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 129 129"
							xmlns:xlink="http://www.w3.org/1999/xlink">
                  <path
								d="m88.6,121.3c0.8,0.8 1.8,1.2 2.9,1.2s2.1-0.4 2.9-1.2c1.6-1.6 1.6-4.2 0-5.8l-51-51 51-51c1.6-1.6 1.6-4.2 0-5.8s-4.2-1.6-5.8,0l-54,53.9c-1.6,1.6-1.6,4.2 0,5.8l54,53.9z" />
               </svg>
					</div>
				</a>
			</div>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<div class="container">
						<c:forEach var="card" items="${list}" begin="0" end="3">
							<div class="element-card">
								<div class="front-facing">
									<img id="cardImg" src="/resources/image/card/${card.cardImg}" />
								</div>
								<div class="back-facing">
									<h4>${card.cardName}</h4>
									<h5>${card.cardDesc}</h5>
									<p>
										<input type="button" class="btn" onclick="location.href='/compare?cardId=${card.cardId}'"
											 value="카드 선택">
									</p>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
				<c:forEach var="i" begin="4" step="4" end="${list.size() - 1}">
					<div class="carousel-item">
						<div class="container">
							<c:forEach var="card" items="${list}" begin="${i}" end="${i+3}">
								<div class="element-card">
									<div class="front-facing">
										<img id="cardImg" src="/resources/image/card/${card.cardImg}" />
									</div>
									<div class="back-facing">
										<h4>${card.cardName}</h4>
										<h5>
											${card.cardDesc}
										</h5>
										<p>
											<input type="button" class="btn" onclick="location.href='/compare?cardId=${card.cardId}'"
											 value="카드 선택">
										</p>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="d-flex" id="moveBtn2">
				<a href="#carouselExampleIndicators" data-slide="next">
					<div class="carousel-nav-icon">
						<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 129 129"
							xmlns:xlink="http://www.w3.org/1999/xlink">
               <path
								d="m40.4,121.3c-0.8,0.8-1.8,1.2-2.9,1.2s-2.1-0.4-2.9-1.2c-1.6-1.6-1.6-4.2 0-5.8l51-51-51-51c-1.6-1.6-1.6-4.2 0-5.8 1.6-1.6 4.2-1.6 5.8,0l53.9,53.9c1.6,1.6 1.6,4.2 0,5.8l-53.9,53.9z" />
            </svg>
					</div>
				</a>
			</div>
		</div>
	</div>
	<br><br>
</body>
</html>