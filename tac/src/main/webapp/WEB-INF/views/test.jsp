<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div>
		<H1>DB ���� Ȯ��</H1>
		<table border="1">
			<thead>
				<tr>
					<th>id</th>
					<th>pw</th>
					<th>name</th>
					<th>age</th>
					<th>phone</th>
					<th>�Һ��ȣ</th>
					<th>ī���ȣ</th>
					<th>���</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${fn:length(Alllist) > 0}">
						<c:forEach items="${Alllist}" var="Alllist">
							<tr>
								<td>${Alllist.memberId}</td>
								<td>${Alllist.password}</td>
								<td>${Alllist.name}</td>
								<td>${Alllist.age}</td>
								<td>${Alllist.phone}</td>
								<td>${Alllist.consumeId}</td>
								<td>${Alllist.cardId}</td>
								<td>${Alllist.grade}</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="4">��ȸ�� ����� �����ϴ�.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</body>
</html>