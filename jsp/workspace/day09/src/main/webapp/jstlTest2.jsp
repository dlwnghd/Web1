<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL TEST(제어문 - 조건문)</title>
</head>
<body>
   <c:set var="id" value="member"/>
   
   <!-- 모든 조건 확인 -->
   <c:if test="${id eq 'admin'}">
      <h3>현재 로그인된 계정은 <c:out value="${id}"/></h3>
   </c:if>
   <c:if test="${id eq 'member'}">
      <h3>현재 로그인된 계정은 일반 계정입니다.</h3>
   </c:if>
   
   <c:set var="id" value="member"/>
   <!-- 조건 확인 후 반복 탈출 -->
   <c:choose> <!-- swtich문 -->
      <c:when test="${id == 'hds1234'}">	<!-- case -->
         <h3><c:out value="${id}"/>님 환영합니다.</h3>
      </c:when>
      <c:when test="${id eq 'admin'}">	<!-- case -->
         <h3>관리자님 환영합니다.</h3>
      </c:when>
      <c:otherwise>	<!-- 기본값 -->
         <h3>로그인 실패</h3>
      </c:otherwise>
   </c:choose>
   
</body>
</html>


















