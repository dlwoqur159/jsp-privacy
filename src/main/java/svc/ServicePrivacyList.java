package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import dao.privacyDAO;
import vo.privacyBean;

public class ServicePrivacyList {

	public int getListCount() throws Exception{
		// TODO Auto-generated method stub
		
		int listCount = 0;
		Connection con = getConnection();
		privacyDAO privacyDAO = dao.privacyDAO.getInstance();
		privacyDAO.setConnection(con);
		listCount = privacyDAO.selectListCount();
		close(con);
		return listCount;
		
	}

	public ArrayList<privacyBean> getArticleList(int page, int limit) throws Exception{
		
		ArrayList<privacyBean> articleList = null;
		Connection con = getConnection();
		privacyDAO privacyDAO = dao.privacyDAO.getInstance();
		privacyDAO.setConnection(con);
		articleList = privacyDAO.selectArticleList(page,limit);
		close(con);
		return articleList;
		
	}

}
