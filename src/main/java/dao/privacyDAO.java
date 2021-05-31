package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import dto.PrivacyDTO;

public class privacyDAO {

	DataSource ds;
	Connection con;
	private static privacyDAO privacyDAO;


	private privacyDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static privacyDAO getInstance(){
		if(privacyDAO == null){
			privacyDAO = new privacyDAO();
		}
		return privacyDAO;
	}
	
	//글의 개수 구하기.
		public int selectListCount() {

			int listCount= 0;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try{


				System.out.println("getConnection");
				pstmt=con.prepareStatement("select count(*) from privacy");
				rs = pstmt.executeQuery();

				if(rs.next()){
					listCount=rs.getInt(1);
				}
			}catch(Exception ex){
				System.out.println("getListCount 에러: " + ex);			
			}finally{
				close(rs);
				close(pstmt);
			}

			return listCount;

		}
}