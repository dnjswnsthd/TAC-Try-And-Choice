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
			<title> 관리자 모드 - 대분류 등록 </title>

			<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" />
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
			<!-- CSS -->
			<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
			<link rel="stylesheet" href="/resources/css/manage/add_category.css">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
			<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
			<script type="text/javascript">
				$(function () {
					$('#addLargeName').on('click', function () {
						const largeName = document.getElementById('add_large_category_name').value;
						$.ajax({
							type: 'post',
							url: '/category/LargeRegAndgetCategory',
							data: {
								name: largeName
							},
							success: function (result) {
								swal('등록 완료', largeName + '이(가) 추가 되었습니다', 'success')
								var large = "";
								var large_select = "";
								for (key in result) {
									large +=  '<div class="p-2 LCnameBox">' + result[key]  + '</div>';
									large_select += '<option value=' + key + '>' + result[key] + '</option>'
								}
								$('#biggerUL').html(large);
								$('#large_category_selection').html(large_select);
								document.getElementById('add_large_category_name').value = null;
							}
						});
					});

					$('#deleteLargeName').on('click', function () {
						const largeNameDel = $('#large_category_selection option:selected').text();
						$.ajax({
							type: 'post',
							url: '/category/deleteLargeCategory',
							data: {
								name: largeNameDel
							},
							success: function (result) {
								swal('삭제 완료', largeNameDel + '이(가) 삭제되었습니다', 'success');
								var large = "";
								var large_select = "";
								for (key in result) {
									large +=  '<div class="p-2 LCnameBox">' + result[key]  + '</div>';
									large_select += '<option value=' + key + '>' + result[key] + '</option>'
								}
								$('#largeTable').html(large);
								$('#large_category_selection').html(large_select);
							}

						});
					});

				});	
			</script>
		</head>

		<body>
			<jsp:include page="/resources/component/header.jsp"></jsp:include>

			<!-- content -->
			<div id="mainbody" class="page-content">
				<div class="container py-3">
					<header>
						<div class="pricing-header p-3 pb-md-4 mx-auto text-center">
							<h1 id="LCTitleText" class="display-4 fw-normal"> 대분류 추가 </h1>
						</div>
					</header>
					<main>

						<div class="row">
							<div class="col-8">
								<div class="large_category_list">
									<b>대분류 목록 </b>
								</div>
								<div id="line"></div>


								<div id="biggerUL" class="d-flex flex-wrap align-content-start">
									<c:forEach items="${largeCategory}" var="large">
										<div class="p-2 LCnameBox"> ${large.largeCategoryName} </div>
									</c:forEach>
								</div>

							</div>

							<div id="RightBox" class="col-4">
								<div class="SubCategoryTItle">추가</div>
								<div class="line"> </div>
								<input type="text" placeholder="대분류 이름 입력" name="largeCategoryName"
									id="add_large_category_name">
								<button type="submit" class="btn" id="addLargeName">등록</button>
								
								<div id="blank"></div>

								<div class="SubCategoryTItle">삭제</div>
								<select name="large_category" id="large_category_selection">
									<c:forEach items="${largeCategory}" var="large">
										<option value="${large.largeCategoryId}">${large.largeCategoryName}
										</option>
									</c:forEach>
								</select>
								<button type="submit" class="btn" id="deleteLargeName">삭제</button>



							</div>


						</div>
						<!-- <div class="row">
							<button id="gomanagebtn" class="btn" onclick="goManageBtn()">카드 등록 화면으로 돌아가기</button>
							<button id="gomanagebtn" class="btn" onclick="addSmallCategory()">소분류 추가 페이지</button>
						</div> -->

					</main>

				</div>
			</div>

			<footer>
			</footer>
			<script>
				function goManageBtn(){
				location.href = '/manage_card';
				}
				function addSmallCategory(){
				location.href = '/addSmallCategory';
				}
			</script>
		</body>

		</html>