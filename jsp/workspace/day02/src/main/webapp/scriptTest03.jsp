<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트 태그 예제3</title>
</head>
<body>
	<p>
		Today's date : <%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>
	</p>
</body>
</html>