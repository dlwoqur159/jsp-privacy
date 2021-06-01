package dto;
import java.sql.Date;
public class PrivacyDTO {

	private int PRIVACY_NUM;
	private String PRIVACY_ID;
	private String PRIVACY_PW;
	private String PRIVACY_NAME;
	private String PRIVACY_TEL;
	private String PRIVACY_Company_Name;
	private String PRIVACY_RANK;
	private Date PRIVACY_BIRTH;
	private Date PRIVACY_DATE;
	
	public int getPRIVACY_NUM() {
		return PRIVACY_NUM;
	}
	
	public void setPRIVACY_NUM(int PRIVACY_num) {
		PRIVACY_NUM = PRIVACY_num;
	}
	
	public String getPRIVACY_ID() {
		return PRIVACY_ID;
	}
	
	public void setPRIVACY_ID(String PRIVACY_ID) {
		this.PRIVACY_ID = PRIVACY_ID;
	}
	
	public String getPRIVACY_PW() {
		return PRIVACY_PW;
	}
	
	public void setPRIVACY_PW(String PRIVACY_PW) {
		this.PRIVACY_PW = PRIVACY_PW;
	}
	
	public String getPRIVACY_NAME() {
		return PRIVACY_NAME;
	}
	
	public void setPRIVACY_NAME(String PRIVACY_NAME) {
		this.PRIVACY_NAME = PRIVACY_NAME;
	}
	
	public String getPRIVACY_TEL() {
		return PRIVACY_TEL;
	}
	
	public void setPRIVACY_TEL(String PRIVACY_TEL) {
		this.PRIVACY_TEL = PRIVACY_TEL;
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
	
	public Date getPRIVACY_BIRTH() {
		return PRIVACY_BIRTH;
	}
	
	public void setPRIVACY_BRIRH(Date PRIVACY_BIRTH) {
		this.PRIVACY_BIRTH = PRIVACY_BIRTH;
	}
	
	
	public Date getPRIVACY_DATE() {
		return PRIVACY_DATE;
	}
	
	public void setPRIVACY_DATE(Date PRIVACY_date) {
		PRIVACY_DATE = PRIVACY_date;
	}
	
}