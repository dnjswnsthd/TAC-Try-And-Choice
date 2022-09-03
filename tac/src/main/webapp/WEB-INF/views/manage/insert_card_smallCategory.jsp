<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html lang="en">

		<head>
			<meta charset="utf-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<link rel="shortcut icon" type="image/x-icon"
				href="https://cdn-icons-png.flaticon.com/128/3093/3093042.png">
			<title>관리자 모드 - 소분류 등록</title>

			<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" />
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

			<!-- CSS -->
			<link rel="stylesheet" href="/resources/css/addSmallCategory.css">
			<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">

			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
			<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
			<script type="text/javascript">
				$(function () {
					$('#addSmallBtn').on('click', function () {
						var largeId = $('#large_category_selection').val();
						var smallName = document.getElementById('add_small_category_name').value;
						$.ajax({
							type: 'post',
							url: '/category/smallRegAndgetCategory',
							data: {
								smallname: smallName,
								largeid: largeId
							},

							success: function (result) {
								swal('등록 완료', smallName + '이(가) 추가 되었습니다', 'success');
								var small = "";
								var small_select = "";
								for (key in result) {
									small += '<div class="p-2 LCnameBox">' + result[key] + '</div>';
									small_select += '<option value=' + key + '>' + result[key] + '</option>'
								}
								$('#biggerUL').html(small);
								$('#small_category_selection').html(small_select);
								document.getElementById('add_small_category_name').value = null;
							}
						});
					});

					$('#large_category_selection').change(function () {
						$.ajax({
							type: 'post',
							url: '/category/getSmallCategory',
							data: {
								id: $(this).val()
							},

							success: function (result) {
								var small = "";
								var small_select = "";
								for (key in result) {
									small += '<div class="p-2 LCnameBox">' + result[key] + '</div>';
									small_select += '<option value=' + key + '>' + result[key] + '</option>'
								}
								$('#biggerUL').html(small);
								$('#small_category_selection').html(small_select);
							}
						});
					});

					$('#deleteSmallName').on('click', function () {
						const smallNameDel = $('#small_category_selection option:selected').text();
						const largeId = $('#large_category_selection').val();
						$.ajax({
							type: 'post',
							url: '/category/deleteSmallCategory',
							data: {
								name: smallNameDel,
								largeid: largeId
							},
							success: function (result) {
								swal('삭제 완료', smallNameDel + '이(가) 삭제되었습니다', 'success');
								var small = "";
								var small_select = "";
								for (key in result) {
									small += '<div class="p-2 LCnameBox">' + result[key] + '</div>';
									small_select += '<option value=' + key + '>' + result[key] + '</option>'
								}
								$('#biggerUL').html(small);
								$('#small_category_selection').html(small_select);
							}

						});
					});


				});	
			</script>
		</head>

		<body>
			<jsp:include page="/resources/component/header.jsp"></jsp:include>

			<div id="mainbody" class="page-content">
				<div class="container py-3">
					<header>
						<div class="pricing-header p-3 pb-md-4 mx-auto text-center">
							<h1 id="LCTitleText" class="display-4 fw-normal"> 소분류 추가 </h1>
						</div>
					</header>
				</div>
				<main>
					<div class="row" style="">
						<div class="col-4 large_category_list">대분류 선택</div>
						<div class="col-8 form-bottom" id="form-box-left">
							<select name="large_category" id="large_category_selection">
								<option value="largeName">==대분류 선택==</option>
								<c:forEach items="${largeCategory}" var="large">
									<option value="${large.largeCategoryId}">${large.largeCategoryName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div id="line"></div>

					<div class="row" style="height:20rem">
						<div class="col-sm-6">
							<div class="small_category_list">선택한 대분류 내 카테고리</div>
							<div id="line2"></div>
							<div id="biggerUL" class="d-flex flex-wrap align-content-start">
							</div>
						</div>

						<div class="col-sm-3">
							<div class="SubCategoryTItle">추가</div>
							<div class="line"> </div>
							<input type="text" placeholder="추가할 새 카테고리" name="smallCategoryName" ,
								id="add_small_category_name">
							<button type="submit" class="btn" id="addSmallBtn"> 등록 </button>

						</div>
						<div class="col-sm-3">
							<div class="SubCategoryTItle">삭제</div>

							<div class="form-bottom">
								<select name="small_category" id="small_category_selection">
								</select>
								<button type="submit" class="btn" id="deleteSmallName">삭제</button>
							</div>
						</div>


					</div>

					<div class="row" style="margin-top: 3rem">
						<button id="gomanagebtn" class="btn" onclick="goManageBtn()">관리자 페이지 이동</button>
						<button id="gomanagebtn" class="btn" onclick="addLargeCategory()">대분류 추가 페이지</button>
					</div>

				</main>

			</div>
			<footer>
			</footer>
			<script>
				function goManageBtn(){
					location.href = '/manage_card';
				}
				function addLargeCategory(){
					location.href = '/addLargeCategory';
				}

			</script>
		</body>
		

		</html>