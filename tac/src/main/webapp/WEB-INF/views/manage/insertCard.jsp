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
		<link rel="stylesheet" href="../resources/css/insertCardElement.css">
        <link rel="stylesheet" href="../resources/css/insertCardStyle.css"> 
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript">
    $(function(){
    	
    	var table_header = '<tr><th>대분류</th><th>소분류</th><th>최소결제금액</th><th>최대할인금액</th><th>최대할인횟수</th><th>할인율</th><th></th></tr>';
    	var add_tablelist = '<td><select name=large_category><option value=movie>영화</option><option value=oil>주유</option><option value=cafe>카페</option></select></td>'
    	+ '<td><select name=small_category class=small_category_selection><option value=cgv>CGV</option><option value=lottecinema>롯데시네마</option><option value=megabox>메가박스</option></select></td>'
    	+ '<td><input type=text name=min_price class=add_manage_option>원</td><td><input type=text name=max_price class=add_manage_option>원</td>'
    	+ '<td><input type=text name=sale_max_count class=add_manage_option>번</td><td><input type=text name=discount_rate class=add_manage_option>%</td>'
    	+ '<td><img id="delete_img" src=/resources/image/delete.png></td>';
    	
    	$('.add_categoty').on('click', function() {
    		var data = $('#register_category').html();
    		data += add_tablelist;
    		
    		$('#register_category').html(data);
    		
    	});// on click
    	
    	$('#register_card_info').on('click', function() {
    		alert("동록 진행중~!");
    	});
    	
    	$('#large_category_search').on('click', function() {
    		alert("헐");
    	});
    	
    		
    	$('#large_category_selection').change(function() {
    		$.ajax({
				type : 'post',
				url : '/category/getSmallCategory',
				data : {
					id : $(this).val()
				},

				success : function(result) {
					var small = "";
					for (key in result) {
						small = small + '<option value=' + key + '>'+ result[key] +'</option>'
					}
					$('#small_category_selection').html(small);
				}
			});
    	});
    	
    	
    });	
/*     function f_changeFunc(obj) {
		var id = $(obj).val();
		var small = '<td><select name="small_category" class="small_category_selection">'
		+ '<option value="cgv">일</option>'
		+ '<option value="lottecinema">이</option>'
		+ '<option value="megabox">삼</option>'
		+ '</select></td>'
	
		$('#small_category').html(small);
		
	} */
    </script>
    </head>
    <body>
	<jsp:include page="/resources/component/header.jsp"></jsp:include>
    	
        <!-- Top content -->
        <div class="top-content">
            <!-- <div class="inner-bg"> -->
                <div class="container">
                    <div class="card_register">
                    	<b>카드등록</b>
                    </div>                
                    <div class="row">
                        <div class="col-sm-5">
                        	<form action="#" id="card_image_selection">
                        	<div class="form-box">
	                        	<div class="form-top">
	                        		<img id="card_sample" src="/resources/image/card_manage/card_sample1.png">
	                        		<img id="card_sample" src="/resources/image/card_manage/card_sample1.png">
	                            </div>
	                        <input type="file" class="real-upload" accept="image/*" required multiple style="display: none;">
	                        <button type="submit" id="image_selection_left" class="btn btn-default">이미지 선택(앞)</button>
	                        <input type="file" class="real-upload" accept="image/*" required multiple style="display: none;">
	                        <button type="submit" id="image_selection_right" class="btn btn-default">이미지 선택(뒤)</button>
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
	                      		 <b>카드 정보</b>
	                       	</div>    	
	                             <div class="form-bottom" id="form-box-left">
				                    <form role="form" action="cardReg.do" method="post" class="reg_card">
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
				                        <button type="submit" class="btn" id="cardReg" value="등록">등록</button>
				                    </form>
			                    </div>
		                    </div>     
                        </div>
                        
                        	
                        <div class="col-sm-7">
                        	
                        	<div class="form-box" id="form-box-right">
                        		<div class="form-top" id="sale_detail">
	                        		<li>
	                        			<h3><b>할인 상세</b></h3>
	                        		</li>
									<li class="add_button">
	                        			<button class="add_categoty_large"><a href="addLargeCategory">대분류 추가</a></button>
	                        		</li>
	                        		<li class="add_button">
	                        			<button class="add_categoty_small"><a href="#">소분류 추가</a></button>
	                        		</li>	
	                        		<li class="add_button">
	                        			<button class="add_categoty">카테고리 추가</button>
	                        		</li>
	                            </div>
	                            <div class="form-bottom">
				                    <form role="form" action="cardDetailReg.do" method="post" class="reg_card_detail">
				                    	
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
												<select name="large_category" id="large_category_selection" >
													<c:forEach items="${largeCategory}" var="large">
														<option value="${large.largeCategoryId}">${large.largeCategoryName}</option>
													</c:forEach>
												</select>
				                        	</td>
				                        	<td>
				                        		<select name="small_category" id="small_category_selection">
					                        		<option value="small">소분류</option>
				                        		</select>
				                        	</td>
				                        	<td>
				                        		<input type="text" name="min_price" class="add_manage_option">원
				                        	</td>
				                        	<td>
				                        		<input type="text" name="max_price" class="add_manage_option">원
				                        	</td>
				                        	<td>
				                        		<input type="text" name="sale_max_count" class="add_manage_option">번
				                        	</td>
				                        	<td>
				                        		<input type="text" name="discount_rate" class="add_manage_option">%
				                        	</td>
				                        	<td>
				                        		<img id="delete_img" src="/resources/image/delete.png">
				                        	</td>
				                        </tr>                     	
				                        </table><br><br><br><br><br><br><br>
				                        <button type="submit" class="btn" id="register_card_info">등록</button>
				                    </form>
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