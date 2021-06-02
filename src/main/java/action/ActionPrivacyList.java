package action;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.ServicePrivacyList;
import vo.ActionForward;
import vo.privacyBean;
import vo.PageInfo;

 public class ActionPrivacyList implements Action {
	 
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		ArrayList<privacyBean> articleList=new ArrayList<privacyBean>();
	  	int page=1;
		int limit=10;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		ServicePrivacyList Serviceprivacylist = new ServicePrivacyList();
		int listCount=Serviceprivacylist.getListCount(); //�� ����Ʈ ���� �޾ƿ�.
		articleList = Serviceprivacylist.getArticleList(page,limit); //����Ʈ�� �޾ƿ�.
		//�� ������ ��.
   		int maxPage=(int)((double)listCount/limit+0.95); //0.95�� ���ؼ� �ø� ó��.
   		//���� �������� ������ ���� ������ ��(1, 11, 21 ��...)
   		int startPage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		//���� �������� ������ ������ ������ ��.(10, 20, 30 ��...)
   	        int endPage = startPage+10-1;

   		if (endPage> maxPage) endPage= maxPage;

   		PageInfo pageInfo = new PageInfo();
   		pageInfo.setEndPage(endPage);
   		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);	
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		ActionForward forward= new ActionForward();
   		forward.setPath("/board/qna_board_list.jsp"); // 수정
   		return forward;
   		
	 }
	 
 }