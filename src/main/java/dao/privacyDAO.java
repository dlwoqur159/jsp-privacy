package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import dto.PrivacyDTO;
import javax.naming.Context;
import javax.naming.InitialContext;

public class privacyDAO {

	DataSource ds;
	PreparedStatement pstmt=null;
	Connection con = null;
	ResultSet rs = null;
	private static privacyDAO privacyDAO;

	//DB 연동?
	private privacyDAO() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/nev");
			ds=(DataSource)envCtx.lookup("jdbc/MySQLDB");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//회원가입 기능
	private boolean insertPrivacy(PrivacyDTO dto) throws SQLException{
		String sql = null;
		
		try {
			con = ds.getConnection();
			sql = "insert into privacy values " + "(?,?,?,?,?,?,?,?,?,?)"; //10개
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getPRIVACY_NUM());
			pstmt.setString(2, dto.getPRIVACY_ID());
			pstmt.setString(3, dto.getPRIVACY_PW());
			pstmt.setString(4, dto.getPRIVACY_Name());
			pstmt.setString(5, dto.getPRIVACY_TEL());
			pstmt.setString(6, dto.getPRIVACY_PW());
			pstmt.setString(7, dto.getPRIVACY_PW());
					
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(pstmt != null) {pstmt.close();}
			if(con != null) {con.close();}
		}
		
		return false;
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