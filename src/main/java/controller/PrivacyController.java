package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.ActionForward;
import action.Action;
import action.ActionLogin;

@WebServlet("*.do")
public class PrivacyController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String RequestURI=req.getRequestURI();
		String contextPath=req.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		ActionForward forward= null;
		Action action=null;
		
		
		if(command.equals("/Login.do")){
			forward=new ActionForward();
			forward.setPath("/WEB-INF/Login.jsp");
		}else if(command.equals("/Join.do")){
			forward=new ActionForward();
			forward.setPath("/WEB-INF/Join.jsp");
		}else if(command.equals("/ActionLogin.do")){
			action = new ActionLogin();
			try {
				forward=action.execute(req, resp );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Choice.do")){
			forward=new ActionForward();
			forward.setPath("/WEB-INF/Choice.jsp");
		}
			/*action = new ActionChoice();
			try {
				forward=action.execute(req, resp );
			} catch (Exception e) {
				e.printStackTrace();
			}*/
		
		
		if(forward != null){
			
			if(forward.isRedirect()){
				resp.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher=
						req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, resp);
			}
			
		}
	}
}

