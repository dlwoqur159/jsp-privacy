package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.privacyDAO;
import dto.PrivacyDTO;
import vo.ActionForward;

public class ActionLogin implements Action {
   
public ActionForward execute(HttpServletRequest req,HttpServletResponse resp) throws Exception{
      
      req.setCharacterEncoding("UTF-8");
      HttpSession session = req.getSession();
      privacyDAO pdao = new privacyDAO();
      ActionForward forward = new ActionForward();
      
      String id = req.getParameter("PRIVACY_ID");
      String pw = req.getParameter("PRIVACY_PW");
      
      int check = pdao.userCheck(id,pw);
      if(check ==1) {
         session.setAttribute("id", id);
         
         if(pdao.isAdmin(id)) {
            forward.setRedirect(true);
            forward.setPath("/GoodsList.ag");
            return forward;
         }else {
            forward.setRedirect(true);
            forward.setPath("/GoodsList.go-item=new_item");
            return forward;
         }
      }else if(check ==0) {
         resp.setContentType("text/html;charset=UTF-8");
         PrintWriter out = resp.getWriter();
         out.println("<script>");
         out.println("alert('��й�ȣ�� ��ġ���� �ʽ��ϴ�.')");
         out.println("history.go(-1);");
         out.println("</script>");
         out.close();
      }else {
         resp.setContentType("text/html;charset=UTF-8");
         PrintWriter out = resp.getWriter();
         out.println("<script>");
         out.println("alert('ID�� �������� �ʽ��ϴ�.')");
         out.println("history.go(-1);");
         out.println("</script>");
         out.close();
      }
      
      
      return null;
      
   }

}