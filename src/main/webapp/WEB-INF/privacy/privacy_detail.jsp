<%@page import="vo.privacyBean"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>

<%
   privacyBean article = (privacyBean)request.getAttribute("article");
    String nowPage = (String)request.getAttribute("page");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>명함 게시판</title>
<style type="text/css">
#articleForm {
   width: 400px;
   height: 420px;
   margin: auto;
}

h2 {
   text-align: center;
}
b{
   text-align: left;
   padding:5px;
   font-size:23px;
   margin:5px
   font-weight:100;
}
#basicInfoArea {
   text-align: center;
}

#articleContentArea {
   background: #81F79F;
   margin-top: 20px;
   height: 170px;
   width:380px;
   border-radius:4%;
   margin-left:auto;
   margin-right:auto;
   color:white;

}

#commandList {
   margin-top: -180px;
   margin-left: auto;
   margin-right: auto;
   width: 500px;
   height:50px;
   text-align: center;
}
</style>
</head>

<body>
   <!-- 게시판 수정 -->
   <section id="articleForm">
      <h2>명함</h2>
      <section id="basicInfoArea">
      </section>
      <section id="  ">
         회사명</br>
         <%=article.getPRIVACY_Company_Name() %></br>
         이름<%=article.getPRIVACY_NAME() %></br>
         직위<%=article.getPRIVACY_RANK() %></br>
         전화번호<%=article.getPRIVACY_TEL() %></br>
      </section>
   </section>
   <section id="commandList">
      <a
         href="privacyModifyForm.bo?privacy_num=<%=article.getPRIVACY_NUM() %>">
         [수정] </a> <a
         href="privacyDeleteForm.bo?privacy_num=<%=article.getPRIVACY_NUM() %>&page=<%=nowPage%>">
         [삭제] </a> <a href="privacyList.bo?page=<%=nowPage%>">[목록]</a>&nbsp;&nbsp;
   </section>
</body>
</html>