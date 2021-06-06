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
		int listCount=Serviceprivacylist.getListCount(); //占쏙옙 占쏙옙占쏙옙트 占쏙옙占쏙옙 占쌨아울옙.
		articleList = Serviceprivacylist.getArticleList(page,limit); //占쏙옙占쏙옙트占쏙옙 占쌨아울옙.
		//占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙.
   		int maxPage=(int)((double)listCount/limit+0.95); //0.95占쏙옙 占쏙옙占쌔쇽옙 占시몌옙 처占쏙옙.
   		//占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙(1, 11, 21 占쏙옙...)
   		int startPage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		//占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙.(10, 20, 30 占쏙옙...)
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
   		forward.setPath("/WEB-INF/privacy/privacy_list.jsp"); // �닔�젙
   		return forward;
   		
	 }
	 
 }