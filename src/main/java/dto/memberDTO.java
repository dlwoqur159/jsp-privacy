package dto;

//id pw address tel age
public class memberDTO {
	
	private String MEMBER_ID; // ID �⺻Ű
	private String MEMBER_PW; // ��й�ȣ
	private String MEMBER_ADD; // �ּ�
	private String MEMBER_TEL; // ��ȭ��ȣ
	private int MEMBER_AGE; // ����
	
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
	
	public int getMEMBER_AGE() {
		return MEMBER_AGE;
	}
	
	public void setMEMBER_TEL(int MEMBER_age) {
		MEMBER_AGE = MEMBER_age;
	}

}
