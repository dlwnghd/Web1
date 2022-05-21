<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 한글이 깨지지 않기위해 추가한 requset Encoding / 데이터를 전송할 때 UTF-8로 바꾸어서 전송 -->
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>param 액션 태그</title>
</head>
<body>
   <h3>param 액션 태그</h3>
   	<!-- param : 현재 페이지에 있는 정보를 다른 페이지에 넘겨줌 -->
   	<!-- jsp구문 내에서는 주석처리를 이용할 수 없다. -->
   <jsp:forward page="paramResult.jsp">
      <jsp:param value="admin" name="id"/>
      <jsp:param value="관리자" name="name"/>
   </jsp:forward>
</body>
</html>