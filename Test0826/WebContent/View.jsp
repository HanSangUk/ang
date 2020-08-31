<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>MemberView.jsp</h1>
	<table>
		<tr>
			<th>아이디 </th>
			<th>비밀번호 </th>
			<th>이름 </th>
			<th>핸드폰번호 </th>
			<th>이메일 </th>
			<th>성별 </th>
			<th>조회 </th>
		</tr>
		<tr>
				<td>${View.mid}</td>
				<td>${View.mpassword}</td>
				<td>${View.mname}</td>
				<td>${View.mphone}</td>
				<td>${View.memail}</td>
				<td>${View.mgender}</td>
			</tr><br>
	</table>
</body>
</html>