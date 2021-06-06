package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import vo.privacyBean;
import javax.naming.Context;
import javax.naming.InitialContext;

public class privacyDAO {

	DataSource ds;
	PreparedStatement pstmt=null;
	Connection con = null;
	ResultSet rs = null;
	private static privacyBean privacyBean;


	//DB ����?
	public privacyDAO() {

		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			ds=(DataSource)envCtx.lookup("jdbc/MySQLDB");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	

	//회占쏙옙占쏙옙占쏙옙 占쏙옙占�
	public boolean insertPrivacy(privacyBean bean) throws SQLException{

		String sql = null;
		
		try {
			con = ds.getConnection();

			sql = "insert into member values " + "(?,?,?,?,?)"; //10��
		
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getMEMBER_ID());
			pstmt.setString(2, bean.getMEMBER_PW());
			pstmt.setString(3, bean.getMEMBER_ADD());
			pstmt.setString(4, bean.getMEMBER_TEL());
			pstmt.setString(5, bean.getMEMBER_AGE());
			pstmt.executeUpdate();
			
			return true;
					
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(pstmt != null) {pstmt.close();}
			if(con != null) {con.close();}
		}
		
		return false;

	}
	
	//占싸깍옙占쏙옙 占쏙옙占�
	public int userCheck(String id, String pw) throws SQLException{
		String sql = null;
		int x=-1;
		
		try {
			con=ds.getConnection();
			sql = "select MEMBER_PW from member where MEMBER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String memberpw=rs.getString("MEMBER_PW");
				if(memberpw.equals(pw)) {
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
	
	public int confirmld(String id) throws SQLException{
		String sql=null;
		int x = -1;
		
		try {
			con = ds.getConnection();
			sql = "select MEMBER_ID from member where MEMBER_ID=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,  id);;
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				x=1;
			}else {
				x=-1;
			}
			
			return x;
		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally {
			if(pstmt != null) {pstmt.close();}
			if(rs != null){rs.close();}
			if(con != null) {con.close();}
			}
		return -1;
	}
	
	public privacyBean getMember(String id) throws SQLException{//74
		
		privacyBean member = null;
		String sql = null;
		
		try {
			con=ds.getConnection();
			sql = "select *from member where MEMBER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				member=new privacyBean();
				
				member.setMEMBER_ID(rs.getString("MEMBER_ID()"));
				member.setMEMBER_PW(rs.getString("MEMBER_PW()"));
				member.setMEMBER_ADD(rs.getString("MEMBER_ADD()"));
				member.setMEMBER_TEL(rs.getString("MEMBER_TEL()"));
				member.setMEMBER_AGE(rs.getString("MEMBER_AGE()"));
				
				return member;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) { pstmt.close();}
			if(rs != null) { rs.close();}
			if(con != null) { con.close();}
		}
		
		return null;
	}
	
		
		
		
		
	
	/*
	public static privacyDAO getInstance(){
		if(privacyDAO == null){
			privacyDAO = new privacyDAO();
		}
		return privacyDAO;
	}*/
	
}