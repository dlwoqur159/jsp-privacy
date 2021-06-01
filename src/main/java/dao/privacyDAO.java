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
			pstmt.setString(4, dto.getPRIVACY_NAME());
			pstmt.setString(5, dto.getPRIVACY_TEL());
			pstmt.setString(6, dto.getPRIVACY_Company_Name());
			pstmt.setString(7, dto.getPRIVACY_RANK());
			pstmt.setDate(8, dto.getPRIVACY_BIRTH());
			pstmt.setTimestamp(9, dto.getPRIVACY_DATE());
			pstmt.setInt(10, dto.PRIVACY_ADMIN());
					
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(pstmt != null) {pstmt.close();}
			if(con != null) {con.close();}
		}
		
		return false;
	}
	
	//로그인 기능
	public int userCheck(String id, String pw) throws SQLException{
		String sql = null;
		int x=-1;
		
		try {
			con=ds.getConnection();
			sql = "select PRIVACY_PW from privacy where PRIVACY_PW = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			if(rs.next()) {
				String privacypw=rs.getString("PRIVACY_PW");
				if(privacypw.equals(pw)) {
					x=1;
				}else {
					x=0;
				}
			}else {
				x=-1;
			}
			return x;
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(pstmt != null) {pstmt.close();}
			if(rs != null) {rs.close();}
			if(con != null) {con.close();}
		}
		
		
		return -1;
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