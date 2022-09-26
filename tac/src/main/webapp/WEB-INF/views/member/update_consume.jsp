<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link href='resources/js/calendar/main.css' rel='stylesheet' />
<!-- <link href='resources/css/member/icons.css' rel='stylesheet' /> -->
<script src='/resources/js/loadingoverlay.min.js'></script>
<script src='resources/js/calendar/main.js'></script>
<link href="/resources/css/member/common/consume.css" rel="stylesheet" />
<script>
	$(function(){
		$('#large').change(
				function() {
					$.ajax({
						type : 'post',
						url : '/category/getSmallCategory',
						data : {
							id : $(this).val()
						},

						success : function(result) {
							$('#small').empty();
							for (key in result) {
								$('#small').append(
										'<option value="' + key + '">'
												+ result[key] + '</option>');
							}
						}
					})
				});
		$('.excelModalOpen').click(
				function(){
					/*$.ajax({
						type : 'get',
						url : '/testPython',
						data : {},
						success :function(result){
							alert(result);
						}
					}) */
				$('.excel_modal').fadeIn();
		});
		 $('#excel_close').click(
				 function(){
					 $('.excel_modal').fadeOut();
					 location.reload();
				 })
	});
	function doExcelUploadProcess(){
        var form = new FormData(document.getElementById('form1'));
        $.LoadingOverlay("show", {
        	background       : "rgba(0, 0, 0, 0.8)",
        	image            : "/resources/image/job/loading.gif",
        	maxSize          : 60,
        });
        $.ajax({
            url: "/consume/uploadExcelFile",
            dataType: "json", 
            data: form,
            processData: false,
            contentType: false,
            type: "POST",
            success: function(data){
                var htmlValue;
                htmlValue += "<thead>";
                htmlValue += "<tr>";
                htmlValue += "<td>결제일</td>";
                htmlValue += "<td>카테고리</td>";
                htmlValue += "<td>금액</td>";
                htmlValue += "</tr>";
				htmlValue += "</thead>";
				
                 for (var i = 0; i < data.length; i++) {
                	/* user_id.push(data[i].user_id);
                	user_name.push(data[i].user_name);
    				expire.push(data[i].expire);
    				deptname.push(data[i].deptname);
    				phone.push(data[i].phone);
    				email.push(data[i].email);
    				desc.push(data[i].desc);
    				office_code.push(data[i].office_code); */
                	htmlValue += "<tr>";
                    htmlValue += "<td>"+data[i].consumeDate+"</td>";
                    htmlValue += "<td>"+data[i].largeCategoryName+"</td>";
                    htmlValue += "<td>"+data[i].consumePrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')+"</td>";
                    htmlValue += "</tr>";
				}

                $("#consumeDate").html(htmlValue)
                
            },
            complete: function(){
            	setTimeout(function(){
            	    $.LoadingOverlay("hide");
            	}, 5000);
            },
            error: function(xhr, status, error){
                console.log("xhr:"+xhr+", status:"+ status + ", error:"+error);
            }

        })
    }
	document.addEventListener('DOMContentLoaded', function() {
	    var calendarEl = document.getElementById('calendar');
	    var calendar = new FullCalendar.Calendar(calendarEl, {
	      headerToolbar: {
	        left: 'title',
	        center: '',
	        right: 'prev,next'
	      },
	      /* initialDate: '2021-04-12', // 초기 로딩 날짜. */
	      navLinks: true, 
	      selectable: true,
	      allDaySlot: false,
	      /* selectMirror: true, */
	      timeZone: 'Asia/Seoul',
	      select : function(arg) {
				$('.modal').fadeIn();
				$('#close').click(function() {
					$('.modal').fadeOut();
				});
				$('#addConsume').click(function() {
					if(arg.start != '0'){
						var title = $("select[name=large] option:selected").text();
						$.ajax({
							type : 'post',
							url : '/consume/register',
							data : {
								largeCategoryId : $('#large').val(),
								smallCategoryId : $('#small').val(),
								price : $('#price').val(),
								memberId : $('#member').val(),
								consumeDate : arg.start.toISOString().slice(0,10)
							},
							success : function(result) {
								$('.modal').fadeOut();
								calendar.refetchEvents(calendar.unselect());
								arg.start = '0';
							},
							complete:function(){
								$('#large').val('대분류');
								$('#small').val('소분류');
								$('#price').val('0');
							}						
						});
					}
				});
				calendar.unselect()
			},
			eventDrop: function(info){
				  $.ajax({
						type : 'put',
						url : '/consume/update',
						data : {
							consumeId: info.oldEvent.groupId,
							consumeDate: info.event.start.toISOString().slice(0,10)
						},
						success : function(result) {
						},						
					});
			  },
	      eventClick: function(arg) {
	    	  // 있는 일정 클릭시,
	    	 swal({
			      title: "Warning",
			      text: "소비정보를 삭제하시겠습니까?",
			      icon: "warning",
			      buttons: [
			        '취소',
			        '삭제'
			      ],
			      dangerMode: true,
			 }).then(function(isConfirm){
				 if (isConfirm) {
		        	$.ajax({
						type : 'delete',
						url : '/consume/deleteConsume',
						data : {
							consumeId: arg.el.fcSeg.eventRange.def.groupId 
						},
						success : function(result) {
							calendar.refetchEvents();
						},
					});
		        	arg.event.remove()
		        }
			 })
	      },
	      editable: true,
	      dayMaxEvents: true, // allow "more" link when too many events
	      events: function(info, successCallback, failureCallback){
	    	  $.ajax({
			        type: 'POST'
			        ,cache: false
			        ,url: '/consume/getConsume'
			        ,dataType: 'json'
		        	,data : {
						memberId : $('#member').val(),
					}
			        ,contentType : "application/x-www-form-urlencoded; charset=UTF-8"
			        ,success: function(param){
			            var events = [];
			            
			            $.each(param, function (index, data){
			            	var color = 'white';
			            	var bgcolor = '';
			            	if(data.LARGECATEGORYID == '1' || data.LARGECATEGORYID == '5' || data.LARGECATEGORYID == '9' || data.LARGECATEGORYID == '13' || data.LARGECATEGORYID == '17' ){
			            		bgcolor = '#FBC22C'
			            	}else if(data.LARGECATEGORYID == '2' || data.LARGECATEGORYID == '6' || data.LARGECATEGORYID == '10' || data.LARGECATEGORYID == '14' || data.LARGECATEGORYID == '18' ){
			            		bgcolor = '#F01486'
			            	}else if(data.LARGECATEGORYID == '3' || data.LARGECATEGORYID == '7' || data.LARGECATEGORYID == '11' || data.LARGECATEGORYID == '15' || data.LARGECATEGORYID == '19' ){
			            		bgcolor = '#A067AD'
			            	}else if(data.LARGECATEGORYID == '4' || data.LARGECATEGORYID == '8' || data.LARGECATEGORYID == '12' || data.LARGECATEGORYID == '16' || data.LARGECATEGORYID == '20' ){
			            		bgcolor = '#46A3D2'
			            	}else if(data.LARGECATEGORYID == '21' || data.LARGECATEGORYID == '22'){
			            		bgcolor = '#8CE33D'
			            	}else{
			            		bgcolor = "#FF788B"
			            	}
		                    events.push({
		                        title : data.LARGECATEGORYNAME + '	|	' + data.CONSUMEPRICE.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',') + '원' 
		                        ,start : data.CONSUMEDATE
		                        ,allDay: true
		                        ,className: 'important'
		                        ,groupId: data.CONSUMEID
		                        ,laregeCategoryId: data.LARGECATEGORYID
		                        ,smallCategoryId: data.SMALLCATEGORYID
		                        ,smallCategoryName: data.SMALLCATEGORYNAME
		                        ,consumePrice: data.CONSUMEPRICE
		                        ,backgroundColor: bgcolor
		                        ,color : color
		                    }); // push // end
			            });// each end
			            successCallback(events);
			        }
			    });// ajax end
	      }
	  });
	
	    calendar.render();
	  });
