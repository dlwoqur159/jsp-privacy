<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>회원관리 시스템 로그인 페이지</title>
<style>
.container {
   width: 385px;
   line-height: 50px;
   margin: 40px auto;
   margin-top: 250px;
}

h5 {
   text-align: center;
   font-size: 25px;
}



.button {
   background-color: #2EFE64;
   color: white;
   border-radius: 5px;
   border: 0;
   padding: 10px 172px;
   width:380px;
}


p {
   text-align: center;
}


input {
   border: 1px solid lightgray;
   border-radius: 3px;
   margin-top: 5px;
}
</style>
</head>
<body>
<section>
<form name="loginform" action="ActionLogin.do" method="POST">
   <div class="container">
           <h5>로그인 페이지</h5>
        <hr />
            <input type="text" placeholder="ID" name="txtId" id = "id" required style="height:30px; width: 380px" /><br />
            <input type="password" placeholder="PW" name="txtPw" id= "pass" required style="height:30px; width: 380px" /><br />
            <input type="submit" value="로그인" class="button" />
         <a href="Join.do"><input type="button" value="회원가입" class="button"/></a>
        <hr />
    </div>
</form>
</section>
</body>
</html>