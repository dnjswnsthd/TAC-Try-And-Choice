<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>소비패턴 분석 상세</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<!-- Font-->
<link rel="stylesheet" type="text/css"
	href="/resources/fonts/material-design-iconic-font/css/material-design-iconic-font.min.css" />
<!-- Main Style Css -->
<link rel="stylesheet" href="/resources/css/analysis.css" />

<!-- 부트스트랩 -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- 차트.js  -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.9.1/chart.min.js"
	integrity="sha512-ElRFoEQdI5Ht6kZvyzXhYG9NqjtkmlkfYk0wr6wHxU9JEHakS7UJZNeml5ALk+8IKlU6jDgMabC3vkumRokgJA=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
	<jsp:include page="/resources/component/header.jsp"></jsp:include>

	<div class="page-content">
		<div class="container py-3">
			<header>

				<div class="pricing-header p-3 pb-md-4 mx-auto text-center">
					<h1 class="display-4 fw-normal">소비 패턴 분석 결과 상세 페이지</h1>
					<p class="fs-5 text-muted">배우에는 최화정 고양시에는 화정역 BNK-DIT에는 이화정이
						있다.</p>
				</div>
			</header>

			<main>
			<div class="row row-cols-1 row-cols-md-2 mb-3 text-center">
				<div class="col">
					<div class="card mb-4 rounded-3 shadow-sm">
						<div class="card-header py-3">
							<h4 class="my-0 fw-normal">소비 유형별 분석</h4>
						</div>
						<div class="card-body">
							<canvas id="myChart"></canvas>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="card mb-4 rounded-3 shadow-sm">
						<div class="card-header py-3">
							<h4 class="my-0 fw-normal">일별 분석</h4>
						</div>
						<div class="card-body">
							<canvas id="myChart2"></canvas>
						</div>
					</div>
				</div>
			</div>
			</main>
		</div>

	</div>

	

	<script>
        const labels2 = [
            'January',
            'February',
            'March',
            'April',
            'May',
            'June',
        ];

        const data2 = {
            labels: labels2,
            datasets: [{
                label: 'My First dataset',
                backgroundColor: 'rgb(255, 99, 132)',
                borderColor: 'rgb(255, 99, 132)',
                data: [0, 10, 5, 2, 20, 30, 45],
            }]
        };

        const config2 = {
            type: 'line',
            data: data2,
            options: {}
        };

        // PIE
        const data = {
            labels: [
                'Red',
                'Blue',
                'Yellow'
            ],
            datasets: [{
                label: 'My First Dataset',
                data: [300, 50, 100],
                backgroundColor: [
                    'rgb(255, 99, 132)',
                    'rgb(54, 162, 235)',
                    'rgb(255, 205, 86)'
                ],
                hoverOffset: 4
            }]
        };

        const config = {
            type: 'pie',
            data: data,
        };

        const myChart2 = new Chart(
            document.getElementById('myChart2'),
            config2
        );

        // const myChart = new Chart(
        //     document.getElementById('myChart'),
        //     config
        // );

        new Chart(document.getElementById('myChart'),config);

    </script>
	<script src="/resources/js/jquery-3.3.1.min.js"></script>
	<script src="/resources/js/jquery.steps.js"></script>
	<script src="/resources/js/main.js"></script>
</body>
</html>
