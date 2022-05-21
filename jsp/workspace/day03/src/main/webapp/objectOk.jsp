<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 한글이 깨진다면 받는 곳에서도 request를 UTF-8로 변경해보길 바란다 -->
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
	<table>
		<tr>
			<th>이름</th>
			<th>생일</th>
		</tr>
		<tr>
			<td><%=request.getParameter("name")%></td>
			<td><%=request.getParameter("birthday")%></td>
		</tr>
	</table>
</body>
</html>