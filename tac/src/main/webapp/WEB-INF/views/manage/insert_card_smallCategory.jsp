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
    	$('#addSmallName').on('click', function() {
    		var largeId = $('#large_category_selection').val();
    		var smallName = document.getElementById('add_small_category_name').value;
    		$.ajax({
    			type : 'post',
    			url : '/category/smallRegAndgetCategory',
    			data : {
    				smallname : smallName,
    				largeid : largeId
    			},
    			
    			success : function(result) {
    				swal('등록 완료', smallName + '이(가) 추가 되었습니다', 'success');
    				var small = "";
					var small_select = "";
					for (key in result) {
						small += '<tr><td>'+ key +'</td><td>'+ result[key] +'</td></tr>'
						small_select += '<option value='+ key +'>'+ result[key] +'</option>'
					}
					$('#smallTable').html(small);
					$('#small_category_selection').html(small_select);
					document.getElementById('add_small_category_name').value=null;
    		 	}
    		});
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
					var small_select = "";
					for (key in result) {
						small += '<tr><td>'+ key +'</td><td>'+ result[key] +'</td></tr>'
						small_select += '<option value='+ key +'>'+ result[key] +'</option>'
					}
					$('#smallTable').html(small);
					$('#small_category_selection').html(small_select);
				}
			});
    	});
    	
    	$('#deleteSmallName').on('click', function() {
    		const smallNameDel = $('#small_category_selection option:selected').text();
    		const largeId = $('#large_category_selection').val();
    		$.ajax({
    			type:'post',
    			url: '/category/deleteSmallCategory',
    			data : {
    				name : smallNameDel,
    				largeid : largeId
    			},
    			success:function(result) {
    				swal('삭제 완료', smallNameDel + '이(가) 삭제되었습니다', 'success');
    				var small = "";
					var small_select = "";
					for (key in result) {
						small += '<tr><td>'+ key +'</td><td>'+ result[key] +'</td></tr>'
						small_select += '<option value='+ key +'>'+ result[key] +'</option>'
					}
					$('#smallTable').html(small);
					$('#small_category_selection').html(small_select);
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
                    	<b>소분류 추가</b>
                    </div>                
                    <div class="row">
                        <div class="col-sm-5">
	                       	<div class="large_category_list">
	                      		 <b>대분류 선택</b>
	                       	</div>    	
	                             <div class="form-bottom" id="form-box-left">
				                    <select name="large_category" id="large_category_selection" >
				                    	<option value="largeName">==대분류 선택==</option>
										<c:forEach items="${largeCategory}" var="large">
											<option value="${large.largeCategoryId}">${large.largeCategoryName}</option>
										</c:forEach>
									</select>
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
									    <table cellpadding="0" cellspacing="0" border="0" id="smallTable">
									    
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
				                    <!-- <form role="form" action="/category/LargeReg.do" method="post" class="reg_card_detail"> -->
				                    	<b class="inline_text">NAME</b>&nbsp;&nbsp;&nbsp;<input type="text" placeholder="추가할 내용을 입력해주십시오...." name="smallCategoryName", id="add_small_category_name">
				                        <br><br><br>
				                        <button type="submit" class="btn" id="addSmallName">이름 등록</button>
				                    <!-- </form> -->
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
				                    	<select name="small_category" id="small_category_selection" >
											
										</select>
				                        <br><br><br>
				                        <button type="submit" class="btn" id="deleteSmallName">삭제</button>
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