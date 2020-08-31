<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function Update(){
			location.href="Update"; 
		}
		function Delete(){
			location.href="Delete";
		}
		function logout(){
			location.href="logout";
		}
		
	</script>
</head>
<body>
	<h1>내정보 창</h1>
	로그인 아이디 : ${sessionScope.loginId}
	<br> ${sessionScope.loginId} 님 환영합니다. <br>


	<c:if test="${sessionScope.loginId ne 'admin'}">
		<button onclick="Update()" name="Update">회원정보수정</button>

		<button onclick="Delete()" name="Delete">회원탈퇴</button>
		<br>

		<button onclick="logout()">로그아웃</button>
		<br>
	</c:if>
	<c:if test="${sessionScope.loginId eq 'admin'}">
		<a href="list">관리자모드(회원목록)</a><br>
		<button onclick="logout()">로그아웃</button>
	</c:if>
</body>
</html>