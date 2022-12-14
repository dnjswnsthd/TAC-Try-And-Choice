<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>.async-hide { opacity: 0 !important} </style>
<script>(function(a,s,y,n,c,h,i,d,e){s.className+=' '+y;h.start=1*new Date;
h.end=i=function(){s.className=s.className.replace(RegExp(' ?'+y),'')};
(a[n]=a[n]||[]).hide=h;setTimeout(function(){i();h.end=null},c);h.timeout=c;
})(window,document.documentElement,'async-hide','dataLayer',1000,
{'CONTAINER_ID':true});</script>
<meta charset="utf-8" />
<title>마이페이지</title>
<!-- Mobile Specific Metas -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<!-- Font-->
<link rel="stylesheet" type="text/css"
	href="/resources/fonts/material-design-iconic-font/css/material-design-iconic-font.min.css" />
<!-- Main Style Css -->
<link rel="stylesheet" href="/resources/css/member/after/mypage.css" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
<!-- jQuery library -->
<!-- <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script> -->
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script>
	$(function() {
		$("input[name=" + ${member.cardId} + "]").parent().parent().parent().css('border', '5px solid red');
	});
</script>
</head>
<body>
	<jsp:include page="/resources/component/header.jsp"></jsp:include>
	<!-- <iframe id="headerFrame" src="/resources/component/header.html" frameborder="0"></iframe> -->
	<div class="page-content">
		<div class="form-v1-content">
			<div class="wizard-form">
				<form class="form-register" action="/member/update" method="post">
					<div id="form-total">
						<!-- SECTION 1 -->
						<h2>
							<p class="step-icon">
								<span>01</span>
							</p>
							<span class="step-text">개인 정보 수정</span>
						</h2>
						<section>
							<div class="inner">
								<div class="wizard-header">
									<h3 class="heading">개인 정보 수정</h3>
									<p>내용을 수정하고 패스워드를 입력 후 수정해주세요.</p>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-3">
										<fieldset>
											<legend>Name</legend>
											<input type="text" class="form-control" id="name" name="name"
												value="${member.name}"/>
										</fieldset>
									</div>
									<%-- <div class="form-holder form-holder-4">
										<fieldset>
											<legend>성별</legend>
											<input type="text" class="form-control" id="gender" name="gender"
												value="${member.gender}" readonly />
										</fieldset>
									</div> --%>
									<div class="form-holder form-holder-3">
										<fieldset>
											<legend>나이</legend>
											<input type="number" id="age" name="age" min="1"
												value="${member.age}">
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-3">
										<fieldset>
											<legend>Your Email</legend>
											<input type="text" name="memberId" id="memberId"
												class="form-control"
												value='${member.memberId}' readonly />
										</fieldset>
									</div>
									<div class="form-holder form-holder-3">
										<fieldset>
											<legend>Phone Number</legend>
											<input type="text" class="form-control" id="phone"
												name="phone" value='${member.phone}' />
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-3">
										<fieldset>
											<legend>Password</legend>
											<input type="password" name="password" id="password"
												class="form-control" placeholder="특수문자 포함 8자리 이상..."
												required />
										</fieldset>
										<p id="checkPass" style="margin-left:10px;"></p>
									</div>
									<div class="form-holder form-holder-3">
										<fieldset>
											<legend>Password Check</legend>
											<input type="password" name="passwordChk" id="passwordChk"
												class="form-control" placeholder="다시 한번 입력해주세요." required />
										</fieldset>
										<p id="checkPassCol" style="margin-left:10px;"></p>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2" id="inline">
										<input type="hidden" id="cardId" name="cardId" value="${member.cardId}"/>
										<input type="submit" class="col-sm-6" id="modifyBtn" value="기본 정보 수정"> 
									</div>
								</div>
								<!-- <div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Phone Number</legend>
											<input type="text" class="form-control" id="phone"
												name="phone" placeholder="010-1234-5678" required />
										</fieldset>
									</div>
								</div>
 -->
								<!-- <div class="form-row">
									<div class="form-holder form-holder-2">
										<input type="date" class="form-control input-border"
											id="birth" name="birth" value="1996-04-15" required />
									</div>
								</div> -->
							</div>
						</section>
				</form>
						<!-- section2 -->
						<h2>
							<p class="step-icon">
								<span>02</span>
							</p>
							<span class="step-text">카드 정보 수정</span>
						</h2>
						<section>
							<form class="form-register" action="/member/cardUpdate" method="post">
							<div class="inner">
								<div class="wizard-header">
									<h3 class="heading">카드 정보 수정</h3>
									<p>현재 사용중인 카드를 선택해주세요.</p>
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
														<div class="element-card">
															<div class="front-facing">
																<img id="cardImg"
																	src="/resources/image/card/${card.cardImg}" />
															</div>
															<div class="back-facing">
																<h4>${card.cardName}</h4>
																<h5>${card.cardDesc}</h5>
																<p>
																	<input type="button" class="btn" id="selectCard"
																		value="내 카드 선택" name="${card.cardId}" />
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
																	<h4>${card.cardName}</h4>
																	<h5>${card.cardDesc}</h5>
																	<p>
																		<input type="button" class="btn" id="selectCard"
																			value="내 카드 선택" name="${card.cardId}" />
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
								<div class="form-row">
									<div class="form-holder form-holder-2" id="inline">
										<input type="hidden" id="cardId2" name="cardId2" />
										<input type="hidden" id="memberId" name="memberId" value ="${member.memberId}"/>
										<input type="submit" class="col-sm-6" id="modifyBtn" value="기본 정보 수정">
									</div>
								</div>
						</div>
							</form>
						</section>
					</div>
			</div>
		</div>
	<script src="/resources/js/jquery-3.3.1.min.js"></script>
	<script src="/resources/js/jquery.steps.js"></script>
	<script src="/resources/js/main.js"></script>
	<script src="/resources/js/mypage.js" rel="text/javascript"></script>
</body>
</html>