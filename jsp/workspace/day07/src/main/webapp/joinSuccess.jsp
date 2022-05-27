<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 성공</title>
</head>
<body>
	<!-- 파라미터 값을 가져옴 -->
	<h1><c:out value="${memberName}"/>님 회원가입에 성공하셨습니다!</h1>
</body>
</html>