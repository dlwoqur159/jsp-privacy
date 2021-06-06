<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
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
   width: 280px;
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
   padding: 10px 172px;
   width:380px;
   border: 1px solid lightgray;
   border-radius: 3px;
   margin-top: 5px;
}


input {
   border: 1px solid lightgray;
   border-radius: 3px;
   margin-top: 5px;
}

</style>
<title>회원가입</title>
<script>
function check(){
var id = joinform.MEMBER_ID.value;
var password1 = joinform.MEMBER_PW.value;
var password2 = joinform.MEMBER_PW2.value;
var phone = joinform.MEMBER_TEL.value;
var name = joinform.MEMBER_NAME.value;
var add = joinform.MEMBER_ADD.value;

var forms = document.getElementbyId("joinform");

if((forms.MEMBER_NAME.value=="")||(forms.MEMBER_NAME.valuelength(=1)){
alert("이름을 입력하여주세요");
forms.MEMBER_NAME.focus();
return false;
}
if(id.length == 0){
alert("아이디를 입력하여 주세요");
joinform.MEMBER_ID.focus();
return false;
}
if(password1.length == 0){
alert("비밀번호를 입력하여 주세요");
joinform.MEMBER_PW.focus();
return false;
}
if(add.length == 0){
	alert("주소를 입력하여 주세요");
	joinform.MEMBER_ADD.focus();
	return false;
	}
if(id.length != 0){
alert("비밀번호가 일치 하지 않습니다");
joinform.MEMBER_PW.value="";
joinform.MEMBER_PW2.value="";
joinform.MEMBER_PW.focus();
return false;
}

if(phone.length == 0 ){
alert("휴대폰 번호를 입력하여 주세요");
joinform.MEMBER_TEL.focus();
return false;
}
return true;
}

function openConfirmId(joinform){
var id = joinform.MEMBER_ID.value;
var url ="./MemberIDCheckAction.me?MEMBER_ID="+joinform.MEMBER_ID.value;

if(id.length == 0){
alert("아이디를 입력하세요");
joinform.MEMBER_ID.focus();
return false;
}
open(url, "confirm", "tollbar=no,location=no", +"status=no,menubar=no," +"scrollbars=yes,resizable=no,"+"width=410,height=400,");
}

function gNumCheck(){
if(event.keyCode >= 48 && event.keyCode <=57 ){
return true;
}else{
event.returnValue=false;
}
}
</script>
</head>
<body>

<!--회원가입-->
<form name = "joinform" action="ActionJoin.do" method="post" onsubmit="return check()">
 <div class="container">
           <h5>회원가입 페이지</h5>
        <hr />

   <input type = "text" name="MEMBER_ID" id="id" placeholder="ID" size="20" maxlength=15 class="txt-box" />
  
   <input type = "button" name="confirm_id" value = "중복확인" onclick="openConfirmId(this.form)" class="button1" />

   <input type = "password" name="MEMBER_PW" id= "pass" placeholder="PW" size = "15" class="txt-box" /> 

   <input type = "text" name="MEMBER_NAME" id = "name" size="20" placeholder="이름" class="txt-box" /> 
   
   <input type = "text" name="MEMBER_ADD" id = "address" size="20" placeholder="주소" class="txt-box" /> 

   <input type = "text" name="MEMBER_TEL" id="phonenumber" size = "15" placeholder="전화번호" class="txt-box" />

   <input type = "text" name="MEMBER_AGE" id = "age" size = "15" placeholder="나이" class="txt-box" /> 

   <input type ="submit" value="확인" class="button2" />
   
   <a class="button2" href="Login.do">취소</a>
   <hr />
     
 </div>

</form>
  


<!--회원가입-->

</body>
</html>