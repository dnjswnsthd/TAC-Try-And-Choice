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
        <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="resources/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="resources/css/manage_test_form-elements2.css">
        <link rel="stylesheet" href="resources/css/manage_test_style2.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
    	<%-- <div class="tac_header">
    		<jsp:include page="/resources/component/header.jsp"></jsp:include>
    	</div> --%>
        <!-- Top content -->
        <div class="top-content">
            <div class="inner-bg">
                <div class="container">
                    <div>
                    <header>
                    <h2>tac</h2>
                    </header>
                    </div>
                    <div class="card_register">
                    	<b>카드등록</b>
                    </div>                
                    <div class="row">
                        <div class="col-sm-4">
                        	<form action="#" id="card_image_selection">
                        	<div class="form-box">
	                        	<div class="form-top">
	                        		<img id="card_sample" src="/resources/image/card/card_sample1.png">
	                        		<br><br><br>
	                        		<img id="card_sample" src="/resources/image/card/card_sample1.png">
	                            </div>
	                        <button type="submit" id="image_selection_left" class="btn btn-default">이미지 선택</button>
	                        <button type="submit" id="image_selection_right" class="btn btn-default">이미지 선택</button>
	                        </form> 
	                       
	                         	
	                             <div class="form-bottom" id="form-box-left">
				                    <!-- <form role="form" action="" method="post" class="login-form">
				                    	<div class="form-group">
				                    		<label class="sr-only" for="form-username"></label>
				                        	<b>카드 이름</b><input type="text" name="card-name" placeholder="내용을 입력해주세요..." class="form-username form-control" id="card-name">
				                        </div>
				                    	<div class="form-group">
				                    		<label class="sr-only" for="form-username"></label>
				                        	<b>카드 설명</b><input type="text" name="card-desc" placeholder="내용을 입력해주세요..." class="form-username form-control" id="card-desc">
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-password"></label>
				                        	<b>최대 할인 금액</b><input type="password" name="max-sale" placeholder="내용을 입력해주세요..." class="form-password form-control" id="max-sale">
				                        </div>
				                        <button type="submit" class="btn">Sign in!</button>
				                    </form> -->
			                    </div>
		                    </div>
		                
		                	<!-- <div class="social-login">
	                        	<h3>...or login with:</h3>
	                        	<div class="social-login-buttons">
		                        	<a class="btn btn-link-1 btn-link-1-facebook" href="#">
		                        		<i class="fa fa-facebook"></i> Facebook
		                        	</a>
		                        	<a class="btn btn-link-1 btn-link-1-twitter" href="#">
		                        		<i class="fa fa-twitter"></i> Twitter
		                        	</a>
		                        	<a class="btn btn-link-1 btn-link-1-google-plus" href="#">
		                        		<i class="fa fa-google-plus"></i> Google Plus
		                        	</a>
	                        	</div>
	                        </div> -->
	                        
                        </div>
                        
                        <!-- <div class="col-sm-1 middle-border"></div> -->
                        	
                        <div class="col-sm-8">
	                       <div class="card_information">
	                      		 <b>카드 정보</b>
	                       </div>    	
	                             <div class="form-bottom" id="form-box-left">
				                    <form role="form" action="" method="post" class="login-form">
				                    	<div class="form-group">
				                    		<label class="sr-only" for="form-username"></label>
				                        	<b>카드 이름</b><input type="text" name="card-name" placeholder="내용을 입력해주세요..." class="form-username form-control" id="card-name">
				                        </div>
				                    	<div class="form-group">
				                    		<label class="sr-only" for="form-username"></label>
				                        	<b>카드 설명</b><input type="text" name="card-desc" placeholder="내용을 입력해주세요..." class="form-username form-control" id="card-desc">
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-password"></label>
				                        	<b>최대 할인 금액</b><input type="password" name="max-sale" placeholder="내용을 입력해주세요..." class="form-password form-control" id="max-sale">
				                        </div>
				                        <!-- <button type="submit" class="btn">Sign in!</button> -->
				                    </form>
				                </div>
                        	<div class="form-box" id="form-box-right2">
                        		<div class="form-top">
	                        		<div class="form-top-left">
	                        			<h3><b>할인 상세</b></h3>
	                        		</div>
	                        		<div class="form-top-right">
	                        			<button class="btn" id="add_categoty">추가</button>
	                        		</div>
	                            </div>
	                            <div class="form-bottom">
				                    <form role="form" action="#" method="post" class="registration-form">
				                        <table>
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
				                        </tr>				                        	
				                        </table>
				                        <button type="submit" class="btn" id="register_card_info">등록</button>
				                    </form>
			                    </div>
                        	</div>
                        	
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Footer -->
       <!--  <footer>
        	<div class="container">
        		
        	</div>
        </footer> -->

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