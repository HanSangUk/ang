<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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
.search{
    margin: auto;
    display: block;
    width: 300px;
    height: 35px;
}

input{
    width: 80%;    
}
</style>
<script>
	function search(){
		searchform.submit();
	}
</script>
<body>
	<h1>리스트</h1>
	<form action="searchs" name="searchform" class="search">	
		<input type="text" name="btitle" id="btitle">
	<button onclick="search()">검색</button>
	</form>
	<table>
		<tr>
			<th>글 번호</th>
			<th>제목</th>
			<th>조회수</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="board" items="${boardList}">
			<tr>
				<td>${board.bnumber}</td>
				<td><a href=boardview?bnumber=${board.bnumber}>${board.btitle}</a></td>
				<td>${board.bhits}</td>
				<td><button onclick="boardupdate('${board.bnumber}')">수정</button></td>
				<td><button onclick="boarddelete('${board.bnumber}')">삭제</button></td>
			</tr>
			<br>
		</c:forEach>
	</table>
	<button onclick="location.href='BoardWriteFile.jsp'">글쓰기(파일)</button>
</body>
</html>