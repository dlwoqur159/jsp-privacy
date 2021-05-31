<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>회원관리 시스템 로그인 페이지</title>
<style>
.td{
	color:white;
}
table{
 margin-left:auto; 
    margin-right:auto;
	margin-top:250px;
}

    .title_div{
		text-align: center;

	}

	.login_title{
		font-weight: bold;
		font-size: 50px;
		margin:10px;
	}
	


	.button{
		  padding: 10px 10px;
		  background-color: #81F79F;
		  		border : 1px solid gray;

		    font-size: 16px;
		  border-radius: 5%;
		  		margin:10px;
				width:150px;
	}
	

	
	.loginbox {
		border : 1px solid gray;
		width:370px;
		height:250px;
		font-color:white;
				  border-radius: 5%;


	}
	.txtbox{
    border: none;
    outline: none;
    padding: 0.8em 0.8em;
    margin: 0 0 0.8em 0;
    border-radius: 5px;
    box-shadow:0 0 1px 1px rgba(0,0,0,0.2), 0 3px 2px 0 rgba(0, 0, 0, 0.15);
	width:330px;
   
    transition-property: box-shadow;
    transition-duration: 0.3s;
		margin:10px;
		

 
}
	a{text-decoration:none}
</style>
</head>
<body>
<section>
<table class="loginbox" align = "center">
<form name="loginform" action="loginProcess.jsp">
     <title>Login</title>
	 <tr>
	<td class="title_div">
		<a class = "login_title">
			Login
		</a>
	</td>
		</tr>
	<tr>
	<td>
	<input type="text" name="id" id = "id" class="txtbox" placeholder="ID" />
	</td>
	</tr>
	<tr>
	<td>
	    <input type="password" name="pass" id = "pass" class="txtbox" placeholder="PW"  />
	</td>
	</tr>
	
	<tr>
	<td >
		<Button class="button" >
		<a href="javascript:loginform.submit()" class= "td">로그인</a>
		</Button>	
				<Button class="button">
		<a href="joinForm.jsp" class= "td">회원가입</a>
		</Button>
			</td>

	</tr>

	</form>
</table>
</section>
</body>
</html>