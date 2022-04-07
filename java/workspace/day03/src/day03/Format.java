package day03;

public class Format {
	public static void main(String[] args) {
		String name = "한동석";
		int age = 20;
		double height = 125.68;
		
		System.out.printf("이름 : %s\n", name);
		//나이를 서식문자로 활용해서 출력
		System.out.printf("나이 : %d살\n", age);
		//소수점을 자를 때에는 반올림된다.
		System.out.printf("몸무게 : %.1fcm\n", height);
		
	}
}
