package day04;

import java.util.Scanner;

public class IfTest1 {
   public static void main(String[] args) {
      String n1Msg = "첫번째 정수 : ", n2Msg = "두번째 정수 : ";
      int num1 = 0, num2 = 0;
      String result = "";
      Scanner sc = new Scanner(System.in);
      
      System.out.print(n1Msg);
      num1 = sc.nextInt();
      
      System.out.print(n2Msg);
      num2 = sc.nextInt();
      
      if(num1 > num2) {
    	  result = "더 큰 값 : " + num1;
      }else if(num2 != num1) {
    	  result = "더 큰 값 : " + num2;    	  
      }else {
    	  result = "두 수가 같습니다";
      }
      
      System.out.println(result);
   }
}