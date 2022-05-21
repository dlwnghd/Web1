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
		/* requset.getParameter를 통해 사용자가 site라는 key에 입력한 value 값을 받아옴 */
		/* 아래에서 .jsp를 붙일 경우 오류발생함으로 여기서 ".jsp"를 임의로 붙여줌 */
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
	<!-- forward: 다른 페이지로의 이동, 페이지 흐름을 제어한다. -->
	<!-- 어디로 이동할지 page에 대입 -->
	<jsp:forward page="<%=site %>"/>
</body>
</html>