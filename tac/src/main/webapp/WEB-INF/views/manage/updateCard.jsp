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
    	
    	$('.addSaleList').on('click', function() {
    		var largeName = $('.large_category_selection option:selected').text();
    		var smallName = $('#small_category_selection option:selected').text();
    		var largeId = $('.large_category_selection option:selected').val();
    		var smallId = $('#small_category_selection option:selected').val();
			var cardId = $('.allCard option:selected').val();
			
    		$('input[name=largeCategoryName]').val(largeName);
    		$('input[name=smallCategoryName]').val(smallName);
    		$('input[name=largeCategoryName]').attr("id", largeId);
    		$('input[name=smallCategoryName]').attr("id", smallId);
    		
    	});
    	
		$('#register_card_detail').on('click', function() {
    		var cardId = $('.allCard option:selected').val();
    		var largeId = $('input[name=largeCategoryName]').attr("id");
    		var smallId = $('input[name=smallCategoryName]').attr("id");
    		var minPrice = $('input[name=min_price]').val();
    		var maxPrice = $('input[name=max_price]').val();
    		var maxCount = $('input[name=max_count]').val();
    		var discountPercent = $('input[name=discount_percent]').val();
    		var message = "";
    		if($('#discount_percent').val() == 0){
    			message = "할인율"
    		}
    		if(message != ""){
    			swal(message + "은(는) 필수값입니다.", '', 'error');
    			evt.preventDefault();	
    		}else{
	    		$.ajax({
	    			type:'post',
	    			url:'/category/registerCardDetail',
	    			data : {
	    				discountpercent : discountPercent,
	    				cardid : cardId,
	    				largeid : largeId,
	    				smallid : smallId,
	    				minprice : minPrice,
	    				maxprice : maxPrice,
	    				maxcount : maxCount,
	    			},
	    			success:function(result){
	    				swal('등록 완료', '새로운 목록이 추가 되었습니다', 'success');
	    				var card = "";
						var card_default = '<option value=smallName>==카드 선택==</option>';
						for (key in result) {
							card += '<option value=' + key + '>'+ result[key] +'</option>'
						}
						$('.allCard').html(card_default+card);
						$('.large_category_selection').html('<option value=largeName>대분류</option>');
						$('#small_category_selection').html('<option value=smallName>소분류</option>');
						$('input[name=largeCategoryName]').val("");
			    		$('input[name=smallCategoryName]').val("");
						$('input[name=min_price]').val(0);
			    		$('input[name=max_price]').val(0);
			    		$('input[name=max_count]').val(0);
			    		$('input[name=discount_percent]').val(0);
	    			}
	    		});
    		}
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
					var small_default = '<option value=smallName>==소분류 선택==</option>';
					for (key in result) {
						small = small + '<option value=' + key + '>'+ result[key] +'</option>'
					}
					$('#small_category_selection').html(small_default + small);
				}
			});
    	});
    	
    	$('#cardReg').on('click', function() {
    		var cardName = $('#card-name').val();
    		var cardDesc = $('#card-desc').val();
    		var maxSale = $('#max-sale').val();
    		var message = "";
    		
    		if($('#card-name').val() == ''){
    			message = "카드 이름"
    		} else if($('#card-desc').val() == ''){
    			message = "카드 설명"
    		}
    		if(message != ""){
    			swal(message + "은 필수값입니다.", '', 'error');
    			evt.preventDefault();
    		}else {
	    		$.ajax({
	    			type:'post',
	    			url:'/cardReg',
	    			data : {
	    				cardname : cardName,
	    				carddesc : cardDesc,
	    				maxsale : maxSale
	    			},
	    			success:function(result){
	    				swal("카드 등록 완료", cardName + " 카드가 등록되었습니다!", 'success');
	    				var card = "";
						var card_default = '<option value=smallName>==카드 선택==</option>';
						for (key in result) {
							card += '<option value=' + key + '>'+ result[key] +'</option>'
						}
						$('.allCard').html(card_default+card);
						$('#card-name').val("");
			    		$('#card-desc').val("");
			    		$('#max-sale').val("");
	    			}
	    		});
    		}
    	});
    	
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
    					table_list = table_list + '<tr><td><input type="text" name="largeCategoryName" id="largeCategoryName" class="add_manage_option" value='+ result[key].largeCategoryName +'></td>'
                					+ '<td><input type="text" name="smallCategoryName" class="add_manage_option" value='+ result[key].smallCategoryName +'></td>'
                					+ '<td><input type="text" name="min_price" id = "min_price" class="add_manage_option" value='+ result[key].minPayment +'>원</td>'
                					+ '<td><input type="text" name="max_price" id = "max_price" class="add_manage_option" value='+ result[key].maxDiscount +'>원</td>'
                					+ '<td><input type="text" name="max_count" class="add_manage_option" value='+ result[key].maxCount +'>번</td>'
                					+ '<td><input type="text" name="discount_percent" id="discount_percent" class="add_manage_option" value='+ result[key].discountPercent +'>%</td>'
                					+ '<td><img id = "deleteList" src="/resources/image/card_manage/delete.png"></td>'
                					+ '<td><img id = "updateList" src="/resources/image/card_manage/update.png"></td></tr>'

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
    				alert(result.cardName+','+result.cardDesc+','+result.maxDiscount);
    				$("#card_sample").attr("src", "/resources/image/card_horizon/"+ result.cardImgHorizon);
    				$('input[name=cardName]').val(result.cardName);
    				$('input[name=cardDesc]').val(result.cardDesc);
    				$('input[name=maxDiscount]').val(result.maxDiscount);
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
							    const upload_back_image = document.querySelector('#image_selection_right');
							
							    upload_front_image.addEventListener('click', () => realUpload.click());
							    realUpload.addEventListener('change', getImageFiles);
							    
							    upload_back_image.addEventListener('click', () => realUpload.click());
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
				                        <button class="btn" id="register_card_detail">수정</button>
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