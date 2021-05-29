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
	private Date PRIVACY_BRITH;
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
	public void setPRIVACY_FILE(String PRIVACY_rank) {
		this.PRIVACY_RANK = PRIVACY_rank;
	}
	
	public Date getPRIVACY_BRITH() {
		return PRIVACY_BRITH;
	}
	
	public void setPRIVACY_BRITH(Date PRIVACY_BRITH) {
		this.PRIVACY_BRITH = PRIVACY_BRITH;
	}
	
	
	public Date getPRIVACY_DATE() {
		return PRIVACY_DATE;
	}
	
	public void setPRIVACY_DATE(Date PRIVACY_date) {
		PRIVACY_DATE = PRIVACY_date;
	}
	
}