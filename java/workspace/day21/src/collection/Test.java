package collection;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		UserField uf = new UserField();
		User user = new User();
		
		Scanner sc = new Scanner(System.in);
		String name = null, id = null, pw = null, phone = null;
		
		System.out.print("이름 : ");
		name = sc.next();
		
		System.out.print("아이디 : ");
		id = sc.next();
		if(uf.checkId(id) != null) {
			System.out.println("중복된 아이디입니다.");
			return;
		}
		
		System.out.print("비밀번호 : ");
		pw = sc.next();
		
		System.out.print("전화번호 : ");
		phone = sc.next();
		
		user.setName(name);
		user.setId(id);
		user.setPw(pw);
		user.setPhone(phone);
		
			uf.join(user);
			System.out.println("회원가입 성공");
		
		System.out.print("아이디 : ");
		id = sc.next();
		
		System.out.print("비밀번호 : ");
		pw = sc.next();
		
		if(uf.login(id, pw)) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
		
	}
}













