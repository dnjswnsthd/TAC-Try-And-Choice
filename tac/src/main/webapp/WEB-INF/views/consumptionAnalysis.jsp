<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>소비패턴 분석</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<!-- Font-->
<link rel="stylesheet" type="text/css"
	href="/resources/fonts/material-design-iconic-font/css/material-design-iconic-font.min.css" />
<!-- Main Style Css -->
<link rel="stylesheet" href="/resources/css/analysis.css" />

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.9.1/chart.min.js"
	integrity="sha512-ElRFoEQdI5Ht6kZvyzXhYG9NqjtkmlkfYk0wr6wHxU9JEHakS7UJZNeml5ALk+8IKlU6jDgMabC3vkumRokgJA=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
	<jsp:include page="/resources/component/header.jsp"></jsp:include>

	<div class="page-content">
		<button id="test" type="button" class="btn">Basic</button>
		<div class="container py-3">
			<header>
				<div class="pricing-header p-3 pb-md-4 mx-auto text-center">
					<h1 id="analysisTitle" class="display-4 fw-normal">이화정님의 소비 패턴
						분석 결과</h1>
					<p class="fs-5 text-muted">배우에는 최화정 고양시에는 화정역 BNK-DIT에는 이화정이
						있다.</p>
				</div>
			</header>

			<main>
			<div class="row row-cols-1 row-cols-md-2 mb-3 text-center">
				<div class="col">
					<div class="card mb-4 rounded-3 shadow-sm">
						<div id="myChartHead" class="card-header py-3"
							data-bs-toggle="modal" data-bs-target="#myModal">
							<h4 class="my-0 fw-normal myChartHeadFont">소비 유형별 분석</h4>
						</div>
						<div class="card-body">
							<canvas id="myChart" height="400px" width="400px"></canvas>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="card mb-4 rounded-3 shadow-sm">
						<div id="myChartHead2" class="card-header py-3"
							data-bs-toggle="modal" data-bs-target="#myModal2">
							<h4 class="my-0 fw-normal myChartHeadFont">일별 분석</h4>
						</div>
						<div class="card-body">
							<canvas id="myChart2" height="400px" width="400px"></canvas>
						</div>
					</div>
				</div>

			</div>


			</main>


		</div>


	</div>

	<!-- The TYPE CHART Modal -->
	<div class="modal fade" id="myModal">
		<div class="modal-dialog modal-dialog-centered modal-xl">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">소비 유형별 상세 분석</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<div class="container-fluid">
						<div class="row">
							<div class="col-6 modalchart">
								<canvas id="modal_myChart1" width="280px" height="280px"></canvas>
							</div>
							<div class="col-6 modalchart">
								<canvas id="modal_myChart2" width="280px" height="280px"></canvas>
							</div>
						</div>
						<div class="row">
							<div class="col-6 modalchartTitle">이화정님의 소비</div>
							<div class="col-6 modalchartTitle">평균 소비</div>
						</div>
						<div class="row">
							<div id="TypeAnalysisModalTitle" class="col-12">
								이화정님의 소비 패턴은 <b id="MyTypeTitle">먹는데 아끼지 않음</b> 입니다
							</div>
							<div class="typetitleline"></div>
						</div>
						<div class="row">
							<div class="col-12">
								<uL>
									<li>이화정님은 나이와 소득이 비슷한 다른 사용자 보다 <b class="emphasize">식비</b>(이)가
										높습니다.
									</li>
									<li>이화정님은 나이와 소득이 비슷한 다른 사용자 보다 <b class="emphasize">교통비</b>(이)가
										높습니다.
									</li>
									<li>이화정님은 나이와 소득이 비슷한 다른사용자 보다 <b class="emphasize">쇼핑</b>(이)가
										낮습니다.
									</li>
									<li>이화정님은 <b class="emphasize">커피</b>에 가장 할인을 많이 받으셨습니다.
									</li>
									<li>이화정님은 <b class="emphasize">공과금</b>에 많은 지출을 하셨습니다.
									</li>
								</uL>
							</div>
						</div>
					</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger"
						data-bs-dismiss="modal">닫기</button>
				</div>

			</div>
		</div>
	</div>

	<!-- The LINE CHART Modal -->
	<div class="modal fade" id="myModal2">
		<div class="modal-dialog modal-dialog-centered modal-xl">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">일별 상세 분석</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<div class="container-fluid">
						<div class="row">
							<div class="col-6 modalchart">
								<canvas id="modal_myChart3" width="280px" height="280px"></canvas>
							</div>
							<div class="col-6 modalchart">
								<canvas id="modal_myChart4" width="280px" height="280px"></canvas>
							</div>
						</div>
						<div class="row">
							<div class="col-6 modalchartTitle">이화정님의 소비</div>
							<div class="col-6 modalchartTitle">평균 소비</div>
						</div>
						<div class="row">
							<div id="TypeAnalysisModalTitle" class="col-12">
								이화정님은 <b id="MyTypeTitle">돈이 들어오면 쓰는</b> 타입 입니다
							</div>
							<div class="typetitleline"></div>
						</div>
						<div class="row">
							<div class="col-12">
								<uL>
									<li>이화정님은 나이와 소득이 비슷한 다른 사용자 보다 <b class="emphasize">식비</b>(이)가
										높습니다.
									</li>
									<li>이화정님은 나이와 소득이 비슷한 다른 사용자 보다 <b class="emphasize">교통비</b>(이)가
										높습니다.
									</li>
									<li>이화정님은 나이와 소득이 비슷한 다른사용자 보다 <b class="emphasize">쇼핑</b>(이)가
										낮습니다.
									</li>
									<li>이화정님은 <b class="emphasize">커피</b>에 가장 할인을 많이 받으셨습니다.
									</li>
									<li>이화정님은 <b class="emphasize">공과금</b>에 많은 지출을 하셨습니다.
									</li>
								</uL>
							</div>
						</div>
					</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger"
						data-bs-dismiss="modal">닫기</button>
				</div>

			</div>
		</div>
	</div>
	<div></div>

	<script>
		var AnalyseJSON = JSON.parse('${Object}');
		console.log(AnalyseJSON);
		
		// pie data
