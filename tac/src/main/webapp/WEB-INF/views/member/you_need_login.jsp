<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 로그인 먼저 해주세요! </title>
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
				title: "로그인이 필요한 서비스 입니다.",
				text: "로그인과 함께 TAC의 놀라운 기능을 사용하세요!",
				icon: "error", 
				button : "로그인",
			}).then(function(result) {
				console.log(result);
				location.href = '/login';
			});
	</script>
</body>
</html>