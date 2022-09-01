<%@page import="com.service.tac.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.9.1/chart.min.js"
	integrity="sha512-ElRFoEQdI5Ht6kZvyzXhYG9NqjtkmlkfYk0wr6wHxU9JEHakS7UJZNeml5ALk+8IKlU6jDgMabC3vkumRokgJA=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<!-- word cloud -->
<script src="https://d3js.org/d3.v3.min.js"></script>
<script src="https://rawgit.com/jasondavies/d3-cloud/master/build/d3.layout.cloud.js" type="text/JavaScript"></script>
<body>
	<jsp:include page="/resources/component/header.jsp"></jsp:include>
	<!-- 세션 체크 -->
	<%
		Member member = (Member) session.getAttribute("member");
		if ( member == null ) {
	%>
	<script> 
		swal({
				title: "로그인이 필요한 서비스 입니다!",
				icon: "error",
			}).then(function(result) {
				console.log(result);
				location.href = '/login';
			});
	</script>
	<%
		}
	%>
	
	<div class="page-content">
		<div class="container py-3">
			<header>
				<div class="pricing-header p-3 pb-md-4 mx-auto text-center">
					<h1 id="analysisTitle" class="display-4 fw-normal"> ${member.name} 님의 소비 패턴
						분석 결과</h1>
					<p class="fs-5 text-muted" id="subtitle"> TAC에서 당신의 카드 소비 내역을 분석하여 알려드립니다 </p>
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
							<canvas id="myChart" height="400px" width="600px"></canvas>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="card mb-4 rounded-3 shadow-sm">
						<div id="myChartHead2" class="card-header py-3"
							data-bs-toggle="modal" data-bs-target="#myModal2">
							<h4 class="my-0 fw-normal myChartHeadFont" onclick="addChart2()">일별 분석</h4>
						</div>
						<div class="card-body">
							<canvas id="myChart2" height="400px" width="600px"></canvas>
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
							<div class="col-6 modalchartTitle">${member.name}님의 소비</div>
							<div class="col-6 modalchartTitle">내 동년배들 다 돈 이렇게 쓴다</div>
						</div>

						<div class="row" style="height:30px">
						</div>

						<div class="row" >
							<div class="col-4 modalchart">
								<div class="col-12 TypeAnalysisModalTitle3">
									남들 보다 많이 사용해요
								</div>
								<div id="typetitleline3" class="typetitleline"></div>
								<div id="biggerUL" class="d-flex flex-wrap align-content-start" >
								</div>
							</div>
							<div class="col-4 modalchart">
								<div class="col-12 TypeAnalysisModalTitle3">
									남들보다 적게 사용해요
								</div>
								<div id="typetitleline3" class="typetitleline"></div>
								<div id="smallerUL" class="d-flex flex-wrap align-content-start" ></div>
							</div>
							<div class="col-4 modalchart">
								<div class="col-12 TypeAnalysisModalTitle3">
									남들과 비슷해요
								</div>
								<div id="typetitleline3" class="typetitleline"></div>
								<div id="middleUL" class="d-flex flex-wrap align-content-start" ></div>
							</div>
							
						</div>

						
						<div class="row">
							<div id="TypeAnalysisModalTitle" class="col-12">
								${member.name}님의 소비 패턴은 <b id="MyTypeTitle"> " ${ConsumeType} "</b> 입니다
							</div>
							<div class="typetitleline"></div>
						</div>
						
						<div class="row">
							<div class="col-12">
								<uL id="AnalyseModal1_UL">
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
							<div id="TypeAnalysisModalTitle2" class="col-12">
								${member.name}님은 <b id="MyTypeTitle"> " ${Daytype} " </b> 타입 입니다
							</div>
							<div id="typetitleline2" class="typetitleline"></div>
						</div>
						<div class="row">
							<div class="col-6 modalchart">
								<canvas id="modal_myChart4" width="500px" height="280px"></canvas>
							</div>
							<div class="col-6 modalchart">
								<canvas id="modal_myChart5" width="500px" height="280px"></canvas>
							</div>
						</div>
						<div class="row">
							<div class="col-6 modalchartTitle">${member.name}님과 동년배들의 한달 간 소비 추이</div>
							<div class="col-6 modalchartTitle">한달 간 누적 소비 추이 </div>
						</div>
						<div style="height:30px" ></div>

						<div class="row">
							<div class="col-6 modalchart">
								<div id="TypeAnalysisModalTitle2" class="col-12">
									<b id="maxday" >${maxday}</b>은 돈 쓰는 날!
								</div>
								<div id="typetitleline2" class="typetitleline"></div>
								<canvas id="modal_myChart6" width="400px" height="280px"></canvas>
							</div>
							<div class="col-6 modalchart">
								<div id="TypeAnalysisModalTitle2" class="col-12">
									요약
								</div>
								<div id="typetitleline2" class="typetitleline"></div>
								<ul id="AnalyseModal2_UL">
								</ul>
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
		$(function() {
			$('#AnalyseModal1_UL').append('<li class="ModalDescText"> ${member.name}님은 한 달간 <b class="modalWon">' +  '${myTotalConsume}'.replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",") +'</b>원을 사용하셨습니다.</li>');
			$('#AnalyseModal1_UL').append('<li> ${member.name}님의 동년배들은 평균적으로 <b class="modalWon">' +  '${avgTotalConsume}'.replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",") +'</b>원을 사용하는 군요.</li>');
			
			// 큰거
			var arr = '${bigger}'.substring(1,'${bigger}'.length -1	).split(', ');
			var count = 0;
			$.each( arr, function(index, element){
				var imgsrc = LCImage.get(element);
				$('#biggerUL').append('<div class="p-2 border CompareFlex">' 
										+ '<img id="cardImg" src="/resources/image/compare/'+imgsrc.substring(1,imgsrc.length)+'" width="50px" /> '
										+ '<div class="ULdesc">' + element + '</div></div>');
			});
			// 작은거
			var arr = '${smaller}'.substring(1,'${smaller}'.length -1	).split(', ');
			$.each( arr, function(index, element){
				var imgsrc = LCImage.get(element);
				$('#smallerUL').append('<div class="p-2 border CompareFlex">' 
										+ '<img id="cardImg" src="/resources/image/compare/'+imgsrc.substring(1,imgsrc.length)+'" width="50px" /> '
										+ '<div class="ULdesc">' + element + '</div></div>');
			});
			// 비슷한거
			var arr = '${same}'.substring(1,'${same}'.length -1	).split(', ');
			$.each( arr, function(index, element){
				var imgsrc = LCImage.get(element);
				$('#middleUL').append('<div class="p-2 border CompareFlex">' 
										+ '<img id="cardImg" src="/resources/image/compare/'+imgsrc.substring(1,imgsrc.length)+'" width="50px" /> '
										+ '<div class="ULdesc">' + element + '</div></div>');
			});

			var mybiggestM = "";
			var avgbiggestM = "";

			var count = 0;
			for(var i = '${mybiggestM}'.length -1; i >= 0 ; i-- ){
				if ( count != 0 && count % 3 == 0 ){
					mybiggestM = '${mybiggestM}'.charAt(i) + "," + mybiggestM;
				} else {
					mybiggestM = '${mybiggestM}'.charAt(i) + mybiggestM;
				}
				count += 1;
			}
			count = 0;
			for(var i = '${avgbiggestM}'.length -1; i >= 0 ; i-- ){
				if ( count != 0 && count % 3 == 0 ){
					avgbiggestM = '${avgbiggestM}'.charAt(i) + "," + avgbiggestM;
				} else {
					avgbiggestM = '${avgbiggestM}'.charAt(i) + avgbiggestM;
				}
				count += 1;
			}
			$('#AnalyseModal1_UL').append('<li> ${member.name}님이 가장 많이 사용하신 곳은 <b class="emphasize">' + '${mybiggest}' + '</b>으로, <b class="modalWon">' +  '${mybiggestM}'.replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",") +'</b>원 사용하셨습니다.</li>');
			$('#AnalyseModal1_UL').append('<li> ${member.name}님의 동년배가 가장 많이 사용하신 곳은 <b class="emphasize">' + '${avgbiggest}' + '</b>으로, <b class="modalWon">' +  '${avgbiggestM}'.replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",") +'</b>원 사용하셨습니다.</li>');
			
			if ( '${mybiggest}' == '${avgbiggest}' ){
				var biggest = Math.abs('${avgbiggestM}' - '${mybiggestM}');
				$('#AnalyseModal1_UL').append('<li> ${member.name}님은 다른 동년배처럼 <b class="emphasize">' + '${avgbiggest}' + '</b>에 가장 많이 사용하셨군요! 둘의 차이는 <b class="modalWon">' + biggest.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",") +'</b>원 입니다.</li>');
			}
			$('#AnalyseModal1_UL').append('<li> ${member.name}님과 동년배가 가장 많은 차이가 나는 곳은 <b class="emphasize">' + '${gap}' + '</b>으로, <b class="modalWon">' +  '${gapM}'.replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",") +'</b>원의 차이가 나는 군요! </li>');
			
			if ( '${gapM}' < 100_000 ) {
				$('#AnalyseModal1_UL').append('<li> ${member.name}님과 동년배의 소비패턴은 전체적으로 <b class="emphasize2">유사합니다.</b> </li>');	
			} else {
				$('#AnalyseModal1_UL').append('<li> ${member.name}님과 동년배의 소비패턴은 전체적으로 <b class="emphasize2">차이가 납니다.</b> </li>');	
			}

			//// modal2
			// DaytypeDesc
			if ( ('${myTotalConsume}' - '${avgTotalConsume}') > 100000 ) {
				$('#AnalyseModal2_UL').append('<li> ${member.name}님은 다른 사람들 보다 돈을 많이 쓰십니다 </li>');
			} else if ( ('${avgTotalConsume}' - '${myTotalConsume}') < -100000 )  {
				$('#AnalyseModal2_UL').append('<li> ${member.name}님은 다른 사람들 보다 돈을 적게 쓰십니다 </li>');
			} else if ( Math.abs('${myTotalConsume}' - '${avgTotalConsume}') < 100000 )  {
				$('#AnalyseModal2_UL').append('<li> ${member.name}님은 다른 사람들과 비슷하게 돈을 쓰시네요.  </li>');
			}

			$('#AnalyseModal2_UL').append('<li> 한 달간 <b class="modalWon">' +  '${myTotalConsume}'.replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",") +'</b>원을 사용하셨습니다.</li>');
			$('#AnalyseModal2_UL').append('<li> 동년배들은 평균적으로 <b class="modalWon">' +  '${avgTotalConsume}'.replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",") +'</b>원을 사용합니다.</li>');
			$('#AnalyseModal2_UL').append('<li> ${DaytypeDesc} </li>');
			$('#AnalyseModal2_UL').append('<li> 일주일 중 주로 <b class="emphasize"> ${maxday} </b>에 돈을 쓰시구요. </li>');
			
			
		});

		var AnalyseJSON = JSON.parse('${Object}');
		console.log(AnalyseJSON);
		
		// pie data
