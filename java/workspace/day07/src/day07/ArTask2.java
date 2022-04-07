package day07;

import java.util.Scanner;

public class ArTask2 {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		// 사용자에게 입력받은 문자열 중 소문자는 모두 대문자로,
		// 대문자는 모두 소문자로 변경한다.
		// 알파벳이 아닌 문자들은 그대로 유지한다.
//		System.out.print("알파벳으로 이루어진 문자열 입력 : ");
//		String text = sc.next();
//		String answer = "";
//		for (int i = 0; i < text.length(); i++) {
////			소문자 -> 대문자
//			if(text.charAt(i) >= 97 && text.charAt(i) <= 122) {
//				answer += (char)(text.charAt(i)-32);
//			}else if(text.charAt(i) >= 65 && text.charAt(i) <= 90) {		// 대문자 -> 소문자
//				answer += (char)(text.charAt(i)+32);				
//			}else {
//				System.out.println("알파벳 외에 다른 값이 포함되어 있습니다!");
//			}
//		}
//		System.out.println(answer);

		// 정수를 한글로 변경
		// 입력 예) 1024
		// 출력 예) 일공이사
		
////		내 풀이
//		String num = "공일이삼사오육칠팔구", answer = "";
//		System.out.print("한글로 숫자 입력 : ");
//		String text = sc.next();
//
//		for (int i = 0; i < text.length(); i++) {
//			answer += num.charAt(text.charAt(i)-48);
//		}
//		System.out.println(answer);

		// 강사님 풀이
		// 정수를 한글로 변경
	      // 입력 예) 1024
	      // 출력 예) 일공이사
	      
	      String hangle = "공일이삼사오육칠팔구";
	      Scanner sc = new Scanner(System.in);
	      int num = 0;
	      String result = "";
	      
	      System.out.print("정수 : ");
	      num = sc.nextInt();
//	      
//	      //1회차
//	      // 1024 % 10 == 4
//	      // 1024 / 10 == 102
//	      
//	      //2회차
//	      //102 % 10 == 2
//	      //102 / 10 == 10
//	      
//	      //3회차
//	      //10 % 10 == 0
//	      //10 / 10 == 1
//	      
//	      //4회차
//	      //1 % 10 == 1
//	      //1 / 10 == 0
//	      
//	      //몫이 0일 때까지 반복
//	      
	      while(num != 0) {
	         result = hangle.charAt(num % 10) + result;
	         num /= 10;
	      }
	      System.out.println(result);
	}
}
