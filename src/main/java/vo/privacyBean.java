package vo;

import java.sql.Timestamp;

public class privacyBean {
	private String MEMBER_ID; // ID 기본키
	private String MEMBER_PW; // 비밀번호
	private String MEMBER_ADD; // 주소
	private String MEMBER_TEL; // 전화번호
	private String MEMBER_AGE; // 직급
	private int PRIVACY_NUM; //번호
	private String PRIVACY_NAME; //이름
	private String PRIVACY_TEL; // 전화번호
	private String PRIVACY_Company_Name; //소속명
	private String PRIVACY_RANK; // 직급
	private Timestamp PRIVACY_DATE; // 명함 생성 날짜
	
	public String getMEMBER_ID() {
		return MEMBER_ID;
	}
	
	public void setMEMBER_ID(String MEMBER_id) {
		MEMBER_ID = MEMBER_id;
	}
	
	public String getMEMBER_PW() {
		return MEMBER_ID;
	}
	
	public void setMEMBER_PW(String MEMBER_pw) {
		MEMBER_PW = MEMBER_pw;
	}
	
	public String getMEMBER_ADD() {
		return MEMBER_ADD;
	}
	
	public void setMEMBER_ADD(String MEMBER_add) {
		MEMBER_ADD = MEMBER_add;
	}
	
	public String getMEMBER_TEL() {
		return MEMBER_TEL;
	}
	
	public void setMEMBER_TEL(String MEMBER_tel) {
		MEMBER_TEL = MEMBER_tel;
	}
	
	public String getMEMBER_AGE() {
		return MEMBER_AGE;
	}
	
	public void setMEMBER_AGE(String MEMBER_age) {
		MEMBER_AGE = MEMBER_age;
	}
	
	public int getPRIVACY_NUM() {
		return PRIVACY_NUM;
	}
	
	public void setPRIVACY_NUM(int PRIVACY_num) {
		PRIVACY_NUM = PRIVACY_num;
	}
		
	public String getPRIVACY_TEL() {
		return PRIVACY_TEL;
	}
	
	public void setPRIVACY_TEL(String PRIVACY_TEL) {
		this.PRIVACY_TEL = PRIVACY_TEL;
	}
	
	public String getPRIVACY_NAME() {
		return PRIVACY_NAME;
	}
	public void setPRIVACY_NAME(String PRIVACY_Name) {
		this.PRIVACY_NAME = PRIVACY_Name;
	}
	
	public String getPRIVACY_Company_Name() {
		return PRIVACY_Company_Name;
	}
	public void setPRIVACY_Company_Name(String PRIVACY_Company_Name) {
		this.PRIVACY_Company_Name = PRIVACY_Company_Name;
	}
	
	public String getPRIVACY_RANK() {
		return PRIVACY_RANK;
	}
	public void setPRIVACY_RANK(String PRIVACY_RANK) {
		this.PRIVACY_RANK = PRIVACY_RANK;
	}
		
	public Timestamp getPRIVACY_DATE() {
		return PRIVACY_DATE;
	}
	
	public void setPRIVACY_DATE(Timestamp PRIVACY_date) {
		PRIVACY_DATE = PRIVACY_date;
	}
}
