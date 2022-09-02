$(document).ready(function () {
  $('.element-card').on('click', function () {
    if ($(this).hasClass('open')) {
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

  $(document).on('click', '#selectCard', function () {
    $('#cardId').val($(this).attr('name'));
    $('#cardId2').val($(this).attr('name'));
    $('.element-card').css('border', 'none');
    $(this)
      .parent()
      .parent()
      .parent()
      .css('border', '5px solid red')
      .css('border-radius', '12px');
  });
  
  $("#modifyBtn").click(function(evt){
		var message = "";
		if($("#name").val() == ""){
			message = "이름"
		}else if($("#age").val() == ""){
			message = "나이"
		}else if($("#memberId").val() == ""){
			message = "이메일"
		}else if($("#phone").val() == ""){
			message = "전화"
		}else if($("#password").val() == ""){
			message = "패스워드"
		}else if($("#passwordChk").val() == ""){
			message = "패스워드 확인"
		}else if($("#cardId").val() == ""){
			message = "카드 정보"
		}
		if(message != ""){
			swal({
				title: message + "은 필수 등록 요소 입니다.",
				icon: "error",
			}).then(function(result) {
			});
			evt.preventDefault();
			}
	  });

  $('#phone').keyup(function () {
    $(this).val(
      $(this)
        .val()
        .replace(/[^0-9]/g, '')
        .replace(
          /(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,
          '$1-$2-$3'
        )
        .replace('--', '-')
    );
  });

  $('#password').keyup(function () {
    /*var reg =  new RegExp("^(?=.*[0-9])(?=.*[a-zA-z]).{8,15}$");*/
    var reg = new RegExp(
      '^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^*+=-]).{6,16}$'
    );

    var password = $(this).val();

    if (!reg.test(password)) {
      $('#checkPass')
        .html('8자리 이상의 대소문자, 숫자, 특수문자 조합를 조합해주세요!!')
        .css('color', 'red');
      	$('#modifyBtn').attr('disabled', true);
      	$('#modifyBtn').attr('pointer-events', 'none');
      	$('#modifyBtn').css('background-color', '#eee');
    } else {
      $('#checkPass').html('조건에 맞는 비밀번호 입니다.').css('color', 'blue');
      $('#modifyBtn').attr('disabled', false);
      $('#modifyBtn').attr('pointer-events', 'auto');
      $('#modifyBtn').css('background-color', '#373234');
    }
  });

  $('#passwordChk').keyup(function () {
    if ($(this).val() != $('#password').val()) {
      $('#checkPassCol')
        .html('Password가 일치하지않습니다.')
        .css('color', 'red');
      	$('#modifyBtn').attr('disabled', true);	
    	$('#modifyBtn').attr('pointer-events', 'none');
    	$('#modifyBtn').css('background-color', '#eee');
    } else {
      $('#checkPassCol').html('Password가 일치합니다.').css('color', 'blue');
      $('#modifyBtn').attr('disabled', false);
      $('#modifyBtn').attr('pointer-events', 'auto');
      $('#modifyBtn').css('background-color', '#373234');
    }
  });
});