//		console.log(AnalyseJSON[0]);
//
		var LCImage = new Map();
		var mypieLabel = [];
		var mypieData = []; 
		for( element in AnalyseJSON[0] ){
			var temp = AnalyseJSON[0][element].split(",");
//			console.log(element + "   " + temp[0] + " " + temp[1]);
			mypieLabel.push(element);
			mypieData.push(temp[1]); 
			LCImage.set(element, temp[2]);
		}
        // PIE
        const ChartbyType_data = {
            labels: mypieLabel,
            datasets: [{
                label: 'My First Dataset',
                data: mypieData,
                backgroundColor: [
                    '#ffa69e', '#faf3dd', '#b8f2e6', '#aed9e0','#e7ecef',
                    '#274c77', '#6096ba', '#a3cef1', '#0b5394','#64a6bd',
                    '#ada7c9', '#ffc43d', '#ffb5a7', '#a9def9','#e4c1f9',
                    '#81c3d7', '#d6ce93', '#f4acb7', '#f4f1bb','#72ddf7',
                    '#ff0054', '#8093f1'
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

		// mylineChart start --------------------------------------------------------
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
                label: '나의 한달간 소비',
                backgroundColor: 'rgb(255,255,255)',
                borderColor: 'rgb(45, 37, 123)',
                data: mylineData,
            }]
        };


		////anima
		const totalDuration = 1500;
		const delayBetweenPoints = totalDuration / 31;
		const previousY = (ctx) => ctx.index === 0 ? ctx.chart.scales.y.getPixelForValue(100) : ctx.chart.getDatasetMeta(ctx.datasetIndex).data[ctx.index - 1].getProps(['y'], true).y;
		const animation = {
		x: {
			type: 'number',
			easing: 'linear',
			duration: delayBetweenPoints,
			from: NaN, // the point is initially skipped
			delay(ctx) {
			if (ctx.type !== 'data' || ctx.xStarted) {
				return 0;
			}
			ctx.xStarted = true;
			return ctx.index * delayBetweenPoints;
			}
		},
		y: {
			type: 'number',
			easing: 'linear',
			duration: delayBetweenPoints,
			from: previousY,
			delay(ctx) {
			if (ctx.type !== 'data' || ctx.yStarted) {
				return 0;
			}
			ctx.yStarted = true;
			return ctx.index * delayBetweenPoints;
			}
		}
		};

        const LineChart_config = {
            type: 'line',
            data: LineChart_data,
            options: {
				animation,
                responsive: false,
				plugins: {
					legend: {
						display: false,
						labels: {
							color: 'rgb(45, 37, 123)',
						}
					}
				}
            }
        };

        const myChart2 = new Chart(document.getElementById('myChart2'), LineChart_config);
		// mylineChart end --------------------------------------------------------
		
        // modal chart 1 --------------------------------------------------------
        const modal_chart_1_config = {
            type: 'pie',
            data: ChartbyType_data,
            options: {
                responsive: false,
				plugins: {
					legend: {
						display: false,
						position : 'left',
					}
				}
            }
        };
        const modal_myChart1 = new Chart(document.getElementById('modal_myChart1'), modal_chart_1_config);
        // modal chart 1 -------------------------------------------------------- end

        // modal chart 2  --------------------------------------------------------
		var avgpidLabel = [];
		var avgpieData = []; 
		for( element in AnalyseJSON[3] ){
			var temp = AnalyseJSON[3][element].split(",");
			avgpidLabel.push(element);
			avgpieData.push(temp[1]); 
		}
        const ChartbyType_2_data = {
            labels: avgpidLabel,	
            datasets: [{
                label: 'My First Dataset',
                data: avgpieData,
                backgroundColor: [
                    '#ffa69e', '#faf3dd', '#b8f2e6', '#aed9e0','#e7ecef',
                    '#274c77', '#6096ba', '#a3cef1', '#0b5394','#64a6bd',
                    '#ada7c9', '#ffc43d', '#ffb5a7', '#a9def9','#e4c1f9',
                    '#81c3d7', '#d6ce93', '#f4acb7', '#f4f1bb','#72ddf7',
                    '#ff0054', '#8093f1'
                ],
                hoverOffset: 4
            }]
        };
        const modal_chart_2_config = { 
            type: 'pie',
            data: ChartbyType_2_data,
            options: {
                responsive: false,
				plugins: {
					legend: {
						display: false,
						position : 'bottom',
					}
				}
            }
        };
        const modal_myChart2 = new Chart(document.getElementById('modal_myChart2'), modal_chart_2_config);
        //  -------------------------------------------------------- end 
        
        // modal chart 4 // avg line chart  ---------------------------------------------------------------- 
		var avglineMap = new Map();
		for( element in AnalyseJSON[4] ) {
			var key = element.substring(2,4);
			if ( avglineMap.has(key) ) {
				avglineMap.set(key, avglineMap.get(key) + AnalyseJSON[4][element]);
			} else {
				avglineMap.set(key, AnalyseJSON[4][element]);
			}
		}

		var avglineLabel = [];
		var avglineData = [];
		for(var i = 1; i <= 31; i++){
			var key = "";
			if ( i < 10 ){
				key = "0" + i;
			}  else {
				key = i + "";
			}
			avglineLabel.push(key);
			if ( avglineMap.has(key) ) {
				avglineData.push(avglineMap.get(key));
			} else {
				avglineData.push(0);
			}
		}
        const LineChart_aval_data = {
            labels: avglineLabel,
            datasets: [
				{
					label: '나의 사용금액',
					borderColor: '#80002b',
					backgroundColor: 'rgb(255,255,255)',
					data: mylineData,
            	},
				{
					label: '다른 사용자의 평균 사용금액',
					borderColor: '#ffc9db',
					backgroundColor: 'rgb(255,255,255)',
					data: avglineData,
            	},
			]
        };

        const LineChart_aval_config = {
            type: 'line',
            data: LineChart_aval_data,
            options: {
				animation,
                responsive: false,
				plugins: {
					legend: {
						display: false,
						position : 'left',
					}
				}
            }
        };
        // end  ---------------------------------------------------------------- 

		// modal_myChart5 -----------------------------------------------------------------------------
		var mylineData2 = [];
		var mylineData2_sum = 0;
		var avglineData2 = [];
		var avglineData2_sum = 0;
		for(var i = 0; i < avglineLabel.length; i++){
			mylineData2_sum += mylineData[i];
			mylineData2.push(mylineData2_sum);
			avglineData2_sum += avglineData[i];
			avglineData2.push(avglineData2_sum);			
		}

		const LineChart_accumulatel_data = {
            labels: avglineLabel,
            datasets: [
				{
					label: '나의 한달 간 누적 사용금액 ',
					borderColor: '#351c75',
					backgroundColor: 'rgb(255,255,255)',
					data: mylineData2,
            	},
				{
					label: '다른 사용자의 평균 누적 사용금액',
					borderColor: '#7abccf',
					backgroundColor: 'rgb(255,255,255)',
					data: avglineData2,
            	},
			]
        };
        const LineChart_accumulate_config = {
            type: 'line',
            data: LineChart_accumulatel_data,
            options: {
				animation,
                responsive: false,
				plugins: {
					legend: {
						display: false,
						position : 'left',
					}
				}
            }
        };
        // end  ------------------------------------------------------------------------------ 

		// modal_myChart6   ------------------------------------------------------------------------------ 
		var myDoughnutLabel = [];
		var myDoughnuteData = []; 
		for( element in AnalyseJSON[5] ){
			myDoughnutLabel.push(element);
			myDoughnuteData.push(AnalyseJSON[5][element]); 
		}
		console.log(myDoughnutLabel);
		const DoughnutChart_data = {
			labels: myDoughnutLabel,
			datasets: [
				{
					label: '요일 별 소비 데이터',
					data: myDoughnuteData,
					backgroundColor: [
						'#9b5de5', '#f15bb5', '#fee440', '#00bbf9','#00f5d4',
						'#ff595e', '#8ac926', '#8fffd9',  '#1982c4','#6a4c93',
					]
				}
			],
			
			
		};
		const DoughnutChart_config = {
			type: 'doughnut',
			data: DoughnutChart_data,
			options: {
				responsive: false,
				plugins: {
					legend: {
						display: true,
						position: 'right',
					},
					title: {
						display: false,
						text: 'Chart.js Doughnut Chart'
					}
				}
			},
		};
        const myChart6 = new Chart(document.getElementById('modal_myChart6'), DoughnutChart_config);
		// end   ------------------------------------------------------------------------------ 

		function addChart2(){
       		const myChart4 = new Chart(document.getElementById('modal_myChart4'), LineChart_aval_config);
			const myChart5 = new Chart(document.getElementById('modal_myChart5'), LineChart_accumulate_config);
			addChart2 = function(){};
		}

    </script>
	<script type="text/javascript" src="/resources/js/analysis_wordcloud.js"></script> 
	<script src="/resources/js/jquery-3.3.1.min.js"></script>
	<script src="/resources/js/jquery.steps.js"></script>
	<script src="/resources/js/main.js"></script>
</body>
</html>
