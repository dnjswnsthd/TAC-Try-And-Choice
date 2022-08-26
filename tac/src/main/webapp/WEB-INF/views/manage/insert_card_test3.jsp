<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap Login &amp; Register Templates</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <!-- <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">-->
        <link rel="stylesheet" href="resources/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="resources/css/manage_test_form-elements3.css">
        <link rel="stylesheet" href="resources/css/manage_test_style3.css"> 
		
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
		
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    <script type="text/javascript">
    $(function(){
    	
    	var table_header = '<tr><th>대분류</th><th>소분류</th><th>최소결제금액</th><th>최대할인금액</th><th>최대할인횟수</th><th>할인율</th><th></th></tr>';
    	var add_tablelist = '<td><select name=large_category><option value=movie>영화</option><option value=oil>주유</option><option value=cafe>카페</option></select></td>'
    	+ '<td><select name=small_category class=small_category_selection><option value=cgv>CGV</option><option value=lottecinema>롯데시네마</option><option value=megabox>메가박스</option></select></td>'
    	+ '<td><input type=text name=min_price class=add_manage_option>원</td><td><input type=text name=max_price class=add_manage_option>원</td>'
    	+ '<td><input type=text name=sale_max_count class=add_manage_option>번</td><td><input type=text name=discount_rate class=add_manage_option>%</td>'
    	+ '<td><img id="delete_img" src=/resources/image/delete.png></td>';
    	
    	$('#add_categoty').on('click', function() {
    		var data = $('#register_category').html();
    		data += add_tablelist;
    		
    		$('#register_category').html(data);
    		
    	/* 	$('#test_table').html(data); */
    	});// on click
    	
    	/* $('#delete_img').on('click', function() {
    		var data = $('#register_category').html();
    		data = data + table_header - add_tablelist;
    		
    		$('#register_category').html(data);
    	})  */
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
                    	<b>카드등록</b>
                    </div>                
                    <div class="row">
                        <div class="col-sm-5">
                        	<form action="#" id="card_image_selection">
                        	<div class="form-box">
	                        	<div class="form-top">
	                        		<img id="card_sample" src="/resources/image/card/card_sample1.png">
	                        		<img id="card_sample" src="/resources/image/card/card_sample1.png">
	                            </div>
	                        <input type="file" class="real-upload" accept="image/*" required multiple style="display: none;">
	                        <button type="submit" id="image_selection_left" class="btn btn-default">이미지 선택</button>
	                        <input type="file" class="real-upload" accept="image/*" required multiple style="display: none;">
	                        <button type="submit" id="image_selection_right" class="btn btn-default">이미지 선택</button>
	                        </form> 
	                       
	                       <div class="card_information">
	                      		 <b>카드 정보</b>
	                       </div>    	
	                             <div class="form-bottom" id="form-box-left">
				                    <form role="form" action="" method="post" class="login-form">
				                    	<div class="form-group">
				                    		<label class="sr-only" for="form-username"></label>
				                        	<b class="inline_text">카드 이름</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="card-name" placeholder="내용을 입력해주세요..." class="form-username form-control" id="card-name">
				                        </div>
				                    	<div class="form-group">
				                    		<label class="sr-only" for="form-username"></label>
				                        	<b class="inline_text">카드 설명</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="card-desc" placeholder="내용을 입력해주세요..." class="form-username form-control" id="card-desc">
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-password"></label>
				                        	<b class="inline_text">최대 할인 금액</b>&nbsp;&nbsp;&nbsp;<input type="text" name="max-sale" placeholder="내용을 입력해주세요..." class="form-password form-control" id="max-sale">
				                        </div>
				                    </form>
			                    </div>
		                    </div>     
                        </div>
                        
                        	
                        <div class="col-sm-7">
                        	
                        	<div class="form-box" id="form-box-right">
                        		<div class="form-top" id="sale_detail">
	                        		<div class="form-top-left">
	                        			<h3><b>할인 상세</b></h3>
	                        		</div>
	                        		<div class="form-top-right">
	                        			<button class="btn" id="add_categoty">추가</button>
	                        		</div>
	                            </div>
	                            <div class="form-bottom">
				                    <form role="form" action="#" method="post" class="registration-form">
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
				                        	<td><select name="large_category">
				                        		<option value="movie">영화</option>
				                        		<option value="oil">주유</option>
				                        		<option value="cafe">카페</option>
				                        		</select>
				                        	</td>
				                        	<td><select name="small_category" class="small_category_selection">
				                        		<option value="cgv">CGV</option>
				                        		<option value="lottecinema">롯데시네마</option>
				                        		<option value="megabox">메가박스</option>
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
				                        <table id="test_table">
				                        </table>
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

        <!-- Javascript -->
        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>