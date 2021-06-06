<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>회원관리 시스템 로그인 페이지</title>
<style>
body, a, h1,h2 {
   margin:0;
   padding:0;
   text-decoration: none;
}
.container {
   width: 385px;
   line-height: 50px;
   margin: 40px auto;
}
h5 {
   text-align: center;
   font-size: 25px;
}
.txt-box{
   height:30px; 
   width: 3s80px;
}

.button1 {
   background-color: #2EFE64;
   color: white;
   border-radius: 5px;
   border: 0;
   padding: 10px;
   font-size:12px;
   width:90px;
   border: 1px solid lightgray;
   border-radius: 3px;
   margin-top: 5px;

}
.button2 {
   background-color: #2EFE64;
   color: white;
   border-radius: 5px;
   border: 0;
   padding: 10px 155px;
   width:380px;
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
alert("비밀번호를 입력하여 주세요");
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
            <input type="text" placeholder="ID" name="MEMBER_ID" id = "ID" class="txt-box" />
            <input type="password" placeholder="PW" name="MEMBER_PW" id= "PW" class="txt-box"/>
            <input type="submit" value="로그인" class="button2" />
            <a class="button2" href="Join.do" >회원가입</a>
      </form>
      
       <hr />
    </div>
</section>
</body>
</html>