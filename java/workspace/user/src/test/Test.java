package test;

import dao.UserDAO;

public class Test {
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		if(dao.checkId("ljh1234")) {
			System.out.println("중복된 아이디");
		}else {
			System.out.println("사용 가능한 아이디");
		}
	}
}
