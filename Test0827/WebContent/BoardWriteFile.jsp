<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function boardWriteFile() {
		writeform.submit();
	}
	function boardlist() {
		location.href = "boardlist";
	}
</script>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
<style>
* {
	margin: 0px;
	padding: 0px;
	font-family: 'Jua', sans-serif;
	font-size: 20px;
}

body {
	margin: 10px;
	padding: 10px;
	background-color: rgb(65, 175, 179);
}

h1 {
	text-align: center;
	margin: 20px;
	font-size: 40px;
}

input {
	color: black;
	background-color: transparent;
	/* border: 2px solid transparent; */
	border-bottom: 2px solid black;
	padding: 10px;
	margin: 5px 5px 15px 20px;
}

.button {
	padding: 15px 25px;
	font-size: 24px;
	text-align: center;
	cursor: pointer;
	outline: none;
	color: #fff;
	background-color: rgb(34, 34, 36);
	border: none;
	border-radius: 15px;
	box-shadow: 0 9px #999;
	margin-right: 200px;
	margin-left: 50px;
}

.button1 {
	padding: 15px 25px;
	font-size: 24px;
	text-align: center;
	cursor: pointer;
	outline: none;
	color: #fff;
	background-color: rgb(34, 34, 36);
	border: none;
	border-radius: 15px;
	box-shadow: 0 9px #999;
	margin-left: 50px;
}

.button:hover, .button1:hover {
	background-color: #3a4242
}

.button:active, .button1:active {
	background-color: #334446;
	box-shadow: 0 5px #666;
	transform: translateY(4px);
}

#board {
	width: 540px;
	height: 300px;
	margin: auto;
	display: block;
}

#bcontents {
	background-color: transparent;
	border-color: 2px solid black;
	width: 502px;
	height: 300px;
}

#bwriter {
	float: left;
	width: 50%;
}

#btitle {
	float: left;
	width: 50%;
}
</style>
</head>
<body>
	<h1>BoardWriteFile.jsp</h1>
	<div id="board">
		<form action="boardwritefile" method="post" name="writeform" enctype="multipart/form-data">
			<div id="bwriter">
				작성자 <br> <input type="text" name="bwriter">
			</div>
			<div id="btitle">
				제목 <br> <input type="text" name="btitle"><br>
			</div>
			<br> 내용 <br> <input type="text" name="bcontents"
				id="bcontents"><br>
			첨부파일 <input type="file" name="bfile" id="bfile">
		</form>
		<button class="button" onclick="boardWriteFile()" name="boardWriteFile">작성(파일)</button>
		<button class="button1" onclick="boardlist()" name="boardlist">목록</button>
	</div>
</body>
</html>