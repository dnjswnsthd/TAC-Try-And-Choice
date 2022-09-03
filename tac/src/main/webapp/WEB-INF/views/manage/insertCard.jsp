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
        <title>관리자 모드 - 카드 등록</title>
        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="/resources/css/insertCard.css" />
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
    	
    	$('.allCard').on('change', function() {
    		$.ajax({
    			type:'post',
    			url:'/category/getLargeCategory',
    			
    			success:function(result) {
    				var large_list = "";
    				var large = "<option value=largeName>==대분류 선택==</option>";
    				for (key in result) {
    					large_list += '<option value=' + key + '>'+ result[key] +'</option>'
    				}
    				$('.large_category_selection').html(large+large_list);
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
    	
    	
    });	
	
    </script>
    
    </head>
    <body>
	<jsp:include page="/resources/component/header.jsp"></jsp:include>
	
		<div id="container" class="container">
	 	<div class="row justify-content-around">
	 		<header>
				<div class="pricing-header p-3 pb-md-4 mx-auto text-center" id="title">
					<h2>카드등록</h2>
				</div>
			</header>
			<div>
				<!-- 카드등록 -->
				<div class="card_information row">
					<div class="card_information">
               		 	<h3><b>카드 등록</b></h3>
                    </div>
                    <hr>
					<!-- 카드사진 -->
					<div class="col-md-5" >
						<form action="#" id="card_image_selection">
		 					
	                       	<div class="form-box text-center cardInfo">
	                        	<div class="form-top">
	                        		<img id="card_sample" src="/resources/image/card_manage/card_sample1.png">
	                            </div>
		                        <input type="file" class="real-upload" accept="image/*" required multiple style="display: none;">
		                        <button type="submit" id="image_selection_left" class="btn btn-outline-secondary">이미지 선택</button> 
	                        </div>            
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

					</div>
					<!-- 카드정보 -->
					<div class="form-bottom col-md-7" id="form-box-left">
						<div class="form-floating mb-3">
						  <input type="text" class="form-username form-control" id="card-name" name="cardName" placeholder="내용을 입력해주세요...">
						  <label for="floatingInput">카드 이름</label>
						</div>
						<div class="form-floating mb-3">
						  <input type="text" class="form-username form-control" id="card-desc" name="cardDesc" placeholder="내용을 입력해주세요...">
						  <label for="floatingInput">카드 설명</label>
						</div>
						<div class="form-floating mb-3">
						  <input type="text" class="form-password form-control" id="max-sale" name="maxDiscount" placeholder="내용을 입력해주세요..." >
						  <label for="floatingInput">최대 할인 금액</label>
						</div>

                        <button type="button" class="btn btn-outline-secondary addBtn" id="cardReg" value="등록">등록</button>

					</div>
				</div>
				<br><br>
				<!-- 카드혜택등록 -->
				<div id="card">
					<div class="form-top" id="saleDetail">
                   		<h3><b>할인 목록 등록</b></h3>
	                </div>
	                <hr>
					<div class="form-top" id="selectCard addSaleDetail">
						<select name="allCard" class="allCard form-select" aria-label="Default select example">
						  <option selected>카드선택</option>
						  <c:forEach items="${showAllCard}" var="card">
								<option value="${card.cardId}">${card.cardName}</option>
							</c:forEach>
						</select>
						<br>
						<div class="input-group">
						  <select name="large_category" class="large_category_selection form-select" id="inputGroupSelect04" aria-label="Default select example">
						    <option selected>대분류를 선택하세요</option>
						  </select>
						  
						</div>
						<br>
						<div class="input-group">
						  <select name="small_category" id="small_category_selection" class="form-select" id="inputGroupSelect04" aria-label="Default select example">
						    <option selected>소분류를 선택하세요</option>
						  </select>
						  
						</div>
						<br>
						<button class="btn addSaleList btn-outline-secondary addBtn" id="cardReg2">할인혜택 추가하기</button>
						<br><br><br>
					
					</div>
					<div>
						<!-- <form role="form" action="cardDetailReg.do" method="post" class="reg_card_detail"> -->
				        <table class="table" id="register_category" style="table-layout:fixed;">
						  <thead>
						    <tr>
						      <th scope="col" class="large_category">대분류</th>
						      <th scope="col" class="small_category">소분류</th>
						      <th scope="col" class="min_amount">최소결제금액</th>
						      <th scope="col" class="max_discount">최대할인금액</th>
						      <th scope="col" class="max_count">최대할인횟수</th>
						      <th scope="col" class="discount_rate">할인율</th>
						      <th></th>
						    </tr>
						  </thead>
						  <tbody>
						    <tr>
						      	<td scope="col" class="large_category">
						      		<input type="text" readonly class="add_manage_option"  name="largeCategoryName" id="largeCategoryName">
                        		</td>
	                        	<td scope="col" class="small_category">
	                        		<input type="text" readonly class="add_manage_option"  name="smallCategoryName" id="smallCategoryName">
	                        	</td>
	                        	<td scope="col" class="min_amount">
	                        		<input type="number" name="min_price" id = "min_price" class="add_manage_option" value="0">
	                        		<label>원</label>
	                        	</td>
	                        	<td scope="col" class="max_discount">
	                        		<input type="number" name="max_price" id = "max_price" class="add_manage_option" value="0">
	                        		<label>원</label>
	                        	</td>
	                        	<td scope="col" class="max_count">
	                        		<input type="number" name="max_count" class="add_manage_option" value="0">
	                        		<label>번</label>
	                        	</td>
	                        	<td scope="col" class="discount_rate">
	                        		<input type="number" name="discount_percent" id="discount_percent" class="add_manage_option" value="0">
	                        		<label>%</label>
	                        	</td>
						    </tr>
						  </tbody>
						</table>
						      	
                        <button class="btn btn-outline-secondary addBtn cardReg3" id="register_card_detail">등록</button>
					</div>
				</div>
			</div>
	 	</div>
	 </div>
	 
    </body>
</html>