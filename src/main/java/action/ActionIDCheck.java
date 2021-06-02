package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.ActionForward;
import dao.privacyDAO;


public class ActionIDCheck implements Action{
	 public ActionForward execute(HttpServletRequest request, HttpServletResponse responce)
			  throws Exception{
			      ActionForward forward = new ActionForward();
			      String id = request.getParameter("MEMBER_ID");
			      
			      privacyDAO privacydao = new privacyDAO();
			      int  check = privacydao.confirmld(id);
			      
			      request.setAttribute("id", id);
			      request.setAttribute("check", check);

			      forward.setRedirect(false);
			      forward.setPath("/WEB-INF/member/member_idchk.jsp");

			      return forward;
			  }

}
