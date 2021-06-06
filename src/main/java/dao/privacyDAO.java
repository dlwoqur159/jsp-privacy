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
	private static privacyDAO privacyDAO;

	public static privacyDAO getInstance(){
		if(privacyDAO == null){
			privacyDAO = new privacyDAO();
		}
		return privacyDAO;
	}

	public void setConnection(Connection con){
		this.con = con;
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
	
	//글 목록 보기.	
		public ArrayList<privacyBean> selectArticleList(int page,int limit){

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String privacy_list_sql="select * from privacy order by PRIVACY_NUM desc limit ?,10";
			ArrayList<privacyBean> articleList = new ArrayList<privacyBean>();
			privacyBean privacy = null;
			int startrow=(page-1)*10; //읽기 시작할 row 번호..	

			try{
				pstmt = con.prepareStatement(privacy_list_sql);
				pstmt.setInt(1, startrow);
				rs = pstmt.executeQuery();

				while(rs.next()){
					privacy = new privacyBean();
					privacy.setPRIVACY_NUM(rs.getInt("PRIVACY_NUM"));
					privacy.setPRIVACY_NAME(rs.getNString("PRIVACY_NAME"));
					privacy.setPRIVACY_TEL(rs.getNString("PRIVACY_TEL"));
					privacy.setPRIVACY_Company_Name(rs.getString("PRIVACY_Company_Name"));
					privacy.setPRIVACY_RANK(rs.getString("PRIVACY_RANK"));
					privacy.setPRIVACY_DATE(rs.getTimestamp("PRIVACY_DATE"));
					articleList.add(privacy);
				}

			}catch(Exception ex){
				System.out.println("getBoardList 에러 : " + ex);
			}finally{
				close(rs);
				close(pstmt);
			}

			return articleList;

		}
	
	
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

			sql = "insert into member values " + "(?,?,?,?,?,?)"; //10��
		
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getMEMBER_ID());
			pstmt.setString(2, bean.getMEMBER_PW());
			pstmt.setString(3, bean.getMEMBER_NAME());
			pstmt.setString(4, bean.getMEMBER_ADD());
			pstmt.setString(5, bean.getMEMBER_TEL());
			pstmt.setString(6, bean.getMEMBER_AGE());
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
				member.setMEMBER_NAME(rs.getString("MEMBER_NAME()"));
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
	
		
		
		
		

}