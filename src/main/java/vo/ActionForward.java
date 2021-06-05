package vo;
// ������ �̵��� ó���ϱ� ���� Ŭ����
public class ActionForward {
	private boolean isRedirect=false;
	private String path=null; // �̵��� ���� ȭ��
	
	
	public boolean isRedirect(){
		return isRedirect;
	}
	
	public String getPath(){
		return path;
	}
	
	public void setRedirect(boolean b){
		isRedirect=b;
	}
	
	public void setPath(String string){
		path=string;
	}
}