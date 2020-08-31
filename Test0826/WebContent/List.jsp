<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
table, th, td {
	border: 3px black solid;
	text-align: center;
	border-collapse: collapse;
}
</style>
<script>
	function deletes(deleteid){
		alert("삭제 완료");
		console.log(deleteid);
		location.href="delete2?mid="+deleteid;
	}
</script>
<body>
	<h2>회원목록</h2>
	<h1>MemberList.jsp</h1>
	<!-- jst1에서 제공하는 반복태그를 이용하여 memberList에 담긴 값 출력 -->
	<table>
		<tr>
			<th>아이디</th>			
			<th>이름</th>
			<th>조회</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="member" items="${list}">
			<tr>
				<td>${member.mid}</td>
				<td>${member.mname}</td>
				<td><a href="View?mid=${member.mid}">조회</a></td>
				<td><button onclick="deletes('${member.mid}')">삭제</button></td>
			</tr>
			<br>
		</c:forEach>
	</table>
</body>
</html>