</script>
<style>
body {
	margin: 40px 10px;
	padding: 0;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 1100px;
	margin: 0 auto;
}
</style>
</head>
<body>
	<jsp:include page="/resources/component/header.jsp"></jsp:include>
	<div class="container">
		<input type="hidden" id="member" value="${memberId}" />
		<div id="hea2">
			<h3> ${memberName} 님 소비 정보를 수정하세요!</h3>
			<button class="excelModalOpen" type="button"><span>엑셀 파일로 등록</span></button>
		</div>
		<div id="wrap">
			<div id="calendar"></div>
			<div style="clear: both"></div>
		</div>
		<br><br>
	</div>
	<div class="modal">
		<div class="modal_content" title="">
			<form action="#" id='Frm'>
				<h1>소비 등록</h1>
				<h3 id='span'>대분류</h3>
				<select class="selec" name="large" id="large">
					<option value="0">대분류</option>
					<c:forEach var="item" items="${list}">
						<option value="${item.largeCategoryId}"
							title="${item.largeCategoryName}">${item.largeCategoryName}</option>
					</c:forEach>
				</select> <br>
				<h3 id='span'>소분류</h3>
				<select class="selec" name="small" id="small">
					<option value="0">소분류</option>
				</select> <br>
				<h3 id='span'>금액</h3>
				<input type="number" id="price" name="price" value="0" /> <br>
				<input id="addConsume" class="btn" type="button" value="Append" />
				<input class="btn" id="close" type="button" value="close" />
			</form>
		</div>
	</div>
	<div class="excel_modal">
		<div class="excel_modal_content">
			<form id="form1" name="form1" method="post" enctype="multipart/form-data">
				<input type="file" id="fileInput" name="fileInput">
				<button class="excelBtn" type="button" onclick="doExcelUploadProcess()"><span>엑셀 파일로 등록</span></button>
				<input type="hidden" id="member" name="member" value="${memberId}" />
				<button id="excel_close" type="button"><span>등록 완료</span></button>
			</form>
			<table id="consumeDate">
			</table>
		</div>
	</div>
</body>
</html>
