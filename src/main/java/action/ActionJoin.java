package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.privacyDAO;
import dto.memberDTO;
import vo.ActionForward;

public class ActionJoin implements Action {
	
	public ActionForward execute(HttpServletRequest req,HttpServletResponse resp) throws Exception{
		
		req.setCharacterEncoding("UTF-8");
		
		privacyDAO pdao = new privacyDAO();
		memberDTO pdto = new memberDTO();
		ActionForward forward = null;
		
		pdto.setMEMBER_ID(req.getParameter("MEMBER_ID"));
		pdto.setMEMBER_PW(req.getParameter("MEMBER_PW"));
		pdto.setMEMBER_ADD(req.getParameter("MEMBER_ADD"));
		pdto.setMEMBER_TEL(req.getParameter("MEMBER_TEL"));
		pdto.setMEMBER_AGE(req.getParameter("MEMBER_AGE"));
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<script>");
		out.println("alert('success')");
		out.println("location.href='Login.do");
		out.println("</script>");
		out.close();
		
		return forward;
		
	}

}
