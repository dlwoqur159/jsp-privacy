package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.ActionForward;
import action.Action;

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
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/index.jsp");
		rd.forward(req, resp);
	}

}
