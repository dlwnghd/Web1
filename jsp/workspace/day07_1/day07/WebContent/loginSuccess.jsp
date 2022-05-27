<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty memberNumber}">
			<h3>로그인 실패</h3>
		</c:when>
		<c:otherwise>
			<h1><c:out value="${memberNumber}"/>번 회원님 로그인 성공</h1>
		</c:otherwise>
	</c:choose>
	
</body>
</html>