package day04;

public class Oper1 {
	public static void main(String[] args) {
		System.out.println(10 == 11);
		System.out.println(10 != 11);
		System.out.println(10 > 9);
		System.out.println(10 < 9);
		System.out.println(10 < 9 && 10 == 11);
		System.out.println(10 < 9 || !(10 == 11));		// 최단산쉬관리삼대
		
		float a = 1;
		double b = 1.5;
		System.out.println(a);
		System.out.printf("%.0f",b);
	}
}
