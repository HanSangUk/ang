<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function boarddelete(deleteid) {
		console.log(deleteid);
		location.href = "boarddelete?bnumber=" + deleteid;
	}
	function boardview(view){
		location.href = "boardview?bnumber=" + view;
	}
	function boardupdate(update){
		location.href = "boardupdate?bnumber=" + update;
	}
</script>
<style>
table, th, td {
	border: 3px black solid;
	text-align: center;
	border-collapse: collapse;
    margin: auto;
}
body{
    margin: 10px;
    padding: 10px;
    background-color: rgb(65, 175, 179);
}
button{
    background-color: rgb(90, 86, 86);
    color: white;
}
h1{
    text-align: center;
}
</style>
</head>
<body>
<h1>리스트</h1>
	<table>
		<tr>
			<th>글 번호</th>
			<th>제목</th>
			<th>조회수</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="serchlist" items="${serchlist}">
			<tr>
				<td>${serchlist.bnumber}</td>
				<td><a href=boardview?bnumber=${serchlist.bnumber}>${serchlist.btitle}</a></td>
				<td>${serchlist.bhits}</td>
				<td><button onclick="boardupdate('${serchlist.bnumber}')">수정</button></td>
				<td><button onclick="boarddelete('${serchlist.bnumber}')">삭제</button></td>
			</tr>
			<br>
		</c:forEach>
	</table>
</body>
</html>