<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>회원관리 시스템 로그인 페이지</title>
<style>
.container {
   width: 385px;
   line-height: 50px;
   margin: 40px auto;
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
<script >
function check(){
var ID = joinform.MEMBER_ID.value;
var PW = joinform.MEMBER_PW.value;

var forms = document.getElementbyId("joinform");

if(ID.length == 0){
	alert("아이디를 입력하여 주세요");
	joinform.MEMBER_ID.focus();
	return false;
	}
if(PW.length == 0){
alert("아이디를 입력하여 주세요");
joinform.MEMBER_PW.focus();
return false;
}
</script>

</head>
<body>

<section>
   <div class="container">
           <h5>로그인 페이지</h5>
           <form name="loginform" action="ActionLogin.do" method="POST">
        <hr />
            <input type = "text" name="MEMBER_ID" id="id" placeholder="ID" size="20" maxlength=15 class="txt-box" />
            <input type = "password" name="MEMBER_PW" id= "pass" placeholder="PW" size = "15" class="txt-box" /> 
            <input type="submit" value="로그인" class="button" />
            <a href="Join.do"><input type="button" value="회원가입" class="button"/></a>
		</form>
		
		 <hr />
    </div>
</section>
</body>
</html>