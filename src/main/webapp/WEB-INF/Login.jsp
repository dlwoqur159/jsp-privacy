<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>회원관리 시스템 로그인 페이지</title>

</head>
<body>
<section>
<div>
	<form name="loginform" action="ActionLogin.do" method="POST">
		<div>
			 <input id="txtId" class="txtbox-simple" placeholder="아이디" />
		     <input id="txtPw" class="txtbox-simple" placeholder="비밀번호" type="password" />
		</div>
		<input type="submit" class= "td" value="로그인"/>
	</form>
		<a href="Join.do" class= "td"><input type="button" value="회원가입"/></a>
</div>

</section>
</body>
</html>