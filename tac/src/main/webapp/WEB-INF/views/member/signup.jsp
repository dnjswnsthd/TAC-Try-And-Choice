<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>회원 가입</title>
<!-- Mobile Specific Metas -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<!-- Font-->
<link rel="stylesheet" type="text/css"
	href="/resources/fonts/material-design-iconic-font/css/material-design-iconic-font.min.css" />
<!-- Main Style Css -->
<link rel="stylesheet" href="/resources/css/signup.css" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function() {
		var cardId = '';
		 $('#selectCard').on('click', function(e){
			 e.stopPropagation();
			 alert($(this).attr(name));
			 cardId = $(this).attr(name);
		 });
	});
</script>
</head>
<body>
	<jsp:include page="/resources/component/header.jsp"></jsp:include>
	<!-- <iframe id="headerFrame" src="/resources/component/header.html" frameborder="0"></iframe> -->
	<div class="page-content">
		<div class="form-v1-content">
			<div class="wizard-form">
				<form class="form-register" action="#" method="post">
					<div id="form-total">
						<!-- SECTION 1 -->
						<h2>
							<p class="step-icon">
								<span>01</span>
							</p>
							<span class="step-text">개인 정보 등록</span>
						</h2>
						<section>
							<div class="inner">
								<div class="wizard-header">
									<h3 class="heading">개인 정보 등록</h3>
									<p>개인 정보를 모두 입력한 뒤 다음단계로 넘어가주세요!</p>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-4">
										<fieldset>
											<legend>Name</legend>
											<input type="text" class="form-control" id="name" name="name"
												placeholder="홍길동" required />
										</fieldset>
									</div>
									<div class="form-holder form-holder-4">
										<fieldset>
											<legend>성별</legend>
											<select name="gender" id="gender">
												<option value="male">남성</option>
												<option value="female">여성</option>
											</select>
										</fieldset>
									</div>
									<div class="form-holder form-holder-4">
										<fieldset>
											<legend>나이</legend>
											<input type="number" id="age" name="age" min="1" placeholder="78">
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Your Email</legend>
											<input type="text" name="your_email" id="your_email"
												class="form-control" pattern="[^@]+@[^@]+.[a-zA-Z]{2,6}"
												placeholder="example@email.com" required />
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Password</legend>
											<input type="password" name="password" id="password"
												class="form-control" placeholder="특수문자 포함 8자리 이상..."
												required />
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Password Check</legend>
											<input type="password" name="passwordChk" id="passwordChk"
												class="form-control" placeholder="다시 한번 입력해주세요." required />
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Phone Number</legend>
											<input type="text" class="form-control" id="phone"
												name="phone" placeholder="010-1234-5678" required />
										</fieldset>
									</div>
								</div>

								<!-- <div class="form-row">
									<div class="form-holder form-holder-2">
										<input type="date" class="form-control input-border"
											id="birth" name="birth" value="1996-04-15" required />
									</div>
								</div> -->
							</div>
						</section>

						<!-- section2 -->
						<h2>
							<p class="step-icon">
								<span>02</span>
							</p>
							<span class="step-text">카드 정보 등록</span>
						</h2>
						<section>
							<div class="inner">
								<div class="wizard-header">
									<h3 class="heading">카드 정보 등록</h3>
									<p>현재 사용중인 카드를 입력해주세요.(선택 사항)</p>
								</div>
								<div class="form-row">
									<div id="carouselExampleIndicators" class="carousel slide"
										data-ride="carousel" data-interval="false">
										<span><h2>카드 체험</h2>
											<h2 id="dot">.</h2></span>
										<div class="d-flex" id="moveBtn1">
											<a href="#carouselExampleIndicators" role="button"
												data-slide="prev">
												<div class="carousel-nav-icon">
													<svg xmlns="http://www.w3.org/2000/svg"
														viewBox="0 0 129 129"
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
														<div class="element-card" id="${card.cardId}">
															<div class="front-facing">
																<img id="cardImg"
																	src="/resources/image/card/${card.cardImg}" />
															</div>
															<div class="back-facing">
																<h4>Name : ${card.cardName}</h4>
																<h5>카드 설명 : ${card.cardDesc}</h5>
																<p>
																	<input type="button" class="btn" id="selectCard" value="내 카드 선택" name="${card.cardId}"/>
																</p>
															</div>
														</div>
													</c:forEach>
												</div>
											</div>
											<c:forEach var="i" begin="4" step="4"
												end="${list.size() - 1}">
												<div class="carousel-item">
													<div class="container">
														<c:forEach var="card" items="${list}" begin="${i}"
															end="${i+3}">
															<div class="element-card">
																<div class="front-facing">
																	<img id="cardImg"
																		src="/resources/image/card/${card.cardImg}" />
																</div>
																<div class="back-facing">
																	<h4>Name : ${card.cardName}</h4>
																	<h5>카드 설명 : ${card.cardDesc}</h5>
																	<p>
																		<a class="btn"
																			href="https://en.wikipedia.org/wiki/Copper"
																			target="_blank">내 카드 선택</a>
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
													<svg xmlns="http://www.w3.org/2000/svg"
														viewBox="0 0 129 129"
														xmlns:xlink="http://www.w3.org/1999/xlink">
               											<path
															d="m40.4,121.3c-0.8,0.8-1.8,1.2-2.9,1.2s-2.1-0.4-2.9-1.2c-1.6-1.6-1.6-4.2 0-5.8l51-51-51-51c-1.6-1.6-1.6-4.2 0-5.8 1.6-1.6 4.2-1.6 5.8,0l53.9,53.9c1.6,1.6 1.6,4.2 0,5.8l-53.9,53.9z" />
            										</svg>
												</div>
											</a>
										</div>

									</div>
								</div>
							</div>
						</section>

						<!-- SECTION 3 -->
						<h2>
							<p class="step-icon">
								<span>03</span>
							</p>
							<span class="step-text">소비 정보로 이동</span>
						</h2>
						<section>
							<div class="inner">
								<div class="wizard-header">
									<h3 class="heading">회원 가입 완료</h3>
									<p>마지막으로 소비정보를 입력할 수 있습니다.</p>
									<p>바쁘셔서 시간이 없으시다면 다음에 마이페이지에서 추가해주세요</p>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<a href="/inputConsume">소비 정보 입력</a> <a href="#">로그인 </a>
									</div>
								</div>
							</div>
						</section>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="/resources/js/jquery-3.3.1.min.js"></script>
	<script src="/resources/js/jquery.steps.js"></script>
	<script src="/resources/js/main.js"></script>
	<script src="/resources/js/card.js" rel="text/javascript"></script>
</body>
</html>