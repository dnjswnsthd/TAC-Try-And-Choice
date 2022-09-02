<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 로그인 오류 </title>
</head>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<style>
	@font-face {
		font-family: 'Cafe24Ohsquare';
		src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/Cafe24Ohsquare.woff') format('woff');
		font-weight: normal;
		font-style: normal;
	}
	.swal-title{
		font-family: 'Cafe24Ohsquare';
	}
	.swal-button {
		background-color: #373234;
	}
</style>
<body>
	<script> 
		swal({
				title: "아이디와 비밀번호를 다시 확인해주세요!",
				icon: "error", 
				button : "확인",
			}).then(function(result) {
				location.href = '/login';
			});
	</script>
</body>
</html>