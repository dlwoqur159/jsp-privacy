package svc;

import java.sql.Connection;
import dao.privacyDAO;
import vo.privacyBean;
import static db.JdbcUtil.*;

public class ServicePrivacyWritePro {
	
	public boolean registArticle(privacyBean privacybean) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isWriteSuccess = false;
		Connection con = getConnection();
		privacyDAO pdao = privacyDAO.getInstance();
		pdao.setConnection(con);
		int insertCount = pdao.insertArticle(privacybean);
		
		if(insertCount > 0){
			commit(con);
			isWriteSuccess = true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isWriteSuccess;
		
	}

}
