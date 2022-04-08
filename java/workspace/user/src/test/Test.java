package test;

import dao.UserDAO;
import vo.UserVO;

public class Test {
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		UserVO user1 = null;
//		if(dao.checkId("ljh1234")) {
//			System.out.println("중복된 아이디");
//		}else {
//			System.out.println("사용 가능한 아이디");
//		}
		dao.findPw("hds1234", "4567");
		dao.updateInfo(null);
//		System.out.println();
	}
}
