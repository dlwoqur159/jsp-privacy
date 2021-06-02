package dto;
import java.sql.Date;
import java.sql.Timestamp;

public class PrivacyDTO {

	private int PRIVACY_NUM; //번호
	private String PRIVACY_NAME; //이름
	private String PRIVACY_TEL; // 전화번호
	private String PRIVACY_Company_Name; //소속명
	private String PRIVACY_RANK; // 직급
	private Timestamp PRIVACY_DATE; // 명함 생성 날짜
	
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