<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
		function memberUpdateProcess(){
			var pw = document.getElementById("mpassword").value;
			var pwdb = '${Update.mpassword}';
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
</head>
<body>
	<h2>MemberUpdate.jsp</h2>
	<form action="updateprocess" method="post" name="updateform">
		아이디 : <input name="mid" id="mid" value="${Update.mid}" readonly><br>
		이름 : <input type="text" name="mname" value="${Update.mname}"><br>
		전화번호 : <input type="text" name="mphone" value="${Update.mphone}"><br>
		이메일 : <input type="text" name="memail" value="${Update.memail}"><br>
		비밀번호확인 : <input type="password" name="mpassword" id="mpassword"><br>
	</form>
		<button onclick="memberUpdateProcess()">수정</button><br>
</body>
</html>