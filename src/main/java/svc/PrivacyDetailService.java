package svc;

import java.sql.Connection;
import dao.privacyDAO;
import vo.privacyBean;
import static db.JdbcUtil.*;

public class PrivacyDetailService {

   public privacyBean getArticle(int privacy_num) throws Exception{
      // TODO Auto-generated method stub
      
      privacyBean article = null;
      Connection con = getConnection();
      privacyDAO prDAO = privacyDAO.getInstance();
      prDAO.setConnection(con);
      int updateCount = prDAO.updateReadCount(privacy_num);
      
      if(updateCount > 0){
         commit(con);
      }
      else{
         rollback(con);
      }
      
      article = prDAO.selectArticle(privacy_num);
      close(con);
      return article;
      
   }

}