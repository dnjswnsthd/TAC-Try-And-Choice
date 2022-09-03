<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" type="image/x-icon" href="https://cdn-icons-png.flaticon.com/128/3093/3093042.png">
        <title>관리자 모드 - 카드 수정</title>
        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
		<link rel="stylesheet" href="../resources/css/insertCardElement.css">
        <link rel="stylesheet" href="../resources/css/insertCardStyle.css"> 
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script type="text/javascript">
    $(function(){    	    	
    	var table_header = '<tr><th>대분류</th><th>소분류</th><th>최소결제금액</th><th>최대할인금액</th><th>최대할인횟수</th><th>할인율</th><th></th><th></th></tr>'
    		
    	$('#moveModify').on('click', function() {
    		var cardId = $('.allCard1 option:selected').val();
    		$.ajax({
    			type:'post',
    			url:'/getSelectCard',
    			data:{
    				cardId : cardId
    			},
    			success:function(result) {
    				$("#card_sample").attr("src", "/resources/image/card_horizon/"+ result.cardImgHorizon);
    				$('input[name=cardName]').val(result.cardName);
    				$('input[name=cardDesc]').val(result.cardDesc);
    				$('input[name=maxDiscount]').val(result.maxDiscount);
    			}
    		});
    		
    		$.ajax({
    			type:'post',
    			url:'/getSelectCardDetail',
    			data:{
    				cardId : cardId
    			},
    			success:function(result) {
    				var table_list = "";
  
    				for (key in result) {
    					table_list = table_list + '<tr id='+ result[key].cardDetailId +'><td><input type="text" name="largeCategoryName" id='+ result[key].largeCategoryId +' class="add_manage_option" value='+ result[key].largeCategoryName +' readonly></td>'
                					+ '<td><input type="text" name="smallCategoryName" class="add_manage_option" id='+ result[key].smallCategoryId +' value='+ result[key].smallCategoryName +' readonly></td>'
                					+ '<td><input type="text" name="min_price" class="add_manage_option" value='+ result[key].minPayment +'>원</td>'
                					+ '<td><input type="text" name="max_price" class="add_manage_option" value='+ result[key].maxDiscount +'>원</td>'
                					+ '<td><input type="text" name="max_count" class="add_manage_option" value='+ result[key].maxCount +'>번</td>'
                					+ '<td><input type="text" name="discount_percent" id="discount_percent" class="add_manage_option" value='+ result[key].discountPercent +'>%</td>'
                					+ '<td><img class = "deleteList" src="/resources/image/card_manage/delete.png"></td>'
                					+ '<td><img class = "updateList" src="/resources/image/card_manage/update.png"></td></tr>'

    				}
    				$('#register_category').html(table_header + table_list);
    			}
    		});
    	});
    	
    	$('#cardUpdate').on('click', function() {
    		$.ajax({
    			type:'put',
    			url:'/updateCard',
    			data:{
    				cardId :  $('.allCard1 option:selected').val(),
    				cardName : $('input[name=cardName]').val(),
    				cardDesc : $('input[name=cardDesc]').val(),
    				maxDiscount : $('input[name=maxDiscount]').val()
    	
    			},
    			success:function(result) {
    				swal('수정완료','', 'success');
    				$("#card_sample").attr("src", "/resources/image/card_horizon/"+ result.cardImgHorizon);
    				$('input[name=cardName]').val(result.cardName);
    				$('input[name=cardDesc]').val(result.cardDesc);
    				$('input[name=maxDiscount]').val(result.maxDiscount);
    			}
    		});
    	});
    	
    	$('#cardDelete').on('click', function() {
    		var cardName = $('input[name=cardName]').val();
    		$.ajax({
    			type:'post',
    			url:'/deleteCard',
    			data:{
    				cardId :  $('.allCard1 option:selected').val(),
    			},
    			success:function(result) {
    				swal("삭제 완료", cardName+" 카드가 삭제되었습니다.", 'success');
    				var card_list = "";
    				var card_header = '<option value="largeName">==카드 선택==</option>';
    				for(key in result) {
    					card_list += '<option value='+ result[key].cardId +'>'+ result[key].cardName +'</option>'
    				}
    				$('.allCard1').html(card_header + card_list);
    				$('input[name=cardName]').val("");
    				$('input[name=cardDesc]').val("");
    				$('input[name=maxDiscount]').val("");
    			}
    		});
    	});
    	
    	$(document).on('click', '.updateList', function() {
    		$.ajax({
    			type:'put',
    			url:'/updateCardDetail',
    			data:{
    				cardId : $('.allCard1 option:selected').val(),
    				cardDetailId : $(this).parents('tr').attr('id'),
    				discountPercent : $(this).parent().siblings().eq(5).children('input[name=discount_percent]').val(),
    				minPayment : $(this).parent().siblings().eq(2).children('input[name=min_price]').val(),
    				maxDiscount : $(this).parent().siblings().eq(3).children('input[name=max_price]').val(),
    				maxCount : $(this).parent().siblings().eq(4).children('input[name=max_count]').val()
    			},
    			success:function(result) {
    				swal("할인 상세 목록 수정 완료", '', 'success');
    				var table_list = "";
    				for (key in result) {
    					table_list = table_list + '<tr id='+ result[key].cardDetailId +'><td><input type="text" name="largeCategoryName" id='+ result[key].largeCategoryId +' class="add_manage_option" value='+ result[key].largeCategoryName +' readonly></td>'
                					+ '<td><input type="text" name="smallCategoryName" class="add_manage_option" id='+ result[key].smallCategoryId +' value='+ result[key].smallCategoryName +' readonly></td>'
                					+ '<td><input type="text" name="min_price" class="add_manage_option" value='+ result[key].minPayment +'>원</td>'
                					+ '<td><input type="text" name="max_price" class="add_manage_option" value='+ result[key].maxDiscount +'>원</td>'
                					+ '<td><input type="text" name="max_count" class="add_manage_option" value='+ result[key].maxCount +'>번</td>'
                					+ '<td><input type="text" name="discount_percent" id="discount_percent" class="add_manage_option" value='+ result[key].discountPercent +'>%</td>'
                					+ '<td><img class = "deleteList" src="/resources/image/card_manage/delete.png"></td>'
                					+ '<td><img class = "updateList" src="/resources/image/card_manage/update.png"></td></tr>'

    				}
    				$('#register_category').html(table_header + table_list);
    			}
    		});
    	});
    	
    	$(document).on('click', '.deleteList', function() {
    		$.ajax({
    			type:'post',
    			url:'/cardDetailDelete',
    			data:{
    				cardId : $('.allCard1 option:selected').val(),
    				cardDetailId : $(this).parents('tr').attr('id')
    			},
    			success:function(result) {
    				swal("삭제 완료", "", 'success');
    				var table_list = "";
    				for (key in result) {
    					table_list = table_list + '<tr id='+ result[key].cardDetailId +'><td><input type="text" name="largeCategoryName" id='+ result[key].largeCategoryId +' class="add_manage_option" value='+ result[key].largeCategoryName +' readonly></td>'
                					+ '<td><input type="text" name="smallCategoryName" class="add_manage_option" id='+ result[key].smallCategoryId +' value='+ result[key].smallCategoryName +' readonly></td>'
                					+ '<td><input type="text" name="min_price" class="add_manage_option" value='+ result[key].minPayment +'>원</td>'
                					+ '<td><input type="text" name="max_price" class="add_manage_option" value='+ result[key].maxDiscount +'>원</td>'
                					+ '<td><input type="text" name="max_count" class="add_manage_option" value='+ result[key].maxCount +'>번</td>'
                					+ '<td><input type="text" name="discount_percent" id="discount_percent" class="add_manage_option" value='+ result[key].discountPercent +'>%</td>'
                					+ '<td><img class = "deleteList" src="/resources/image/card_manage/delete.png"></td>'
                					+ '<td><img class = "updateList" src="/resources/image/card_manage/update.png"></td></tr>'

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
    	
        <!-- Top content -->
        <div class="top-content">
            <!-- <div class="inner-bg"> -->
                <div class="container">
                    <div class="card_register">
                    	<b>카드수정</b>
                    	<select name="allCard1" class="allCard1">
								<option value="largeName">==카드 선택==</option>
							<c:forEach items="${showAllCard}" var="card">
								<option value="${card.cardId}">${card.cardName}</option>
							</c:forEach>
						</select>
						<input type="button" id="moveModify" value="수정하기"/>
                    </div>                
                    <div class="row">
                        <div class="col-sm-5">
                        	<form action="#" id="card_image_selection">
                        	<div class="form-box">
	                        	<div class="form-top">
	                        		<img id="card_sample" src="/resources/image/card_manage/card_sample1.png">
	                            </div>
	                        <input type="file" class="real-upload" accept="image/*" required multiple style="display: none;">
	                        <button type="submit" id="image_selection_left" class="btn btn-default">이미지 수정(앞)</button>
	                        </form> 
	                        
	                        <script type="text/javascript">
							    function getImageFiles(e) {
							      const files = e.currentTarget.files;
							    }
							
							    const realUpload = document.querySelector('.real-upload');
							    const upload_front_image = document.querySelector('#image_selection_left');
							
							    upload_front_image.addEventListener('click', () => realUpload.click());
							    realUpload.addEventListener('change', getImageFiles);
							</script>
	                       
	                       	<div class="card_information">
	                      		 <b>카드 수정</b>
	                       	</div>    	
	                            <div class="form-bottom" id="form-box-left">
				                    	<div class="form-group">
				                    		<label class="sr-only" for="form-username"></label>
				                        	<b class="inline_text">카드 이름</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="cardName" placeholder="내용을 입력해주세요..." class="form-username form-control" id="card-name">
				                        </div>
				                    	<div class="form-group">
				                    		<label class="sr-only" for="form-username"></label>
				                        	<b class="inline_text">카드 설명</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="cardDesc" placeholder="내용을 입력해주세요..." class="form-username form-control" id="card-desc">
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-password"></label>
				                        	<b class="inline_text">최대 할인 금액</b>&nbsp;&nbsp;&nbsp;<input type="text" name="maxDiscount" placeholder="내용을 입력해주세요..." class="form-password form-control" id="max-sale">
				                        </div>
				                        <button class="btn" id="cardUpdate" value="등록">수정</button>
				                        <button class="btn" id="cardDelete" value="삭제">삭제</button>
			                    </div>
		                    </div>     
                        </div>
                        
                        	
                        <div class="col-sm-7">
                        	
                        	<div class="form-box" id="form-box-right">
	                            <div class="form-bottom">
				                    <!-- <form role="form" action="cardDetailReg.do" method="post" class="reg_card_detail"> -->
				                    	
				                        <table id="register_category">
				                        <tr>
					                        <th>대분류</th>
					                        <th>소분류</th>
					                        <th>최소결제금액</th>
					                        <th>최대할인금액</th>
					                        <th>최대할인횟수</th>
					                        <th>할인율</th>
					                        <th></th>
				                        </tr>
				                        <tr>
				                        	<td>
												<input type="text" name="largeCategoryName" id="largeCategoryName" class="add_manage_option">
				                        	</td>
				                        	<td>
				                        		<input type="text" name="smallCategoryName" class="add_manage_option">
				                        	</td>
				                        	<td>
				                        		<input type="number" name="min_price" id = "min_price" class="add_manage_option" value="0">원
				                        	</td>
				                        	<td>
				                        		<input type="number" name="max_price" id = "max_price" class="add_manage_option" value="0">원
				                        	</td>
				                        	<td>
				                        		<input type="number" name="max_count" class="add_manage_option" value="0">번
				                        	</td>
				                        	<td>
				                        		<input type="number" name="discount_percent" id="discount_percent" class="add_manage_option" value="0">%
				                        	</td>
				                        </tr>                     	
				                        </table><br><br><br>
			                    </div>
                        	</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
 		<footer>
 		</footer>
    </body>
</html>