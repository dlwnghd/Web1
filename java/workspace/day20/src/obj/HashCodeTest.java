package obj;

import java.util.Random;

public class HashCodeTest {
	public static void main(String[] args) {
		Random r1 = new Random();
		Random r2 = new Random();
		
		String s1 = "ABC";
		String s2 = "ABC";
		String s3 = new String("ABC");
		String s4 = new String("ABC");
		String s5 = new String("AAA");
		
		System.out.println(r1);						// r1의 주소값이 나옴
		System.out.println(r1.hashCode());	// r1이 아스키코드로 변환되어 나옴
		System.out.println(r2.hashCode());
		
		//String 클래스에서는 필드의 주소가 아닌,
		//상수의 주소를 리턴하도록 재정의되었다.
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());
		System.out.println(s5.hashCode());
	}
}
