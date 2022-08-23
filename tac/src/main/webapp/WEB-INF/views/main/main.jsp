<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="/resources/css/main.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/resources/js/card.js" rel="text/javascript"></script>
</head>
<body>
	<jsp:include page="/resources/component/header.jsp"></jsp:include>
	<hr>
	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel" data-interval="false">
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
					<div class="element-card">
						<div class="front-facing">
							<img id="cardImg" src="/resources/image/card/card1.png" />
						</div>
						<div class="back-facing">
							<h4>카드 이름 : YO카드</h4>
							<h5>
								카드 설명 : Young 한 감각의 소유자들을 위한<br> 혜택을 가득 담은 카드입니다.
							</h5>
							<p>
								<a class="btn" href="https://en.wikipedia.org/wiki/Copper"
									target="_blank">내 카드 선택</a>
							</p>
						</div>
					</div>

					<div class="element-card">
						<div class="front-facing">
							<img id="cardImg" src="/resources/image/card/card2.png" />
						</div>
						<div class="back-facing">
							<h4>카드 이름 : YO카드</h4>
							<h5>
								카드 설명 : Young 한 감각의 소유자들을 위한<br> 혜택을 가득 담은 카드
							</h5>
							<p>
								<a class="btn" href="https://en.wikipedia.org/wiki/Copper"
									target="_blank">내 카드 선택</a>
							</p>
						</div>
					</div>

					<div class="element-card">
						<div class="front-facing">
							<img id="cardImg" src="/resources/image/card/card3.png" />
						</div>
						<div class="back-facing">
							<h4>카드 이름 : YO카드</h4>
							<h5>
								카드 설명 : Young 한 감각의 소유자들을 위한<br> 혜택을 가득 담은 카드
							</h5>
							<p>
								<a class="btn" href="https://en.wikipedia.org/wiki/Copper"
									target="_blank">내 카드 선택</a>
							</p>
						</div>
					</div>

					<div class="element-card">
						<div class="front-facing">
							<img id="cardImg" src="/resources/image/card/card4.png" />
						</div>
						<div class="back-facing">
							<h4>카드 이름 : YO카드</h4>
							<h5>
								카드 설명 : Young 한 감각의 소유자들을 위한<br> 혜택을 가득 담은 카드
							</h5>
							<p>
								<a class="btn" href="https://en.wikipedia.org/wiki/Copper"
									target="_blank">내 카드 선택</a>
							</p>
						</div>
					</div>
				</div>
			</div>
			<div class="carousel-item">
				<div class="container">
					<div class="element-card">
						<div class="front-facing">
							<img id="cardImg" src="/resources/image/card/card1.png" />
						</div>
						<div class="back-facing">
							<h4>카드 이름 : YO카드</h4>
							<h5>
								카드 설명 : Young 한 감각의 소유자들을 위한<br> 혜택을 가득 담은 카드
							</h5>
							<p>
								<a class="btn" href="https://en.wikipedia.org/wiki/Copper"
									target="_blank">내 카드 선택</a>
							</p>
						</div>
					</div>

					<div class="element-card">
						<div class="front-facing">
							<img id="cardImg" src="/resources/image/card/card2.png" />
						</div>
						<div class="back-facing">
							<h4>카드 이름 : YO카드</h4>
							<h5>
								카드 설명 : Young 한 감각의 소유자들을 위한<br> 혜택을 가득 담은 카드
							</h5>
							<p>
								<a class="btn" href="https://en.wikipedia.org/wiki/Copper"
									target="_blank">내 카드 선택</a>
							</p>
						</div>
					</div>

					<div class="element-card">
						<div class="front-facing">
							<img id="cardImg" src="/resources/image/card/card3.png" />
						</div>
						<div class="back-facing">
							<h4>카드 이름 : YO카드</h4>
							<h5>
								카드 설명 : Young 한 감각의 소유자들을 위한<br> 혜택을 가득 담은 카드
							</h5>
							<p>
								<a class="btn" href="https://en.wikipedia.org/wiki/Copper"
									target="_blank">내 카드 선택</a>
							</p>
						</div>
					</div>

					<div class="element-card">
						<div class="front-facing">
							<img id="cardImg" src="/resources/image/card/card4.png" />
						</div>
						<div class="back-facing">
							<h4>카드 이름 : YO카드</h4>
							<h5>
								카드 설명 : Young 한 감각의 소유자들을 위한<br> 혜택을 가득 담은 카드
							</h5>
							<p>
								<a class="btn" href="https://en.wikipedia.org/wiki/Copper"
									target="_blank">내 카드 선택</a>
							</p>
						</div>
					</div>
				</div>
			</div>
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
</body>
</html>