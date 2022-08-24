<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="./resources/css/compare.css" />

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css" integrity="sha256-mmgLkCYLUQbXn0B1SRqzHar6dCnv9oZFPEC1g1cwlkk=" crossorigin="anonymous" />
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<!------ Include the above in your HEAD tag ---------->
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-md-6">
        	<h5>카테고리별 혜택</h5>
            <canvas id="myChart" width="400" height="350"></canvas>
			<script>
			const ctx = document.getElementById('myChart');
			const myChart = new Chart(ctx, {
			    type: 'line',
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
			        scales: {
			            y: {
			                beginAtZero: true
			            }
			        }
			    }
			});
			</script>

            <div class="project-info-box">
                <p><b>🛍</b> 쇼핑 할인</p>
                <p><b>💊</b> 의료비 할인</p>
                <p><b>⛽</b> 주유비 할인</p>
                <p><b>🎞</b> 영화 할인</p>
                <button class="othercard"><span>다른 카드 보기</span></button>
            </div><!-- / project-info-box -->

           
        </div><!-- / column -->

        <div class="col-md-5">
            <img src="resources/image/card/card5.jpg" alt="project-image" class="rounded">
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
    </div>
</div>
</body>