<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>응답 페이지</title>
</head>
<body>
	<!-- paramTest로부터 key가 "id"인 파라미터의 value를 받아옴  -->
   <p>아이디 : <%=request.getParameter("id")%></p>
   <!-- paramTest로부터 key가 "name"인 파라미터의 value를 받아옴  -->
   <p>이름 : <%=request.getParameter("name")%></p>
</body>
</html>