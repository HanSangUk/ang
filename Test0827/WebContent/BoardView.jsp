<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, th, td {
	border: 3px black solid;
	text-align: center;
	border-collapse: collapse;
}
</style>
<script>
	function boardlist(){
		location.href="boardlist";
	}
</script>
</head>
<body>
	<table>
		<tr>
			<th>글 번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>파일명</th>
			<th>파일이미지</th>
			<th>작성일자</th>
			<th>조회수</th>
		</tr>
		<tr>
			<td>${viewDTO.bnumber}</td>
			<td>${viewDTO.bwriter}</td>
			<td>${viewDTO.btitle}</td>
			<td>${viewDTO.bfilename}</td>
			<td><img src="UpLoadFile/${viewDTO.bfilename}" width="200" height="200"></td>
			<td>${viewDTO.bdate}</td>
			<td>${viewDTO.bhits}</td>
		</tr>
	</table>
	<h3>내용</h3>
	<textarea rows="50" cols="80" readonly>${viewDTO.bcontents}</textarea>
	<button onclick="boardlist()">목록</button>
</body>
</html>