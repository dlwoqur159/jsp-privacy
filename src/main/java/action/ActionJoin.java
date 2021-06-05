package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.privacyDAO;
import vo.privacyBean;
import vo.ActionForward;

public class ActionJoin implements Action {
	
	public ActionForward execute(HttpServletRequest req,HttpServletResponse resp) throws Exception{
		
		req.setCharacterEncoding("UTF-8");
		
		privacyDAO pdao = new privacyDAO();
		privacyBean pdto = new privacyBean();
		ActionForward forward = null;
		
		pdto.setMEMBER_ID(req.getParameter("MEMBER_ID"));
		pdto.setMEMBER_PW(req.getParameter("MEMBER_PW"));
		pdto.setMEMBER_ADD(req.getParameter("MEMBER_ADD"));
		pdto.setMEMBER_TEL(req.getParameter("MEMBER_TEL"));
		pdto.setMEMBER_AGE(req.getParameter("MEMBER_AGE"));
		
		pdao.insertPrivacy(pdto);
		
		forward.setRedirect(true);
		forward.setPath("Login.do");
		req.getSession().setAttribute("msg", "1");
		
		return forward;
		
	}

}
