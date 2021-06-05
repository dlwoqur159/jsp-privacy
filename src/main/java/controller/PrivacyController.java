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
import action.ActionJoin;
import action.ActionIDCheck;

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
			forward.setPath("/WEB-INF/member/Login.jsp");
		}else if(command.equals("/Join.do")){
			forward=new ActionForward();
			forward.setPath("/WEB-INF/member/Join.jsp");
		}else if(command.equals("/ActionLogin.do")){
			action = new ActionLogin();
			try {
				forward=action.execute(req, resp );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/IDCheck.do")){
			action = new ActionIDCheck();
			try {
				forward=action.execute(req, resp );
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}else if(command.equals("/ActionJoin.do")){
			action = new ActionJoin();
			try {
				forward=action.execute(req, resp );
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		
		 // 화면이동 - isRedirext() 값에 따라 sendRedirect 또는 forward를 사용
        // sendRedirect : 새로운 페이지에서는 request와 response객체가 새롭게 생성된다.
        // forward : 현재 실행중인 페이지와 forwad에 의해 호출될 페이지는 request와 response 객체를 공유
		
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

