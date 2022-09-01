<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>카드비교상세</title>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>	
<link rel="stylesheet" href="./resources/css/compareDetail.css" />
<link rel="stylesheet" href="/resources/css/header.css" />

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css" integrity="sha256-mmgLkCYLUQbXn0B1SRqzHar6dCnv9oZFPEC1g1cwlkk=" crossorigin="anonymous" />
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

  <!-- =======================================================
  * Template Name: Tempo - v4.8.0
  * Template URL: https://bootstrapmade.com/tempo-free-onepage-bootstrap-theme/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
<script>
    const red = "rgba(255, 99, 132, 0.4)";
    const blue="rgba(54, 162, 235, 0.4)";
    const color = Chart.helpers.color;
    const config = {
      type: 'radar',
      data: {
        labels: ['여행','주유','외식','영화','쇼핑'],
        datasets: [{
          label: 'My dataset',
          backgroundColor: color(red).alpha(0.2).rgbString(),
          borderColor: red,
          pointBackgroundColor: red,
          data: [
            80,
            90,
            60,
            65,
            78
          ]
        }, 
        {
            label: 'card dataset',
            backgroundColor: color(blue).alpha(0.2).rgbString(),
            borderColor: blue,
            pointBackgroundColor: blue,
            data: [
              70,
              50,
              100,
              50,
              80
            ]
          }]
      },
      options: {
        responsive: false,
        scales: { // <-- Note change in options from scale to scales
            r: {
              grid: {
                 circular: true
              },
              beginAtZero: true
            }
        }
      }
    };
    
    window.onload = function () {
    window.myRadar = new Chart(document.getElementById('chart'), config);
    };
</script>

</head>

<body>
	<nav>
		<jsp:include page="/resources/component/header.jsp"></jsp:include>
	</nav>
	
	 <div class="container">
	 	<div class="row justify-content-around">
	 		<div class="col-md-4">
	 			<div class="cardDetail">
	 				<div id="cardName">2030 언택트 체크카드</div>
	 				<img class="cardImg" src="resources/image/card/card_horizon01.jpg">
	 			</div>
	 			
	 			<div class="cardDetail">
	 				<p id="myCardColor"><b>내 카드</b></p>
	 				<div>주유비 <span> 500원 할인</span></div><hr>
	 				<div>베이커리 <span> 500원 할인</span></div><hr>
	 				<div>카페 <span> 500원 할인</span></div><hr>
	 				<div>이동통신요금 <span> 3500원 할인</span></div><hr>
	 				<div>놀이공원 <span> 500원 할인</span></div><hr>
	 				<div>교통 <span> 500원 할인</span></div><hr>
	 				
	 			</div>
	 		</div> <!-- columns -->
	 		
	 		<div class="col-md-4">
	 			<div class="cardDetail">
	 				<canvas id="chart" width="330px" height="250px"></canvas><br>
	 			</div>
	 			
	 			<div class="cardDetail">
	 				<h3>BNK 프렌즈 체크카드를 사용하면 </h3>
	 				<h3><span id="cardText">+3150원</span>의 이득을 볼 수 있습니다.</h3>
	 				<hr>
	 				<div id="consumePattern" class="d-flex flex-wrap align-content-start" >
	 					<div class="p-2 border CompareFlex">
		 					<img id="cardImg" src="resources/image/compare/01_FUEL.png" width="50px" /> 
		 					<div class="ULdesc">주유비</div>
		 					<div class="discount ULdesc">+500원</div>
	 					</div>
	 					<div class="p-2 border CompareFlex">
		 					<img id="cardImg" src="resources/image/compare/02_Bakery.png" width="50px" /> 
		 					<div class="ULdesc">베이커리</div>
		 					<div class="discount ULdesc">+350원</div>
	 					</div>
	 					<div class="p-2 border CompareFlex">
		 					<img id="cardImg" src="resources/image/compare/03_Cafe.png" width="50px" /> 
		 					<div class="ULdesc">카페</div>
		 					<div class="discount ULdesc">-200원</div>
	 					</div>
	 					<div class="p-2 border CompareFlex">
		 					<img id="cardImg" src="resources/image/compare/04_Call.png" width="50px" /> 
		 					<div class="ULdesc">이동통신요금</div>
		 					<div class="discount ULdesc">-3000원</div>
	 					</div>
	 					<div class="p-2 border CompareFlex">
		 					<img id="cardImg" src="resources/image/compare/05_Play.png" width="50px" /> 
		 					<div class="ULdesc">놀이공원</div>
		 					<div class="discount ULdesc">+5000원</div>
	 					</div>
	 					<div class="p-2 border CompareFlex">
		 					<img id="cardImg" src="resources/image/compare/06_Traffic.png" width="50px" /> 
		 					<div class="ULdesc">교통</div>
		 					<div class="discount ULdesc">+500원</div>
	 					</div>
	 					<!-- <div class="p-2 border CompareFlex">
		 					<img id="cardImg" src="resources/image/compare/07_HomeShopping.png" width="50px" /> 
		 					<div class="ULdesc">홈쇼핑</div>
		 					<div class="discount ULdesc">-2000원</div>
	 					</div> -->
	 					
	 				<!-- <div>✈&nbsp;&nbsp;여행<div class="discount" id="selectCardColor">+400</div></div><hr>
	 				<div>⛽&nbsp;&nbsp;주유<div class="discount" id="selectCardColor">+1200</div></div><hr>
	 				<div>🍽&nbsp;&nbsp;외식<div class="discount" id="myCardColor">-500</div></div><hr>
	 				<div><b>🎞</b>&nbsp;&nbsp;영화<div class="discount" id="selectCardColor">+320</div></div><hr>
	 				<div>🛍&nbsp;&nbsp;쇼핑<div class="discount" id="myCardColor">-300</div></div><hr>
	 				<div>&nbsp;&nbsp;총<div class="discount" id="selectCardColor">+1120</div></div> -->
	 				</div>
	 			</div>
	 		</div> <!-- column -->
	 		
	 		<div class="col-md-4">
	 			<div class="cardDetail">
		 			<div id="cardName">BNK 프렌즈 체크카드</div>
	 				<img class="cardImg" src="resources/image/card/card_horizon02.jpg">
	 			</div>
	 			
	 			<div class="cardDetail selectCardDetail">
	 				<p id="selectCardColor"><b>비교할 카드</b></p>
	 				<div>주유비 <span> 1000원 할인</span></div><hr>
	 				<div>베이커리 <span> 850원 할인</span></div><hr>
	 				<div>카페 <span> 300원 할인</span></div><hr>
	 				<div>이동통신요금 <span> 500원 할인</span></div><hr>
	 				<div>놀이공원 <span> 5500원 할인</span></div><hr>
	 				<div>교통 <span> 100원 할인</span></div><hr>
	 			</div>
	 		
	 		
	 		</div>
	 	</div>
	 </div>
	 
	 <script>
	 /* 
		$(function() {
		
			$.each( arr, function(index, element){
				$('#consumePattern').append('<div class="p-2 border CompareFlex">' 
										+ '<img id="cardImg" src="resources/image/compare/'+element+'" width="50px" /> <div class="ULdesc">'+element+ '</div>
										);
				
			}
			});
	
			$.each( arr, function(index, element){
				var imgsrc = LCImage.get(element);
				$('#consumePattern').append('<div class="p-2 border CompareFlex">' 
										+ '<img id="cardImg" src="/resources/image/compare/'+imgsrc.substring(1,imgsrc.length)+'" width="50px" /> '
										+ '<div class="ULdesc">' + element + '</div></div>');
			});
	*/
			
	 </script>
</body>

</html>