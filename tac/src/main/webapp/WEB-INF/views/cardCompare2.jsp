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

<link rel="stylesheet" href="./resources/css/compareDetail.css" />

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
    const red = "rgb(255, 99, 132)";
    const color = Chart.helpers.color;
    const config = {
      type: 'radar',
      data: {
        labels: [['Eating', 'Dinner'], ['Drinking', 'Water'], 'Sleeping', ['Designing', 'Graphics'], 'Coding', 'Cycling', 'Running'],
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
            78,
            97,
            55
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
<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
	<div class="container-fluid">
		<a class="navbar-brand" href="/main"><img
				id="logo" class="tac" src="/resources/image/logo1.png" /><img id="logo"
				src="/resources/image/logo3.gif" /></a>
			<button aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation" class="navbar-toggler"
				data-bs-target="#navbarSupportedContent" data-bs-toggle="collapse"
				type="button">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
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
<body>
 <div class="container">
 	<div class="row justify-content-around">
 		<div class="col-md-4">
 			<div class="cardDetail">
 				<div id="cardName">2030 언택트 체크카드</div>
 				<img src="resources/image/card/card_horizon01.jpg">
 			</div>
 			
 			<div class="cardDetail">
 				<p><b>선택한 카드</b></p>
 				<p>어쩌고</p>
 				<p>어쩌고</p>
 				<p>어쩌고</p>
 				<p>어쩌고</p>
 				<p>어쩌고</p>
 			</div>
 		</div> <!-- columns -->
 		
 		<div class="col-md-4">
 			<div class="cardDetail">
 				<canvas id="chart" width="300px" height="300px"></canvas><br><br>
 			</div>
 			
 			<div class="cardDetail">
 				<p><b>✈</b>여행</p>
 				<p><b>⛽</b>주유</p>
 				<p><b>🍽</b>외식</p>
 				<p><b>🎞</b>영화</p>
 				<p><b>🛍</b>쇼핑</p>
 			</div>
 		</div> <!-- column -->
 		
 		<div class="col-md-4">
 			<div class="cardDetail">
	 			<div id="cardName">BNK 프렌즈 체크카드</div>
 				<img src="resources/image/card/card_horizon02.jpg">
 			</div>
 			
 			<div class="cardDetail">
 				<p><b>내 카드</b></p>
 				<p>저쩌고</p>
 				<p>저쩌고</p>
 				<p>저쩌고</p>
 				<p>저쩌고</p>
 				<p>저쩌고</p>
 				<p>저쩌고</p>
 			</div>
 		
 		
 		</div>
 	</div>
 </div>
</body>

</html>