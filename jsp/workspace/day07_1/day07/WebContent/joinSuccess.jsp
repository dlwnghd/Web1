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
	<table border="1" style="margin: 0 auto;">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>성별</th>
			<th>주소</th>
			<th>상세주소</th>
		</tr>
		<c:forEach var="member" items="${memberList}">
			<c:if test="${member.getMemberName() != '한동석' }">
			<tr>
				<td><c:out value="${member.getMemberNumber()}"/></td>
				<td><c:out value="${member.getMemberName()}"/></td>
				<td><c:out value="${member.getMemberId()}"/></td>
				<td><c:out value="${member.getMemberPw()}"/></td>
				<td><c:out value="${member.getMemberGender()}"/></td>
				<td><c:out value="${member.getMemberAddress()}"/></td>
				<td><c:out value="${member.getMemberAddressDetail()}"/></td>
			</tr>
			</c:if>
		</c:forEach>
	</table>
</body>
</html>