package day05;

import java.util.Iterator;

public class ForTest {
	public static void main(String[] args) {
		//이름 10번 출력하되, 이름 앞에 1~10까지 번호를 붙여서 출력한다.
	    //초기값은 0으로 하고 1씩 증가한다.
		for (int a = 0; a < 10; a++) {
			System.out.println(a+1 + ". 이주홍");
		}
		System.out.println();
		
		//이름 10번 출력하되, 이름 앞에 10~1까지 번호를 붙여서 출력한다.
	    //초기값은 0으로 하고 1씩 증가한다.
		for (int a = 0; a < 10; a++) {
			System.out.println((10-a) + ". 이주홍");
		}
	}
}
