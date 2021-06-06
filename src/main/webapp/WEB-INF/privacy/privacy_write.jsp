<%@page import="vo.BoardBean"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>

<%
   BoardBean article = (BoardBean)request.getAttribute("article");
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
      <section id="articleContentArea">
         <b>회사명</b></br>
         <b><%=article.getBOARD_CONTENT() %></b></br>
         <b>이름</b><b><%=article.getBOARD_CONTENT() %></b></br>
         <b>직위</b><b><%=article.getBOARD_CONTENT() %></b></br>
         <b>전화번호</b><b><%=article.getBOARD_CONTENT() %></b></br>
      </section>
   </section>
   <section id="commandList">
      <a
         href="boardModifyForm.bo?board_num=<%=article.getBOARD_NUM() %>">
         [수정] </a> <a
         href="boardDeleteForm.bo?board_num=<%=article.getBOARD_NUM() %>&page=<%=nowPage%>">
         [삭제] </a> <a href="boardList.bo?page=<%=nowPage%>">[목록]</a>&nbsp;&nbsp;
   </section>
</body>
</html>