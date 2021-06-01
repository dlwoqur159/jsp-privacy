<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>회원가입</title>
<style>
.td{
	color:white;
}
	table{
		margin : auto;
		width : 300px;
		border : 1px solid gray;
		 border-radius: 5%;
		text-align: center;
	}
	.td_title{
		font-weight: bold;
		font-size: x-large;
	}
		.button{
		  padding: 10px 10px;
		  background-color: #81F79F;
		border : 1px solid gray;
		  border-radius: 5%;
		  		margin:10px;
				width:80px;
	}
			.txtbox1{
    border: none;
    outline: none;
    padding: 0.8em 0.8em;
    margin: 0 0 0.8em 0;
    border-radius: 5px;
    box-shadow:0 0 1px 1px rgba(0,0,0,0.2), 0 3px 2px 0 rgba(0, 0, 0, 0.15);
	width:250px;
   
    transition-property: box-shadow;
    transition-duration: 0.3s;
		margin:10px;

 
}
		.txtbox{
    border: none;
    outline: none;
    padding: 0.8em 0.8em;
    margin: 0 0 0.8em 0;
    border-radius: 5px;
    box-shadow:0 0 1px 1px rgba(0,0,0,0.2), 0 3px 2px 0 rgba(0, 0, 0, 0.15);
	width:250px;
   
    transition-property: box-shadow;
    transition-duration: 0.3s;
		margin:10px;
		margin-right:115px;

 
}
.tbclass{
	width:450px;
}

	a{text-decoration:none}

</style>
</head>
<body>
<form name="joinform" action="joinProcess.jsp" method="post">
<table class = "tbclass">
	<tr>
		<td colspan="2" class = "td_title">
			회원가입
		</td>
	</tr>
	<tr>
		<td>
		<input type="text" name="id" id = "id" placeholder="ID" class="txtbox1"/>
				<Button class="button">
		<a href="javascript:joinform.submit()" class= "td">중복확인</a>
		</Button>
		</td>
	</tr>
		<td><input type="password" name="pass" id = "pass" placeholder="PW"class="txtbox"/></td>
	</tr>
	<tr>
		<td><input type="text" name="name" id = "name" placeholder="이름"class="txtbox"/></td>
	</tr>

	<tr>
		<td><input type="text" name="tel" id = "tel" placeholder="전화번호" class="txtbox"/></td>
	</tr>
	<tr>
		<td><input type="text" name="compnay" id = "compnay" placeholder="회사명" class="txtbox"/></td>
	</tr>
	<tr>
		<td><input type="text" name="rank" id = "rank" placeholder="직위" class="txtbox"/></td>
	</tr>


	<tr>
		<td colspan="2">
		<Button class="button">
		<a href="javascript:joinform.submit()" class= "td">회원가입</a>
		</Button>
		<Button class="button">
			<a href="loginForm.jsp" class= "td">취소</a>
		</Button>

		</td>
	</tr>
</table>
</form>
</body>
</html>
