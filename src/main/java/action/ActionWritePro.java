package action;

import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.ServicePrivacyWritePro;
import vo.ActionForward;
import vo.privacyBean;

public class ActionWritePro implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{

		ActionForward forward=null;
		privacyBean privacyBean = null;
		ServletContext context = request.getServletContext();  		
		privacyBean = new privacyBean();
		privacyBean.setPRIVACY_NAME(request.getParameter("PRIVACY_NAME"));
		privacyBean.setPRIVACY_TEL(request.getParameter("setPRIVACY_TEL"));
		privacyBean.setPRIVACY_Company_Name(request.getParameter("PRIVACY_Company_Name"));
		privacyBean.setPRIVACY_RANK(request.getParameter("PRIVACY_RANK"));
		ServicePrivacyWritePro ServicePrivacyWritePro = new ServicePrivacyWritePro();
		boolean isWriteSuccess = ServicePrivacyWritePro.registArticle(privacyBean);

		if(!isWriteSuccess){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("PrivacyList.bo");
		}

		return forward;
		
	}  	
	
}