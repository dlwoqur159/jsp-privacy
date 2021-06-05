package vo;
// 페이지 이동을 처리하기 위한 클래스
public class ActionForward {
	private boolean isRedirect=false;
	private String path=null; // 이동할 다음 화면
	
	
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