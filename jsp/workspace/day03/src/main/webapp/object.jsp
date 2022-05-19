<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 request</title>
</head>
<body>
<!-- 
	이름과 생일이 모두 입력되었다면, 전송
	objectOk.jsp에서는 전달받은 이름과 생일을 출력
 -->
	<form action="objectOk.jsp" name="join" method="post">
        <fieldset>
            <legend>개인 정보</legend>
            <input type="text" name="name">
            <input type="date" name="birthday">
            <input type="button" value="확인">
        </fieldset>
    </form>
</body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
</script>
</html>