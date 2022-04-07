package day04;

import java.util.Scanner;

public class Oper4 {
   public static void main(String[] args) {
      // 사용자에게 키를 입력받고
      // 정수면 정수로 출력, 실수면 실수로 출력.
      // ※ 삼항 연산자 사용
      
      // 예)
      // 183 --> 183 출력
      // 183.5 --> 183.5 출력
	   Scanner sc = new Scanner(System.in);	// Scanner 출력
	   String result = "";	// String타입의 result는 ""
	   
	   System.out.println("키 입력 : ");	// 사용자로부터 키 값 입력 유도
	   double height = sc.nextDouble();	// 입력한 값을 double타입의 height로 정의
	   
	   result = (int)height >= height ? (int)height+"" : height+"";	// result는 height를 int화한 값이 height값보다 크거나 같다면 정수 아니라면 실수형태로 출력
	   System.out.println(result);
	  
	   // 선생님 풀이
//	   //키를 저장할 변수 선언(double 8byte)
//	      double height = 0.0;
//	      //실수인지 정수인지를 담아줄 변수(boolean 1byte)
//	      boolean check = false;
//	      //서식문자를 담아줄 변수
//	      String format = "";
//	      String msg = "키 : ";
//	      Scanner sc = new Scanner(System.in);
//	      
//	      System.out.print(msg);
//	      //사용자에게 실수를 입력하고 height에 담아주기 
//	      height = sc.nextDouble();
//	      
//	      check = height - (int)height == 0;
//	      
//	      format = check ? "%.0fcm" : "%.1fcm";
//	      
//	      System.out.printf(format, height);

   }
}