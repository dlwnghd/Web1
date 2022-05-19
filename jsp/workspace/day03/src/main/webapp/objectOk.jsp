<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>응답 페이지</title>
</head>
<body>
   <p>이름 : <%=request.getParameter("name")%></p>
   <p>생일 : <%=request.getParameter("birthday")%></p>
</body>
</html>