package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.privacyDAO;
import dto.PrivacyDTO;
import vo.ActionForward;

public class ActionJoin implements Action {
	
	public ActionForward execute(HttpServletRequest req,HttpServletResponse resp) throws Exception{
		
		req.setCharacterEncoding("UTF-8");
		
		privacyDAO pdao = new privacyDAO();
		PrivacyDTO pdto = new PrivacyDTO();
		ActionForward forward = null;
		
		pdto.setPRIVACY_ID(req.getParameter("PRIVACY_ID"));
		pdto.setPRIVACY_PW(req.getParameter("PRIVACY_PW"));
		pdto.setPRIVACY_NAME(req.getParameter("PRIVACY_NAME"));
		pdto.setPRIVACY_TEL(req.getParameter("PRIVACY_TEL"));
		pdto.setPRIVACY_Company_Name(req.getParameter("PRIVACY_Company_Name"));
		pdto.setPRIVACY_RANK(req.getParameter("PRIVACY_RANK"));
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<script>");
		out.println("alert('회원가입 성공')");
		out.println("location.href='./Login.do");
		out.println("</script>");
		out.close();
		
		return forward;
		
	}

}
