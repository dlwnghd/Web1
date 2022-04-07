package day03;

import java.util.Scanner;

public class InputTest2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = "";
		
		System.out.print("이름 : ");
		name = sc.nextLine();
		System.out.println(name + "님 환영합니다.");
	}
}
