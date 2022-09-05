<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--divinectorweb.com-->
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>TAC(Try&Choice)</title>
<link rel="icon" href="/resources/image/logo/logo2.png" type="image/x-icon" width="100%"
	sizes="96x96" />
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;700;900&display=swap"
	rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css"
	rel="stylesheet" />

<link href="/resources/css/intro.css" rel="stylesheet" />
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
		<div class="container">
			<a class="navbar-brand" href="/main"><img
				id="logo" class="tac" src="/resources/image/logo/logo2.png" /><img id="logo"
				src="/resources/image/logo/logo3.gif" /></a>
			<button aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation" class="navbar-toggler"
				data-bs-target="#navbarSupportedContent" data-bs-toggle="collapse"
				type="button">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="#">Service1</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Service2</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Service3</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">LOGIN</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/signup">SINGUP</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="carousel slide" data-bs-ride="carousel"
		id="carouselExampleIndicators" data-interval="10000">
		<div class="carousel-indicators">
			<button aria-label="Slide 1" class="active" data-bs-slide-to="0"
				data-bs-target="#carouselExampleIndicators" type="button"></button>
			<button aria-label="Slide 2" data-bs-slide-to="1"
				data-bs-target="#carouselExampleIndicators" type="button"></button>
			<button aria-label="Slide 3" data-bs-slide-to="2"
				data-bs-target="#carouselExampleIndicators" type="button"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active" data-bs-interval="8000">
				<img alt="..." class="d-block w-100"
					src="/resources/image/test/intro_background6.jpg" />
				<div class="carousel-caption">
					<h5 class="animated bounceInRight" style="animation-delay: 1s">
						BnK Card 미리 체험하기</h5>
					<p class="animated bounceInLeft d-none d-md-block"
						style="animation-delay: 2s">
						부산은행의 다양한 상품을 직접 경험해본다면, <br /> 부산은행에 스며들게 될 것입니다.
					</p>
					<p class="animated bounceInRight" style="animation-delay: 3s">
						<a class="link8" href="#">체험 하기</a>
					</p>
					<div class="google-loader animated bounceInLeft"
						style="animation-delay: 4s">
						<span class="loading">부</span> <span class="loading">산</span> <span
							class="loading">은</span> <span class="loading">행</span>
					</div>
				</div>
			</div>
			<div class="carousel-item" data-bs-interval="8000">
				<img alt="..." class="d-block w-100"
					src="/resources/image/test/intro_background7.jpg" />
				<div class="carousel-caption">
					<h5 class="animated bounceInRight" style="animation-delay: 1s">
						BnK Project2</h5>
					<p class="animated bounceInLeft d-none d-md-block"
						style="animation-delay: 2s">스며들었다면, 내껄로 만들어볼까요?
					</p>
					<p class="animated bounceInRight" style="animation-delay: 3s">
						<a href="#">상품 가입</a>
					</p>
					<div class="google-loader animated bounceInLeft"
						style="animation-delay: 4s">
						<span>부</span> <span>산</span> <span>은</span> <span>행</span>
					</div>
				</div>
			</div>
			<div class="carousel-item" data-bs-interval="8000">
				<img alt="..." class="d-block w-100"
					src="/resources/image/test/intro_background8.jpg" />
				<div class="carousel-caption">
					<h5 class="animated bounceInRight" style="animation-delay: 1s">
						BnK Project3</h5>
					<p class="animated bounceInLeft d-none d-md-block"
						style="animation-delay: 2s">직접 방문해 보고 싶으시다고요?</p>
					<p class="animated bounceInRight" style="animation-delay: 3s">
						<a href="#">위치 확인</a>
					</p>
					<div class="google-loader animated bounceInLeft"
						style="animation-delay: 4s">
						<span>부</span> <span>산</span> <span>은</span> <span>행</span>
					</div>
				</div>
			</div>
		</div>
		<button class="carousel-control-prev" data-bs-slide="prev"
			data-bs-target="#carouselExampleIndicators" type="button">
			<span aria-hidden="true" class="carousel-control-prev-icon"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" data-bs-slide="next"
			data-bs-target="#carouselExampleIndicators" type="button">
			<span aria-hidden="true" class="carousel-control-next-icon"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
