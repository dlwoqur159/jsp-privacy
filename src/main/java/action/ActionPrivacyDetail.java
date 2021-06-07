package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.PrivacyDetailService;
import vo.ActionForward;
import vo.privacyBean;

 public class ActionPrivacyDetail implements Action {
    
    public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
         
      int privacy_num=Integer.parseInt(request.getParameter("PRIVACY_NUM"));
      String page = request.getParameter("page");
      PrivacyDetailService privacyDetailService = new PrivacyDetailService();
      privacyBean article = privacyDetailService.getArticle(privacy_num);
      ActionForward forward = new ActionForward();
      request.setAttribute("page", page);
         request.setAttribute("article", article);
         forward.setPath("/privacy/privacy_detail.jsp");
         return forward;

    }
    
}