//		console.log(AnalyseJSON[0]);
		var mypieLabel = [];
		var mypieData = []; 
		for( element in AnalyseJSON[0] ){
			var temp = AnalyseJSON[0][element].split(",");
//			console.log(element + "   " + temp[0] + " " + temp[1]);
			mypieLabel.push(element);
			mypieData.push(temp[1]); 
		}
        // PIE
        const ChartbyType_data = {
            labels: mypieLabel,
            datasets: [{
                label: 'My First Dataset',
                data: mypieData,
                backgroundColor: [
                    '#ea9999', '#741b47', '#6aa84f', '#f9cb9c','#45818e',
                    '#8e7cc3', '#c90076', '#5b5b5b', '#0b5394','#f9cb9c',
                    '#210E9E', '#E30000', '#FF00F2', '#00098A','#00F2FF',
                    '#00FF88', '#CCFF00', '#752778', '#FFAE00','#292929',
                    '#FFD6EF', '#592424'
                ],
                hoverOffset: 4
            }]
        };

        const ChartbyType_config = {
            type: 'pie',
            data: ChartbyType_data,
            options: {
                responsive: false,
				plugins: {
					legend: {
						display: true,
						position : 'bottom',
					}
				}
            }
        };
        const myChart = new Chart(document.getElementById('myChart'), ChartbyType_config);
        // end PIE 

		// mylineChart start
		var mylineMap = new Map();
		for( element in AnalyseJSON[2] ) {
			var key = element.substring(2,4);
			if ( mylineMap.has(key) ) {
				mylineMap.set(key, mylineMap.get(key) + AnalyseJSON[2][element]);
			} else {
				mylineMap.set(key, AnalyseJSON[2][element]);
			}
		}

		var mylineLabel = [];
		var mylineData = [];
		for(var i = 1; i <= 31; i++){
			var key = "";
			if ( i < 10 ){
				key = "0" + i;
			}  else {
				key = i + "";
			}
			mylineLabel.push(key);
			if ( mylineMap.has(key) ) {
				mylineData.push(mylineMap.get(key));
			} else {
				mylineData.push(0);
			}
		}

        // my line chart
        const LineChart_data = {
            labels: mylineLabel,
            datasets: [{
                label: 'My First dataset',
                backgroundColor: 'rgb(255, 99, 132)',
                borderColor: 'rgb(255, 99, 132)',
                data: mylineData,
            }]
        };

        const LineChart_config = {
            type: 'line',
            data: LineChart_data,
            options: {
                responsive: false,
				plugins: {
					legend: {
						display: false,
						labels: {
							color: 'rgb(255, 99, 132)'
						}
					}
				}
            }
        };

        const myChart2 = new Chart(document.getElementById('myChart2'), LineChart_config);
        // line chart

        // modal chart 1
        const modal_chart_1_config = {
            type: 'pie',
            data: ChartbyType_data,
            options: {
                responsive: false
            }
        };
        const modal_myChart1 = new Chart(document.getElementById('modal_myChart1'), modal_chart_1_config);
        // end 

        // modal chart 2
        const ChartbyType_2_data = {
            labels: [
                'Black',
                'Green',
                'Yellow'
            ],
            datasets: [{
                label: 'My First Dataset',
                data: [60, 50, 200],
                backgroundColor: [
                    'rgb(0,0,0)',
                    'rgb(133,0,15)',
                    'rgb(255, 205, 86)'
                ],
                hoverOffset: 4
            }]
        };
        const modal_chart_2_config = { 
            type: 'pie',
            data: ChartbyType_2_data,
            options: {
                responsive: false
            }
        };
        const modal_myChart2 = new Chart(document.getElementById('modal_myChart2'), modal_chart_2_config);
        // end 
        
         // modal chart 3
        const modal_chart_3_config = {
	        type: 'line',
	        data: LineChart_data,
	        options: {
	            responsive: false
	        }
        };
        const modal_myChart3 = new Chart(document.getElementById('modal_myChart3'), modal_chart_3_config);
        // end
        
        // modal chart 4
        const LineChart_aval_data = {
            labels: [
                'January',
                'February',
                'March',
                'April',
                'May',
                'June',
            ],
            datasets: [{
                label: 'My First dataset',
                backgroundColor: 'rgb(255, 99, 132)',
                borderColor: 'rgb(255, 99, 132)',
                data: [10, 8, 0, 0, 4, 15, 18],
            }]
        };

        const LineChart_aval_config = {
            type: 'line',
            data: LineChart_aval_data,
            options: {
                responsive: false
            }
        };
        const myChart4 = new Chart(document.getElementById('modal_myChart4'), LineChart_aval_config);
        // end
        
        document.getElementById('myChartHead').addEventListener('click', event => {
            // alert("INVU");
        });

        document.getElementById('myChartHead2').addEventListener('click', event => {
            // alert("INVU2");
        });

        // 데이터 받아오기 테스트  
        document.getElementById('test').addEventListener('click', event => {
            //
            
        });
    </script>
	<script src="/resources/js/jquery-3.3.1.min.js"></script>
	<script src="/resources/js/jquery.steps.js"></script>
	<script src="/resources/js/main.js"></script>
</body>
</html>
