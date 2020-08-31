<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function goLogin(){
		loginform.submit();
	}
	function goJoin(){
		location.href="Join.jsp";
	}
</script>

</head>
<body>
	<h2>로그인창</h2>
	<form action="login" method="post" name="loginform">
	아이디 : <input type="text" name="mid" id="mid" ><br>
	비밀번호 : <input type="password" name="mpassword"  id="mpassword"><br>
	<button type="button" onclick="goLogin()" >로그인</button>
	<button type="button" onclick="goJoin()">회원가입</button>
	</form>
</body>
</html>