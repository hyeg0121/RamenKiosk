package kiosk;

public class Manager {
	
	private static int pw = 1234; //초기 비밀번호 설정

	public static int getPw() {
		return pw;
	}

	public void setPw(int pw) {
		this.pw = pw;
	}
	
}
