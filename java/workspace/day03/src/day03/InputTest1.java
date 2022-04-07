package day03;

import java.util.Scanner;

public class InputTest1 {
	public static void main(String[] args) {
		// 자동 임포트 단축키 : ctrl + shift + o
		// 사용하지 않는 import들은 자동으로 삭제해준다.
		
		// 이름 한 번에 변경 : alt + shift + r
		// 이름 변경 후 엔터
		
		/*
		 * 정수 : 0
		 * 실수 : 0.0
		 * 문자 : ' '
		 * 문자열 : "", null
		 */
		Scanner scan = new Scanner(System.in);
		String lastName = "";
		String firstName = "";
		
		System.out.print("이름 : ");
		lastName = scan.next();
		firstName = scan.next();
		System.out.println(lastName + firstName + "님 안녕하세요");
	}
}











