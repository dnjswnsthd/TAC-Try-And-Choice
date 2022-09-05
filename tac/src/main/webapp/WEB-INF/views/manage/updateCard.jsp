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
			<title>관리자 모드 - 카드 수정</title>
			<!-- CSS -->
			<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
			<link rel="stylesheet" href="/resources/css/updateCard.css" />

			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
			<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
			<script type="text/javascript">
				$(function () {
					var table_header = '<div class="row"><div class="col-sm-2 text-center">대분류</div><div class="col-sm-2 text-center">소분류</div><div class="col-sm-2 text-center">최소결제금액</div><div class="col-sm-2 text-center">최대할인금액</div><div class="col-sm-2 text-center">최대할인횟수</div><div class="col-sm-2 discount_rate_header text-center">할인율</div></div><hr>'

					$('#moveModify').on('click', function () {
						var cardId = $('.allCard1 option:selected').val();
						$.ajax({
							type: 'post',
							url: '/getSelectCard',
							data: {
								cardId: cardId
							},
							success: function (result) {
								$("#preview").attr("src", "/resources/image/card_horizon/" + result.cardImgHorizon);
								$('input[name=cardName]').val(result.cardName);
								$('input[name=cardDesc]').val(result.cardDesc);
								$('input[name=maxDiscount]').val(result.maxDiscount);
							}
						});

						$.ajax({
							type: 'post',
							url: '/getSelectCardDetail',
							data: {
								cardId: cardId
							},
							success: function (result) {
								var table_list = "";

								for (key in result) {
									table_list = table_list + '<div class="row list" id='+result[key].cardDetailId +'>'
															+ '<div class="col-sm-2 large_category"><input type="text" readonly class="add_manage_option form-control"  name="largeCategoryName" id=' + result[key].largeCategoryId + ' value=' + result[key].largeCategoryName + '></div>'
															+ '<div class="col-sm-2 small_category"><input type="text" readonly class="add_manage_option form-control"  name="smallCategoryName" id=' + result[key].smallCategoryId + ' value=' + result[key].smallCategoryName + '></div>'
															+ '<div class="col-sm-2 min_amount" id="min_amount"><input type="number" name="min_price" id = "min_price" class="add_manage_option form-control" value=' + result[key].minPayment + '><label>&nbsp;원</label></div>'
															+ '<div class="col-sm-2 max_discount" id="max_discount"><input type="number" name="max_price" id = "max_price" class="add_manage_option form-control" value=' + result[key].maxDiscount + '><label>&nbsp;원</label></div>'
															+ '<div class="col-sm-2 max_count" id="max_count"><input type="number" name="max_count" id="max_c" class="add_manage_option form-control" value=' + result[key].maxCount + '><label>&nbsp;번</label></div>'
															+ '<div class="col-sm-2 discount_rate" id="discount_rate"><input type="number" name="discount_percent" id="discount_percent" class="add_manage_option form-control" value=' + result[key].discountPercent + '><label>&nbsp;%</label>'
															+ '<img class = "deleteList" src="/resources/image/card_manage/delete.png">'
															+ '<img class = "updateList" src="/resources/image/card_manage/update.png"></div>'
															+ '</div><br><br>'
								}
								$('#register_category').html(table_header + table_list);
							}
						});
						
						$.ajax({
			    			type:'post',
			    			url:'/category/getLargeCategory',
			    			
			    			success:function(result) {
			    				var large_list = "";
			    				var large = "<option value=largeName>==대분류선택==</option>";
			    				for (key in result) {
			    					large_list += '<option value=' + key + '>'+ result[key] +'</option>'
			    				}
			    				$('.large_category_selection').html(large+large_list);
			    				$('.small_category_selection').html('<option selected>소분류를 선택하세요</option>');
			    			}
			    		});
					});

					$('#cardUpdate').on('click', function () {
						var cardId = $('.allCard1 option:selected').val();
						var cardName = $('input[name=cardName]').val();
						var cardDesc = $('input[name=cardDesc]').val();
						var maxSale = $('input[name=maxDiscount]').val();
						var card_img = document.querySelector("#cardimg").files[0];

						var formData = new FormData();
						formData.append("cardId", cardId);
						formData.append("cardname", cardName);
						formData.append("carddesc", cardDesc);
						formData.append("maxsale", maxSale);
						formData.append("cardImg", card_img);

						$.ajax({
							type:'put',
							url:'/updateCard3',
							enctype:'multipart/form-data',
							contentType: false,
							processData: false,
							cache: false,
							data : formData,
							success: function (result) {
								swal('수정완료', '', 'success');

								//	    				
								var card = "";
								var card_default = '<option value=smallName>==카드 선택==</option>';
								for (key in result) {
									card += '<option value=' + key + '>'+ result[key] +'</option>'
								}
								// 초기화
								$("#preview").attr("src", "/resources/image/card_horizon/card_none_horizon.png");
								$('.allCard1').html(card_default+card);
								$('input[name=cardName]').val("");
								$('input[name=cardDesc]').val("");
								$('input[name=maxDiscount]').val("");
								$('.list').html("");
								
							}
						});
					});

					$('#cardDelete').on('click', function () {
						var cardName = $('input[name=cardName]').val();
						swal({
							title : "카드 삭제",
							text : " [ " + cardName + " ] 를(을) 정말로 삭제하시겠습니까?",
							type : "warning",
							icon: "warning",
							buttons:['취소','삭제'],
						}).then( function(isConfirm) {
							if (isConfirm) {
								$.ajax({
									type: 'post',
									url: '/deleteCard',
									data: {
										cardId: $('.allCard1 option:selected').val(),
									},
									success: function (result) {
										swal("삭제 완료", cardName + " 카드가 삭제되었습니다.", 'success');
										var card_list = "";
										var card_header = '<option value="largeName">==카드 선택==</option>';
										for (key in result) {
											card_list += '<option value=' + result[key].cardId + '>' + result[key].cardName + '</option>'
										}
										$('.allCard1').html(card_header + card_list);
										$("#preview").attr("src", "/resources/image/card_horizon/card_none_horizon.png");
										$('input[name=cardName]').val("");
										$('input[name=cardDesc]').val("");
										$('input[name=maxDiscount]').val("");
										$('.list').html("");
									}
								});
							}else{
								// 카드 삭제 안함
							}
						});
					});
					
					$('.large_category_selection').on('change', function() {
			    		$.ajax({
							type : 'post',
							url : '/category/getSmallCategory',
							data : {
								id : $(this).val()
							},

							success : function(result) {
								var small = "";
								var small_default = '<option value=smallName>==소분류선택==</option>';
								for (key in result) {
									small = small + '<option value=' + key + '>'+ result[key] +'</option>'
								}
								$('.small_category_selection').html(small_default + small);
							}
						});
			    	});
					
					$('.addSaleList').on('click', function() {
			    		var largeName = $('.large_category_selection option:selected').text();
			    		var smallName = $('.small_category_selection option:selected').text();
			    		var largeId = $('.large_category_selection option:selected').val();
			    		var smallId = $('.small_category_selection option:selected').val();
			    		var cardName = $('.allCard1 option:selected').text();
						  var cardId = $('.allCard1 option:selected').val();
						  var message = "";
						
						if(cardName == "카드 선택"){
			    			message = "카드 이름"
						}else if(largeName == "==대분류선택=="){
			    			message = "대분류"
						}else if(smallName == "==소분류선택=="){
			    			message = "소분류"
			    		}
			    		if(message != ""){
			    			swal(message + "은(는) 필수값입니다.", '', 'error');
			    			evt.preventDefault();	
			    		}else{
                  sale_list = '<div class="row" id='+cardId+'>'
                + '<div class="col-sm-2 large_category" id="large_category"><input type="text" readonly class="add_manage_option form-control"  name="largeCategoryName" id=' + largeId + ' value=' + largeName + '></div>'
                + '<div class="col-sm-2 small_category" id="small_category"><input type="text" readonly class="add_manage_option form-control"  name="smallCategoryName" id=' + smallId + ' value=' + smallName + '></div>'
                + '<div class="col-sm-2 min_amount" id="min_amount"><input type="number" name="min_price" id = "min_price" class="add_manage_option form-control" value=0><label>&nbsp;원</label></div>'
                + '<div class="col-sm-2 max_discount" id="max_discount"><input type="number" name="max_price" id = "max_price" class="add_manage_option form-control" value=0><label>&nbsp;원</label></div>'
                + '<div class="col-sm-2 max_count" id="max_count"><input id="max_c" type="number" name="max_count" class="add_manage_option form-control" value=0><label>&nbsp;번</label></div>'
                + '<div class="col-sm-2 discount_rate" id="discount_rate"><input type="number" name="discount_percent" id="discount_percent" class="add_manage_option form-control" value=0><label>&nbsp;%</label>'
                + '<img class = "deleteAddList" src="/resources/image/card_manage/delete.png">'
                + '<img class = "addList" src="/resources/image/card_manage/add.png"></div>'
                + '</div><br><br>'

                $('#register_category').append(sale_list);
			    		}
			    	});

					$(document).on('click','.updateList', function () {
						$.ajax({
							type: 'put',
							url: '/updateCardDetail',
							data: {
								cardId: $('.allCard1 option:selected').val(),
								cardDetailId: $(this).parent().parent().attr('id'),
								discountPercent: $(this).parent().parent().children('div[id="discount_rate"]').children('input[name=discount_percent]').val(),
								minPayment: $(this).parent().parent().children('div[id="min_amount"]').children('input[name=min_price]').val(),
								maxDiscount: $(this).parent().parent().children('div[id="max_discount"]').children('input[name=max_price]').val(),
								maxCount: $(this).parent().parent().children('div[id="max_count"]').children('input[name=max_count]').val()
							},
							success: function (result) {
								swal("업데이트 완료", "", 'success');
								var table_list = "";
								for (key in result) {
									table_list = table_list + '<div class="row list" id='+result[key].cardDetailId +'>'
															+ '<div class="col-sm-2 large_category"><input type="text" readonly class="add_manage_option form-control"  name="largeCategoryName" id=' + result[key].largeCategoryId + ' value=' + result[key].largeCategoryName + '></div>'
															+ '<div class="col-sm-2 small_category"><input type="text" readonly class="add_manage_option form-control"  name="smallCategoryName" id=' + result[key].smallCategoryId + ' value=' + result[key].smallCategoryName + '></div>'
															+ '<div class="col-sm-2 min_amount" id="min_amount"><input type="number" name="min_price" id = "min_price" class="add_manage_option form-control" value=' + result[key].minPayment + '><label>&nbsp;원</label></div>'
															+ '<div class="col-sm-2 max_discount" id="max_discount"><input type="number" name="max_price" id = "max_price" class="add_manage_option form-control" value=' + result[key].maxDiscount + '><label>&nbsp;원</label></div>'
															+ '<div class="col-sm-2 max_count" id="max_count"><input type="number" name="max_count" id="max_c" class="add_manage_option form-control" value=' + result[key].maxCount + '><label>&nbsp;번</label></div>'
															+ '<div class="col-sm-2 discount_rate" id="discount_rate"><input type="number" name="discount_percent" id="discount_percent" class="add_manage_option form-control" value=' + result[key].discountPercent + '><label>&nbsp;%</label>'
															+ '<img class = "deleteList" src="/resources/image/card_manage/delete.png">'
															+ '<img class = "updateList" src="/resources/image/card_manage/update.png"></div>'
															+ '</div><br><br>'

								}
								$('#register_category').html(table_header + table_list);
							}
						});
					});

					$(document).on('click','.deleteList', function () {
						$.ajax({
							type: 'post',
							url: '/cardDetailDelete',
							data: {
								cardId: $('.allCard1 option:selected').val(),
								cardDetailId: $(this).parent().parent().attr('id')
							},
							success: function (result) {
								swal("삭제 완료", "", 'success');
								var table_list = "";
								for (key in result) {
									console.log(result[key].largeCategoryName);
									console.log(result[key].smallCategoryName);
									
									table_list = table_list + '<div class="row list" id='+result[key].cardDetailId +'>'
															+ '<div class="col-sm-2 large_category"><input type="text" readonly class="add_manage_option form-control"  name="largeCategoryName" id=' + result[key].largeCategoryId + ' value=' + result[key].largeCategoryName + '></div>'
															+ '<div class="col-sm-2 small_category"><input type="text" readonly class="add_manage_option form-control"  name="smallCategoryName" id=' + result[key].smallCategoryId + ' value=' + result[key].smallCategoryName + '></div>'
															+ '<div class="col-sm-2 min_amount" id="min_amount"><input type="number" name="min_price" id = "min_price" class="add_manage_option form-control" value=' + result[key].minPayment + '><label>&nbsp;원</label></div>'
															+ '<div class="col-sm-2 max_discount" id="max_discount"><input type="number" name="max_price" id = "max_price" class="add_manage_option form-control" value=' + result[key].maxDiscount + '><label>&nbsp;원</label></div>'
															+ '<div class="col-sm-2 max_count" id="max_count"><input type="number" name="max_count" id="max_c" class="add_manage_option form-control" value=' + result[key].maxCount + '><label>&nbsp;번</label></div>'
															+ '<div class="col-sm-2 discount_rate" id="discount_rate"><input type="number" name="discount_percent" id="discount_percent" class="add_manage_option form-control" value=' + result[key].discountPercent + '><label>&nbsp;%</label>'
															+ '<img class = "deleteList" src="/resources/image/card_manage/delete.png">'
															+ '<img class = "updateList" src="/resources/image/card_manage/update.png"></div>'
															+ '</div><br><br>'

								}
								$('#register_category').html(table_header + table_list);
							}
						});
					});
					
					$(document).on('click','.addList', function () {
						var cardId = $('.allCard1 option:selected').val();
						var cardDetailId = $(this).parent().parent().attr('id');
						var discountPercent = $(this).parent().parent().children('div[id="discount_rate"]').children('input[name=discount_percent]').val();
						var minPayment = $(this).parent().parent().children('div[id="min_amount"]').children('input[name=min_price]').val();
						var maxDiscount = $(this).parent().parent().children('div[id="max_discount"]').children('input[name=max_price]').val();
						var maxCount = $(this).parent().parent().children('div[id="max_count"]').children('input[name=max_count]').val();
						var largeCategoryId = $(this).parent().parent().children('div[id="large_category"]').children('input[name=largeCategoryName]').attr("id");
						var smallCategoryId = $(this).parent().parent().children('div[id="small_category"]').children('input[name=smallCategoryName]').attr("id");
						var message = "";
						if(discountPercent == 0){
			    			message = "할인율"
			    		}
			    		if(message != ""){
			    			swal(message + "은(는) 필수값입니다.", '', 'error');
			    			evt.preventDefault();	
			    		}else{
							$.ajax({
				    			type:'post',
				    			url:'/registerCardDetailByUpdate',
				    			data : {
				    				discountpercent : discountPercent,
				    				cardid : cardId,
				    				largeid : largeCategoryId,
				    				smallid : smallCategoryId,
				    				minprice : minPayment,
				    				maxprice : maxDiscount,
				    				maxcount : maxCount,
				    			},
				    			success: function (result) {
				    				swal('등록 완료', '새로운 목록이 추가 되었습니다', 'success');
									var table_list = "";
									for (key in result) {
										table_list = table_list + '<div class="row list" id='+result[key].cardDetailId +'>'
																+ '<div class="col-sm-2 large_category"><input type="text" readonly class="add_manage_option form-control"  name="largeCategoryName" id=' + result[key].largeCategoryId + ' value=' + result[key].largeCategoryName + '></div>'
																+ '<div class="col-sm-2 small_category"><input type="text" readonly class="add_manage_option form-control"  name="smallCategoryName" id=' + result[key].smallCategoryId + ' value=' + result[key].smallCategoryName + '></div>'
																+ '<div class="col-sm-2 min_amount" id="min_amount"><input type="number" name="min_price" id = "min_price" class="add_manage_option form-control" value=' + result[key].minPayment + '><label>&nbsp;원</label></div>'
																+ '<div class="col-sm-2 max_discount" id="max_discount"><input type="number" name="max_price" id = "max_price" class="add_manage_option form-control" value=' + result[key].maxDiscount + '><label>&nbsp;원</label></div>'
																+ '<div class="col-sm-2 max_count" id="max_count"><input type="number" name="max_count" id="max_c" class="add_manage_option form-control" value=' + result[key].maxCount + '><label>&nbsp;번</label></div>'
																+ '<div class="col-sm-2 discount_rate" id="discount_rate"><input type="number" name="discount_percent" id="discount_percent" class="add_manage_option form-control" value=' + result[key].discountPercent + '><label>&nbsp;%</label>'
																+ '<img class = "deleteList" src="/resources/image/card_manage/delete.png">'
																+ '<img class = "updateList" src="/resources/image/card_manage/update.png"></div>'
																+ '</div><br><br>'
									}
									$('#register_category').html(table_header + table_list);
								}
				    		});
			    		}
					});
					
					$(document).on('click','.deleteAddList', function () {
						var cardId = $('.allCard1 option:selected').val();
						$.ajax({
							type: 'post',
							url: '/getSelectCardDetail',
							data: {
								cardId: cardId
							},
							success: function (result) {
								swal("삭제 완료", "", 'success');
								var table_list = "";

								for (key in result) {
									table_list = table_list + '<div class="row list" id='+result[key].cardDetailId +'>'
															+ '<div class="col-sm-2 large_category"><input type="text" readonly class="add_manage_option form-control"  name="largeCategoryName" id=' + result[key].largeCategoryId + ' value=' + result[key].largeCategoryName + '></div>'
															+ '<div class="col-sm-2 small_category"><input type="text" readonly class="add_manage_option form-control"  name="smallCategoryName" id=' + result[key].smallCategoryId + ' value=' + result[key].smallCategoryName + '></div>'
															+ '<div class="col-sm-2 min_amount" id="min_amount"><input type="number" name="min_price" id = "min_price" class="add_manage_option form-control" value=' + result[key].minPayment + '><label>&nbsp;원</label></div>'
															+ '<div class="col-sm-2 max_discount" id="max_discount"><input type="number" name="max_price" id = "max_price" class="add_manage_option form-control" value=' + result[key].maxDiscount + '><label>&nbsp;원</label></div>'
															+ '<div class="col-sm-2 max_count" id="max_count"><input type="number" name="max_count" id="max_c" class="add_manage_option form-control" value=' + result[key].maxCount + '><label>&nbsp;번</label></div>'
															+ '<div class="col-sm-2 discount_rate" id="discount_rate"><input type="number" name="discount_percent" id="discount_percent" class="add_manage_option form-control" value=' + result[key].discountPercent + '><label>&nbsp;%</label>'
															+ '<img class = "deleteList" src="/resources/image/card_manage/delete.png">'
															+ '<img class = "updateList" src="/resources/image/card_manage/update.png"></div>'
															+ '</div><br><br>'
								}
								$('#register_category').html(table_header + table_list);
							}
						});
					});
					
				});

			</script>
		</head>

		<body>
			<jsp:include page="/resources/component/header.jsp"></jsp:include>

			<div id="container" class="container">
				<div class="row justify-content-around" id="contentDiv">
					<header>
						<div class="pricing-header p-3 pb-md-4 mx-auto text-center" id="title">
							<h2>카드수정</h2>
						</div>

					</header>
					<div class="card_information row">
						<div class="card_register">
							<h3><b>카드수정</b></h3>
							<hr>
							<select name="allCard1" class="allCard1 form-select">
								<option value="largeName" selected>카드 선택</option>
								<c:forEach items="${showAllCard}" var="card">
									<option value="${card.cardId}">${card.cardName}</option>
								</c:forEach>
							</select>
							<br>
							<input type="button" id="moveModify" value="수정하기" class="btn btn-outline-secondary"/>
							<hr>
						</div>
						<br>
					</div>


					<div class="card_information row">
						<div class="col-md-5">
							<form action="#" id="card_image_selection" enctype="multipart/form-data" >
								 
								   <div class="form-box text-center cardInfo">
									<div class="form-top">
										<img id="preview" src="/resources/image/card_horizon/card_none_horizon.png"/>
									</div>
									<label for="cardimg">
										<div class="btn btn-upload btn-outline-secondary"> 카드 이미지 선택 </div>
									</label>
									<input type="file" class="real-upload" name="cardImg" id="cardimg" onchange="readURL(this)" accept="image/*" >
								</div>            
							</form>
						</div>
						<div class="form-bottom col-md-7" id="form-box-left">
							<div class="form-floating mb-3">
								<input type="text" class="form-username form-control" id="card-name" name="cardName"
									placeholder="내용을 입력해주세요...">
								<label for="floatingInput">카드 이름</label>
							</div>
							<div class="form-floating mb-3">
								<input type="text" class="form-username form-control" id="card-desc" name="cardDesc"
									placeholder="내용을 입력해주세요...">
								<label for="floatingInput">카드 설명</label>
							</div>
							<div class="form-floating mb-3">
								<input type="text" class="form-password form-control" id="max-sale" name="maxDiscount"
									placeholder="내용을 입력해주세요...">
								<label for="floatingInput">최대 할인 금액</label>
							</div>
							<button type="button" class="btn btn-outline-secondary addBtn" id="cardUpdate"
								value="등록">수정</button>
							<button type="button" class="btn btn-outline-secondary addBtn" id="cardDelete"
								value="삭제">삭제</button>
						</div>
						
					</div>
					<br>

					<!-- 카드혜택등록 -->
					<div id="card">
						<div class="form-top" id="saleDetail">
	                   		<h3><b>할인 목록 등록</b></h3>
		                </div>
		                <hr>
						<div class="form-top" id="selectCard addSaleDetail">
							<div class="input-group">
							  <select name="large_category" class="large_category_selection form-select" id="inputGroupSelect04" aria-label="Default select example">
							    <option selected>대분류를 선택하세요</option>
								    <c:forEach items="${largeCategory}" var="largeCategory">
										<option value="${largeCategory.largeCategoryId}">${largeCategory.largeCategoryName}</option>
									</c:forEach>
							  </select>
							  
							</div>
								<br>
							<div class="input-group">
							  <select name="small_category" class="small_category_selection form-select" id="inputGroupSelect04" aria-label="Default select example">
							    <option selected>소분류를 선택하세요</option>
							  </select>
							  
							</div>
							<br>
								<button class="btn addSaleList btn-outline-secondary addBtn" id="cardReg2">할인혜택 추가하기</button>
							<br><br><br>
						
					</div>
					
					
					<!--  -->
					<div class="form-box" id="form-box-right">
						<div class="form-bottom">
							<h3><b>할인 목록 수정</b></h3>
							<hr>
							<div id="register_category">
								<div class="row">
								    <div class="col-sm-2 large_category text-center">
								      	대분류
								    </div>
								    <div class="col-sm-2 small_category text-center">
								      	소분류
								    </div>
								    <div class="col-sm-2 min_amount text-center">
								       	최소결제금액
								    </div>
								    <div class="col-sm-2 max_discount text-center">
								      	최대할인금액
								    </div>
								    <div class="col-sm-2 max_count text-center">
								      	최대할인횟수
								    </div>
								    <div class="col-sm-2 discount_rate_header text-center">
								      	할인율
								    </div>
								</div>
								<hr>
								<br>
		                        <button class="btn btn-outline-secondary addBtn cardReg3" id="register_card_detail">등록</button>
		                        <br><br><br><br>
		                     </div>
						</div>
					</div>
				</div>
			</div>
			<script>
				function readURL(input) {
					if (input.files && input.files[0]) {
						var reader = new FileReader();
						reader.onload = function(e) {
						document.getElementById('preview').src = e.target.result;
						};
						reader.readAsDataURL(input.files[0]);
					} else {
						document.getElementById('preview').src = "";
					}
				}
			</script>
		</body>
	</html>