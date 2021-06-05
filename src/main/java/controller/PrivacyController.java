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
/*
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	*/
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String RequestURI=req.getRequestURI();
		String contextPath=req.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		ActionForward forward= null;
		Action action=null;
		
		
		if(command.equals("/Login.do")){
			forward=new ActionForward();
			forward.setPath("/WEB-INF/member/Login.jsp");
			forward.setRedirect(false);
		}else if(command.equals("/Join.do")){
			forward=new ActionForward();
			forward.setPath("/WEB-INF/member/Join.jsp");
			forward.setRedirect(false);
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
		
		 // ȭ���̵� - isRedirext() ���� ���� sendRedirect �Ǵ� forward�� ���
        // sendRedirect : ���ο� ������������ request�� response��ü�� ���Ӱ� �����ȴ�.
        // forward : ���� �������� �������� forwad�� ���� ȣ��� �������� request�� response ��ü�� ����
		
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

