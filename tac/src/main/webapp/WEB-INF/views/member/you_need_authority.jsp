<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 관리자가 아닙니다! </title>
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
				title: "관리자만 사용가능한 페이지 입니다",
				text: "일반회원은 접근 불가합니다.",
				icon: "error", 
				button : "미안합니다",
			}).then(function(result) {
				console.log(result);
				location.href = '/main';
			});
	</script>
</body>
</html>