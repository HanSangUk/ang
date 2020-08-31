<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function UpdateProcess() {
		updateform.submit();
	}
</script>
<style>
    *{
        margin: 0;
        padding: 0;
    }
    body{
        background-color: rgb(65, 175, 179);
    }
    h1{
        text-align: center;
        margin: 20px;
    }
    input{
        background-color: transparent;
      /* border: 2px solid transparent; */
        border-bottom: 2px solid black;
    }
    #divs{
        padding: 10px;
        margin: auto;
        display: block;
        width: 540px;
        height: 300px;
    }
    #bcontents {
            width: 540px;
            height: 300px;
            margin: auto;
            display: block;
    }
    button{
        margin: auto;
        display: block;
    }
    .button{
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
</style>
</head>
<body>
<h1>정보수정</h1>
<div id=divs>
	<form action="updateprocess" method="post" name="updateform">
		글번호 : <input type="text" name="bnumber" id="bnumber" value="${boardupdate.bnumber}" readonly><br>
		작성자 : <input type="text" name="bwriter" id="bwriter" value="${boardupdate.bwriter}" readonly><br>
		제목 : <input type="text" name="btitle" id="btitle" value="${boardupdate.btitle}"><br>
		내용 <br> <input type="text" name="bcontents" id="bcontents" value="${boardupdate.bcontents}"><br>
	</form>
	<button onclick="UpdateProcess()" class="button">수정</button><br>
</div>
</body>
</html>