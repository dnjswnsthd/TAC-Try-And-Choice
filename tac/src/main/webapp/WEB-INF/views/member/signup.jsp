<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
									<div class="form-holder">
										<fieldset>
											<legend>Name</legend>
											<input type="text" class="form-control" id="name" name="name"
												placeholder="홍길동" required />
										</fieldset>
									</div>
									<div class="form-holder">
										<fieldset>
											<legend>성별</legend>
											<select name="gender" id="gender">
												<option value="male">남성</option>
												<option value="female">여성</option>
											</select>
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

								<div class="form-row">
									<div class="form-holder form-holder-2">
										<input type="date" class="form-control input-border"
											id="birth" name="birth" value="1996-04-15" required />
									</div>
								</div>
							</div>
						</section>
						<!-- SECTION 2 -->
						<h2>
							<p class="step-icon">
								<span>02</span>
							</p>
							<span class="step-text">소비 정보 등록</span>
						</h2>
						<section>
							<div class="inner">
								<div class="wizard-header">
									<h3 class="heading">소비 정보 등록</h3>
									<p>1달 간의 소비 정보를 등록해 주시면 더욱 완벽한 서비스를 받을 수 있어요~</p>
								</div>
								<div class="form-row">
									<%-- <jsp:include page="/resources/component/fullcalendar.jsp"></jsp:include> --%>
									<iframe id="calendarFrame" src="/resources/component/fullcalendar.jsp"
										frameborder="0"></iframe>
								</div>
							</div>
						</section>
						<!-- section3 -->
						<h2>
							<p class="step-icon">
								<span>03</span>
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
									<div class="form-holder form-holder-2"></div>
								</div>
							</div>
						</section>

						<!-- SECTION 4 -->
						<h2>
							<p class="step-icon">
								<span>04</span>
							</p>
							<span class="step-text">회원 가입 완료</span>
						</h2>
						<section>
							<div class="inner">
								<div class="wizard-header">
									<h3 class="heading">회원 가입 완료</h3>
									<p>마지막으로 추가정보 입력 후 회원 가입을 완료합니다.</p>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<input type="radio" class="radio" name="radio1" id="plan-1"
											value="plan-1" /> <label
											class="plan-icon plan-1-label" for="plan-1"> <img
											src="/resources/image/job/employees.png" alt="pay-1" />
										</label>
										<div class="plan-total">
											<span class="plan-title">직장인</span>
											<p class="plan-text">직장인이거나 주기적인 소득이 있으시면 선택해주세요.</p>
										</div>
										<input type="radio" class="radio" name="radio1" id="plan-2"
											value="plan-2" checked /> <label
											class="plan-icon plan-2-label" for="plan-2"> <img
											src="/resources/image/job/students.png" alt="pay-1" />
										</label>
										<div class="plan-total">
											<span class="plan-title">학생</span>
											<p class="plan-text">초중고등학생, 대학생, 공시생분들 선택해주세요.</p>
										</div>
										<input type="radio" class="radio" name="radio1" id="plan-3"
											value="plan-3" /> <label
											class="plan-icon plan-3-label" for="plan-3"> <img
											src="/resources/image/job/unemployment.png" alt="pay-2" />
										</label>
										<div class="plan-total">
											<span class="plan-title">무직</span>
											<p class="plan-text">현재 행복한 백수 상태이시면 선택해주세요.</p>
										</div>
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
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
