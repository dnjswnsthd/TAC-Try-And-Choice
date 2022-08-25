<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet" />

<link rel="stylesheet" href="./resources/css/compare.css" />

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css" integrity="sha256-mmgLkCYLUQbXn0B1SRqzHar6dCnv9oZFPEC1g1cwlkk=" crossorigin="anonymous" />
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<!------ Include the above in your HEAD tag ---------->
<title>카드 상세보기</title>
</head>

<body>
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

<div class="container">
    <div class="row justify-content-around">
        <div class="col-md-5">
        	<div class="project-info-box">
        		<p><b>카카오페이 체크카드</b></p>
        		<img src="resources/image/card/card5.jpg" alt="project-image" class="rounded"><br><br>
        		<button class="othercard"><span>다른 카드 보기</span></button>
			</div>
            <div class="project-info-box">
                <p><b>🛍</b> 쇼핑 할인</p>
                <p><b>💊</b> 의료비 할인</p>
                <p><b>⛽</b> 주유비 할인</p>
                <p><b>🎞</b> 영화 할인</p>
                
            </div><!-- / project-info-box -->

           
        </div><!-- / column -->
        
        <div class="col-md-6">
            <div class="project-info-box">
	            <h5>카테고리별 혜택</h5>
	            <button class="myCard"><span>내 카드와 비교</span></button><br><br>
	            <canvas id="myChart" width="350px" height="350px"></canvas>
				<script>
				const ctx = document.getElementById('myChart');
				const myChart = new Chart(ctx, {
				    type: 'doughnut',
				    data: {
				        labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
				        datasets: [{
				            label: '# of Votes',
				            data: [12, 19, 3, 5, 2, 3],
				            backgroundColor: [
				                'rgba(255, 99, 132, 0.2)',
				                'rgba(54, 162, 235, 0.2)',
				                'rgba(255, 206, 86, 0.2)',
				                'rgba(75, 192, 192, 0.2)',
				                'rgba(153, 102, 255, 0.2)',
				                'rgba(255, 159, 64, 0.2)'
				            ],
				            borderColor: [
				                'rgba(255, 99, 132, 1)',
				                'rgba(54, 162, 235, 1)',
				                'rgba(255, 206, 86, 1)',
				                'rgba(75, 192, 192, 1)',
				                'rgba(153, 102, 255, 1)',
				                'rgba(255, 159, 64, 1)'
				            ],
				            borderWidth: 1
				        }]
				    },
				    options: {
				    	responsive: false,
				        scales: {
				            y: {
				                beginAtZero: true
				            }
				        }
				    }
				});
				</script>
				
			</div>
			
            <div class="project-info-box">
                <p>소비 내역</p>
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
            </div><!-- / project-info-box -->
        </div><!-- / column -->
    </div><!-- /row  -->
</div>
</body>