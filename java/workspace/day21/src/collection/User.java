package collection;

public class User {
	//이름
	private String name;
	//아이디
	private String id;
	//비밀번호
	private String pw;
	//휴대폰 번호
	private String phone;
	
	//클래스이름 살짝 치고 ctrl + space bar, 엔터
	public User() {;}

	//alt + shift + s, r, alt + a, alt + r	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
