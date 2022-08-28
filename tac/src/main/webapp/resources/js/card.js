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
	
});