<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 전송 실습</title>
</head>
<body>
<!--
   inputAge.jsp에서 나이를 입력받고 다시 inputName.jsp로 온다.
   이 때 inputName.jsp에서 age파라미터의 값이 null이 아니라면 나이를 입력받고 돌아온 것이다.
   만약 age까지 모두 입력받았다면 inputName.jsp페이지에서 이름과 나이를 출력한다.
-->
   <form action="inputAge.jsp">
      <input type="text" name="name">
      <input type="submit" value="전송">
   </form>
</body>
</html>