<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<script>
	function memberDeleteProcess(){
		//비밀번호 입력칸에 비밀번호를 입력받아서
		//db에 저장된 비밀번호와 일치하면 정보수정을 진행시키고
		//일치하지 않으면 일치하지 않는다는 alert창을 띄움.
		var pw = document.getElementById("mpassword").value;
		var pwdb = '${memberDelete.mpassword}';
		console.log(pw);
		console.log(pwdb);
		if(pw.length != 0){
			if(pw==pwdb){
				updateform.submit();
			} else {
				alert("비밀번호가 틀립니다.");
			}
		} else {
			alert("비밀번호를 입력해주세요.");			
		}
	}
	</script>
<body>
	<form action="memberDeleteprocess" method="post" name="updateform">
		아이디 : <input name="mid" id="mid" value="${memberDelete.mid}" readonly><br>
		비밀번호확인 : <input type="password" name="mpassword" id="mpassword"><br>
	</form>
	<button onclick="memberDeleteProcess()">회원탈퇴</button><br>	
</body>
</html>