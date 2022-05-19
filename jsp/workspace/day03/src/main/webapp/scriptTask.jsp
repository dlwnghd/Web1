<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트 태그 실습</title>
</head>
<body>
<!-- 3행 5열 표를 for문으로 제작하기 -->
<!-- 각 열 안에 몇 행 몇열인지 출력하기 -->
<%!
	private final int ROW_COUNT = 3;
	private final int COLUMN_COUNT = 5;
%>
<%
	for(int i = 0; i <ROW_COUNT; i++){
%>
	<tr>
	<%
	for(int j = 0; j<COLUMN_COUNT; j++){
	%>
	<td><%=i+1%>행<%=j+1%>열</td>
	<% } %>
	</tr>
<% } %>
</body>
</html>