$(document).ready(function(){
	
	$('.element-card').on('click', function(){
		
		if ( $(this).hasClass('open') ) {
			$(this).removeClass('open');
		} else {
			$('.element-card').removeClass('open');
			$(this).addClass('open');
		}
		
	});
	
	/*$('#selectCard').on('click',function(){
		alert($(this).attr('name'));
		 cardId = $(this).attr('name');
		 $(this).parent().parent().parent().css('border', '3px solid red');
	 });*/
	
	$(document).on('click', '#selectCard', function(){
		 $('#cardId').val($(this).attr('name'));
		 $('.element-card').css('border', 'none');
		 $(this).parent().parent().parent().css('border', '3px solid red');
	 });
	
	$('#memberId').keyup(function(){
		var id = $(this).val();
		if(id.length < 10 || !id.includes("@")){
			$('#check').html('아이디는 10자리 이상 이메일 형식으로 입력해주세요.').css('color', 'red');
			$('#submitBtn').attr('disabled', true);
		}else{
			$.ajax({
				type: 'post',
				url: '/chkDup',
				data: "id="+id,
				success:function(result){
					if(result=='true'){
						$('#check').html('이미 사용중인 아이디!!').css('color', 'red');
						$('#submitBtn').attr('disabled', true);
					}else{
						$('#check').html('사용 가능 아이디!!').css('color', 'blue');
						$('#submitBtn').attr('disabled', false);
					}
				}//success
			}); //ajax
		}
	});
	
	$('#phone').keyup(function(){
		$(this).val( $(this).val().replace(/[^0-9]/g, "").replace(/(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,"$1-$2-$3").replace("--", "-") );
	});
	
	$('#password').keyup(function(){
		/*var reg =  new RegExp("^(?=.*[0-9])(?=.*[a-zA-z]).{8,15}$");*/
		var reg =  new RegExp("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^*+=-]).{6,16}$");
		
		var password = $(this).val();
		
		if(!reg.test(password)){
			$('#checkPass').html('8자리 이상의 대소문자, 숫자, 특수문자 조합를 조합해주세요!!').css('color', 'red');
		}else{
			$('#checkPass').html('조건에 맞는 비밀번호 입니다.').css('color', 'blue');
		}
	});
	
	$('#passwordChk').keyup(function(){
		if($(this).val() != $("#password").val()){
			$('#checkPassCol').html('Password가 일치하지않습니다.').css('color', 'red');
		}else{
			$('#checkPassCol').html('Password가 일치합니다.').css('color', 'blue');
		}
	});
	
});