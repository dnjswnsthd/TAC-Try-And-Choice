<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet" />

<link rel="stylesheet" href="./resources/css/compare.css" />

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css"
	integrity="sha256-mmgLkCYLUQbXn0B1SRqzHar6dCnv9oZFPEC1g1cwlkk="
	crossorigin="anonymous" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<!------ Include the above in your HEAD tag ---------->
<title>카드 상세보기</title>

</head>

<body>
	<div class="topSection" id="nav">
		<jsp:include page="/resources/component/header.jsp"></jsp:include>
	</div>

	<div class="container-fluid" id="container">
		<div class="row justify-content-around">
			<div class="col-md-6">
				<div class="project-info-box" id="hover">
					<p class="cardName">
						<b>${info.cardName}</b>
					<div class="figure"><img src="resources/image/card/${info.cardImg}"
						alt="${info.cardName}" class="rounded" id="cardImg"></div><br>
					<button class="othercard" onclick="location.href='/main'">
						<span>다른 카드 보기</span>
					</button>
					</p>
					
				</div>
					<div class="project-info-box">
						<c:forEach var="card" items="${list}">
						<ul>
							<li><b>${card.smallCategory.smallCategoryName}</b>&nbsp;&nbsp;
							<c:choose>	
								<c:when test="${card.discountPercent != 0 && card.maxDiscount==0}">
										${card.discountPercent }% 할인
								</c:when>
								<c:when test="${card.discountPercent !=0 && card.maxDiscount != 0}">
									${card.discountPercent } % 할인&nbsp;&nbsp;<b>최대 </b>${card.maxDiscount } 원 할인
								</c:when>
								<c:when test="${card.discountAmount !=0 && card.maxDiscount==0 }">
									${card.discountAmount }원 할인
								</c:when>
								<c:when test="${card.maxDiscountMonth != 0 }"> 
									${card.maxDiscountMonth}원 할인
								</c:when>
								<c:otherwise>
									${card.maxDiscount }원 할인
								</c:otherwise>
							</c:choose>
							</li>	
						</ul>
						</c:forEach>
					</div>
					<!-- / project-info-box -->
				

			</div>
			<!-- / column -->

			<div class="col-md-6">
				<div class="project-info-box">
					<h3>카테고리별 혜택</h3>
					<button class="myCard" onclick="location.href='/cardCompare'">
						<span>내 카드와 비교</span>
					</button>
					<span>${discount5 }</span>
					<br>
					<br>
					<canvas id="myChart" width="400rem" height="400rem"></canvas>
					<script>
						var ctx = document.getElementById('myChart');
						var myChart = new Chart(ctx, {
							type : 'doughnut',
							data : {
								labels : [ '주유', '베이커리','카페','이동통신요금','놀이공원', '교통','홈쇼핑',
									'외식','인터넷쇼핑','오프라인 쇼핑몰','편의점','영화','간편결제',
									'학원', '의료','서적','공과금','온천','호텔','부산 YMCA 시민체육센터',
									'유기농 식품점', '기타'],
								datasets : [ {
									label : '# of Votes',
									data : [ ${discount1}, ${discount2} ,${discount3}, ${discount4}, 
										${discount5}, ${discount6}, ${discount7}, ${discount8},
										${discount9}, ${discount10}, ${discount11}, ${discount12},
										${discount13}, ${discount14}, ${discount15}, ${discount16},
										${discount17}, ${discount18}, ${discount19}, ${discount20},
										${discount21}, ${discount22}],
									backgroundColor : [
											'rgba(255, 99, 132, 0.2)',
											'rgba(54, 162, 235, 0.2)',
											'rgba(255, 206, 86, 0.2)',
											'rgba(75, 192, 192, 0.2)',
											'rgba(153, 102, 255, 0.2)',
											'rgba(255, 159, 64, 0.2)',
											'rgba(85, 73, 148, 0.2)',
											'rgba(246, 117, 168, 0.2)',
											'rgba(242, 147, 147, 0.2)',
											'rgba(177, 255, 255, 0.2)',
											'rgba(245, 240, 187, 0.2)',
											'rgba(115, 169, 173, 0.2)',
											'rgba(196, 223, 170, 0.2)',
											'rgba(244, 224, 109, 0.2)',
											'rgba(247, 167, 108, 0.2)',
											'rgba(236, 114, 114, 0.2)',
											'rgba(150, 187, 124, 0.2)',
											'rgba(24, 77, 71, 0.2)',
											'rgba(237, 187, 77, 0.2)',
											'rgba(127, 188, 210, 0.2)',
											'rgba(0, 215, 255, 0.2)',
											'rgba(88, 0, 255, 0.2)'],
									borderColor : [ 'rgba(255, 99, 132, 1)',
										'rgba(54, 162, 235, 1)',
										'rgba(255, 206, 86, 1)',
										'rgba(75, 192, 192, 1)',
										'rgba(153, 102, 255, 1)',
										'rgba(255, 159, 64, 1)',
										'rgba(85, 73, 148, 1)',
										'rgba(246, 117, 168, 1)',
										'rgba(242, 147, 147, 1)',
										'rgba(177, 255, 255, 1)',
										'rgba(245, 240, 187, 1)',
										'rgba(115, 169, 173, 1)',
										'rgba(196, 223, 170, 1)',
										'rgba(244, 224, 109, 1)',
										'rgba(247, 167, 108, 1)',
										'rgba(236, 114, 114, 1)',
										'rgba(150, 187, 124, 1)',
										'rgba(24, 77, 71, 1)',
										'rgba(237, 187, 77, 1)',
										'rgba(127, 188, 210, 1)',
										'rgba(0, 215, 255, 1)',
										'rgba(88, 0, 255, 1)' ],
									borderWidth : 1
								} ]
							},
							options : {
								responsive : false,
								scales : {
									y : {
										beginAtZero : true
									}
								}
							}
						});
					</script>

				</div>

				<div class="project-info-box">
					<h3>소비 내역</h3>
					<table>
						<thead>
							<tr>
								<th>NO</th>
								<th>사용처</th>
								<th>금 액</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>저쩌고</td>
								<td>어쩌고</td>

							</tr>
						</tbody>
					</table>
				</div>
				<!-- / project-info-box -->
			</div>
			<!-- / column -->
		</div>
		<!-- /row  -->
	</div>
</body>