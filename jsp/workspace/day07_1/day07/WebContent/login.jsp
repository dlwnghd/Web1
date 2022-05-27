<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<section>
		<form action="MemberLoginOk.me" method="post" name="loginForm">
			<div>
				<input name="memberId" type="text" placeholder="아이디를 입력해주세요.">
			</div>
			<div>
				<input name="memberPw" type="password" placeholder="패스워드를 입력해주세요.">
			</div>
			<div>
				<input type="button" id="login" value="로그인">
			</div>
		</form>
	</section>
</body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	let form = document.loginForm;
	
	$("input#login").on("click", function(){
		console.log(form.memberId);
		if(!form.memberId.value){
			alert("아이디를 입력해주세요.");
			return;
		}
		if(!form.memberPw.value){
			alert("패스워드를 입력해주세요.");
			return;
		}
		
		form.submit();
	});
	
</script>
</html>




















