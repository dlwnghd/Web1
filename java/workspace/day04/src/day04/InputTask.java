package day04;

import java.util.Scanner;

public class InputTask {
   public static void main(String[] args) {
      // [숙제]
      // 한 번에 두 개의 정수를 입력받는다.
      // 입력 예) 1 2
      // 출력 예) 1 * 2 = 2
      
      String msg = "두 정수를 예시와 같이 입력하세요\n예)13 24";
      String format = "%d * %d = %d";
      Scanner sc = new Scanner(System.in);
      int num1 = 0, num2 = 0, result = 0;
      
      System.out.println(msg);
      num1 = sc.nextInt();   //nextInt() : 사용자가 입력한 정수값
      num2 = sc.nextInt();
      
      result = num1 * num2;
      
      System.out.printf(format, num1, num2, result);
   }
}














