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
		<link rel="stylesheet" href="/resources/css/insertCardElement.css">
        <link rel="stylesheet" href="/resources/css/insertCardStyle.css"> 
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script type="text/javascript">
    $(function(){
    	$('#addLargeName').on('click', function() {
    		const largeName = document.getElementById('add_large_category_name').value;
    		$.ajax({
    			type : 'post',
    			url : '/category/LargeRegAndgetCategory',
    			data : {
    				name : largeName
    			},
    			success:function(result) {
    				swal('등록 완료', largeName + '이(가) 추가 되었습니다', 'success')
    				var large="";
    				var large_select="";
    				for (key in result) {
    					large += '<tr><td>'+ key +'</td><td>'+ result[key] +'</td></tr>'
    					large_select += '<option value='+ key +'>'+ result[key] +'</option>'
    				}
    				$('#largeTable').html(large);
    				$('#large_category_selection').html(large_select);
    				document.getElementById('add_large_category_name').value=null;
    			}
    		});
    	});
    	
    	$('#deleteLargeName').on('click', function() {
    		const largeNameDel = $('#large_category_selection option:selected').text();
    		$.ajax({
    			type:'post',
    			url: '/category/deleteLargeCategory',
    			data : {
    				name : largeNameDel
    			},
    			success:function(result) {
    				swal('삭제 완료', largeNameDel + '이(가) 삭제되었습니다', 'success');
    				var large="";
    				var large_select="";
    				for (key in result) {
    					large = large + '<tr><td>'+ key +'</td><td>'+ result[key] +'</td></tr>'
    					large_select += '<option value='+ key +'>'+ result[key] +'</option>'
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
    	
        <!-- Top content -->
        <div class="top-content">
            <!-- <div class="inner-bg"> -->
                <div class="container">
                    <div class="card_register">
                    	<b>대분류 추가</b>
                    </div>                
                    <div class="row">
                        <div class="col-sm-5">
	                       	<div class="large_category_list">
	                      		 <b>대분류</b>
	                       	</div>    	
	                             <div class="form-bottom" id="form-box-left">
				                    <div class="tbl-header">
										<table cellpadding="0" cellspacing="0" border="0">
									    	<thead>
										        <tr>
						                    		<th><b>ID</b></th>
						                    		<th><b>NAME</b></th>
					                    		</tr>
									      	</thead>
									    </table>
									</div>
									<div class="tbl-content">
									    <table cellpadding="0" cellspacing="0" border="0" id="largeTable">
								        		<c:forEach items="${largeCategory}" var="large">
					                    			<tr>
														<td>${large.largeCategoryId}</td>
														<td>${large.largeCategoryName}</td>
													</tr>
												</c:forEach>
									    </table>
									</div>
			                    </div>
		                    </div>     
                        	
                        <div class="col-sm-7">
                        	<div class="form-box" id="form-box-right">
                        		<div class="form-top" id="sale_detail">
	                        		<li>
	                        			<h3><b>추가</b></h3>
	                        		</li>
	                        		<li id="goManage">
	                        			<button class="btn"><a href="manage_card">관리자 페이지 이동</a></button>
	                        		</li>
	                            </div>
	                            <div class="form-bottom">
			                    	<b class="inline_text">NAME</b>&nbsp;&nbsp;&nbsp;<input type="text" placeholder="추가할 내용을 입력해주십시오...." name="largeCategoryName", id="add_large_category_name">
			                        <br><br><br>
			                        <button type="submit" class="btn" id="addLargeName">등록</button>
			                    </div>
                        	</div>
                        	
                        	<div class="form-box" id="form-box-right-bottom">
                        		<div class="form-top" id="sale_detail">
	                        		<li>
	                        			<h3><b>삭제</b></h3>
	                        		</li>
	                            </div>
	                            <div class="form-bottom">
				                    <!-- <form role="form" action="/category/LargeReg.do" method="post" class="reg_card_detail"> -->
				                    	<select name="large_category" id="large_category_selection" >
											<c:forEach items="${largeCategory}" var="large">
												<option value="${large.largeCategoryId}">${large.largeCategoryName}</option>
											</c:forEach>
										</select>
				                        <br><br><br>
				                        <button type="submit" class="btn" id="deleteLargeName">삭제</button>
				                    <!-- </form> -->
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