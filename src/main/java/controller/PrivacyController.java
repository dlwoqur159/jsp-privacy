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
import action.ActionPrivacyDetail;
import action.ActionPrivacyList;
import action.ActionWritePro;
import action.ActionJoin;
import action.ActionIDCheck;

@WebServlet("*.do")
public class PrivacyController extends javax.servlet.http.HttpServlet {

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
		else if(command.equals("/PrivacyList.do")){
			action = new ActionPrivacyList();
			try{
				forward=action.execute(req, resp);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/PrivacyWriteForm.do")){
			forward=new ActionForward();
			forward.setPath("/WEB-INF/privacy/privacy_write.jsp");
		}
		else if(command.equals("/PrivacyWritePro.do")){
			action  = new ActionWritePro();
			try {
				forward=action.execute(req, resp );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/PrivacyDetailForm.do")){
		forward=new ActionForward();
		forward.setPath("/WEB-INF/privacy/privacy_detail.jsp");
	}
	else if(command.equals("/ActionPrivacyDetail.do")){
		action  = new ActionPrivacyDetail();
		try {
			forward=action.execute(req, resp );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		 // 화占쏙옙占싱듸옙 - isRedirext() 占쏙옙占쏙옙 占쏙옙占쏙옙 sendRedirect 占실댐옙 forward占쏙옙 占쏙옙占�
        // sendRedirect : 占쏙옙占싸울옙 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 request占쏙옙 response占쏙옙체占쏙옙 占쏙옙占쌈곤옙 占쏙옙占쏙옙占싫댐옙.
        // forward : 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 forwad占쏙옙 占쏙옙占쏙옙 호占쏙옙占� 占쏙옙占쏙옙占쏙옙占쏙옙 request占쏙옙 response 占쏙옙체占쏙옙 占쏙옙占쏙옙
		
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

