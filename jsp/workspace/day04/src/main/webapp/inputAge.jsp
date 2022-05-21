<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 전송 실습</title>
</head>
<body>
	<%-- <form action="inputName.jsp">
		<input type="hidden" name="name" value="<%=request.getParameter("name")%>">
		<input type="text" name="age" placeholder="나이">
		<button>전송</button>
	</form> --%>
	<%
		response.sendRedirect("inputName.jsp?name=" + URLEncoder.encode(request.getParameter("name"), "UTF-8") + "&age=20");
	%>
</body>
</html>