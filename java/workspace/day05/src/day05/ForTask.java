package day05;

import java.util.Scanner;

public class ForTask {
	public static void main(String[] args) {
		// 브론즈
		// 1~100까지 출력
//		for(int i = 0; i < 100; i++) {
//			System.out.println(i+1);
//		}

		// 100~1까지 출력
//		for(int i = 0; i < 100; i++) {
//			System.out.println(100-i);
//		}

		// 1~100까지 중 짝수만 출력
//		for(int i = 2; i<=100; i= i + 2) System.out.println(i);

		// 실버
		// 1~10까지 합 출력
//		int i = 0;
//		for(int a = 0; a <= 10; a++) {
//			i = i+a;
//		}
//		System.out.println(i);

		// 1~n까지 합 출력 -> 누적 연산자
//		Scanner sc = new Scanner(System.in);
//		int sum = 0;
//		
//		System.out.println("n 입력 : ");
//		int n = sc.nextInt();
//		for(int a = 0; a <= n; a++) sum += a;
//		System.out.println(sum);

		// 골드
		// A~F까지 출력
//		for(int i = 65; i <71; i++ ) {
//			System.out.println((char)i);
//		}
		
		// A~F중 C제외하고 출력
//		for(int i = 65; i <71; i++ ) {
//			if(i == 67) {
//				i++;
//			}
//			System.out.println((char)i);
//		}
		
		// 다이아
		// 0 1 2 3 0 1 2 3 0 1 2 3 출력
//		for (int i = 0; i < 12; i++) {
//			System.out.print(i % 4 + " ");
//		}

		// aBcDeFg...Z 출력
		for (int i = 0; i < 26; i++) {
//			 if문 풀이
//			if (i % 2 == 0) {
//				System.out.print((char) (i + 97));
//			} else {
//				System.out.print((char) (i + 65));
//			}
//			 삼항 연산자 풀이
			System.out.print((char)(i%2==0 ? i+97 : i+65));
		}

	}
}
