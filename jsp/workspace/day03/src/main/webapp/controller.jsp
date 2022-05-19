<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String site = request.getParameter("site") + ".jsp";
/* 	switch(site){
	case "naver":
		break;
	case "google":
		break;
	case "daum":
		break;		
	} */
	%>
	<jsp:forward page="<%=site %>"/>
</body>
</html>