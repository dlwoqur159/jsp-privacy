<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%
	String id= null;
if (session.getAttribute("MEMBER_ID")!=null){
	id=(String)session.getAttribute("MEMBER_ID");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>명함 게시판</title>
<style type="text/css">


h2 {
   text-align: center;
}



#commandCell {
   margin-top:10px;
   text-align: center;
}

#writebox {
            width: 220px;
            margin: auto;
            line-height: 16px;
         border: solid 1px;
         border-radius:5%;

}

.input_style {
   padding:2px;
   margin: 10px 20px;
   height:30px; 
   width: 220px
   border-radius: 8%;
}
.button{
           background: #81F79F;
            color: white;
            border: 0;
         width:100px;
         height:30px;
            border-radius: 5%;
}
</style>
</head>
<body>
   <!-- 게시판 등록 -->

   <section id="writeForm">
      <h2>명함작성</h2>
      <form action="PrivacyWritePro.do" method="post" name="boardform">
         <div id = writebox>
         <input placeholder="id" name="MEMBER_ID" id = "MEMBER_ID" class="input_style"/>
               <input placeholder="성함" name="PRIVACY_NAME" id = "PRIVACY_NAME" class="input_style"/>
               <input id="PRIVACY_TEL" placeholder="연락처" name="PRIVACY_TEL" required="required" class="input_style"/>
               <input id="PRIVACY_Company_Name" placeholder="회사명" name="PRIVACY_Company_Name" id = "PRIVACY_Company_Name" class="input_style"/>
               <input name="PRIVACY_RANK" type="text" placeholder="직위명" id="PRIVACY_RANK"  required="required" class="input_style"/>

         </div>
         <section id="commandCell">
            <input type="submit" value="등록" class = "button">
            <input  type="reset" value="다시쓰기" class = "button"/>
         </section>
      </form>
   </section>
   <!-- 게시판 등록 -->
</body>
</html>