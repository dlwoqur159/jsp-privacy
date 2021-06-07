<%@page import="vo.PageInfo"%>
<%@page import="vo.privacyBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
	ArrayList<privacyBean> articleList=(ArrayList<privacyBean>)request.getAttribute("articleList");
    PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	int listCount=pageInfo.getListCount();
	int nowPage=pageInfo.getPage();
	int maxPage=pageInfo.getMaxPage();
	int startPage=pageInfo.getStartPage();
	int endPage=pageInfo.getEndPage();
%>

<%
	String id= null;
if (session.getAttribute("MEMBER_ID")!=null){
	id=(String)session.getAttribute("MEMBER_ID");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>MVC 명함 게시판</title>
<style type="text/css">
#registForm {
	width: 500px;
	height: 600px;
	border: 1px solid red;
	margin: auto;
}

h2 {
	text-align: center;
}

table {
	margin: auto;
	width: 450px;
}

#tr_top {
	background: orange;
	text-align: center;
}

#pageList {
	margin: auto;
	width: 500px;
	text-align: center;
}

#emptyArea {
	margin: auto;
	width: 500px;
	text-align: center;
}
</style>
</head>

<body>
	<!-- 게시판 리스트 -->

	<section id="listForm">
	
		<h2>
		<%=id %> 로 로그인하셨습니다.
		</h2>
		<h2>
			명함 목록 <a href="PrivacyWriteForm.do">명함추가</a>
		</h2>
		<table>
			<%
if(articleList != null && listCount > 0){
%>

			<tr id="tr_top">
				<td>번호</td>
				<td>성함</td>
				<td>회사명</td>
				<td>등록날짜</td>
			</tr>

			<%
		for(int i=0;i<articleList.size();i++){
			
	%>
			<tr>
				<td><%=articleList.get(i).getPRIVACY_NUM()%></td>

				<td>
				<%if(articleList.get(i).getPRIVACY_NUM()!=0){ %> <%for(int a=0;a<=articleList.get(i).getPRIVACY_NUM()*2;a++){ %>
					&nbsp; <%} %> ▶ <%}else{ %> ▶ <%} %> 
					
					 <a
					href="boardDetail.bo?board_num=<%=articleList.get(i).getPRIVACY_NUM()%>&page=<%=nowPage%>">
						<%=articleList.get(i).getPRIVACY_NAME()%>
				</a>
				</td>

				<td><%=articleList.get(i).getPRIVACY_NAME() %></td>
				<td><%=articleList.get(i).getPRIVACY_DATE() %></td>
			</tr>
			<%} %>
		</table>
	</section>

	<section id="pageList">
		<%if(nowPage<=1){ %>
		[이전]&nbsp;
		<%}else{ %>
		<a href="PrivacyList.bo?page=<%=nowPage-1 %>">[이전]</a>&nbsp;
		<%} %>

		<%for(int a=startPage;a<=endPage;a++){
				if(a==nowPage){%>
		[<%=a %>]
		<%}else{ %>
		<a href="PrivacyList.bo?page=<%=a %>">[<%=a %>]
		</a>&nbsp;
		<%} %>
		<%} %>

		<%if(nowPage>=maxPage){ %>
		[다음]
		<%}else{ %>
		<a href="boardList.bo?page=<%=nowPage+1 %>">[다음]</a>
		<%} %>
	</section>
	<%
    }
	else
	{
	%>
	<section id="emptyArea">등록된 글이 없습니다.</section>
	<%
	}
%>

</body>
</html>