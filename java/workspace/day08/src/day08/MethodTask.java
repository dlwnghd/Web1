package day08;

import java.util.Scanner;

public class MethodTask {
   
   // 아이언
   // 1~10까지 println()으로 출력하는 메소드
   void printFrom1To10(){
      for (int i = 0; i < 10; i++) {
         System.out.println(i + 1);
      }
   }
   
   // "홍길동"을 n번 println()으로 출력하는 메소드
   void printHong(int count) {
      for (int i = 0; i < count; i++) {
         System.out.println("홍길동");
      }
   }
   
   // 브론즈
   // 이름을 n번 println()으로 출력하는 메소드
   void printName(String name, int count) {
      for (int i = 0; i < count; i++) {
         System.out.println(name);
      }
   }
   
   // 세 정수의 뺄셈을 해주는 메소드
   int sub(int num1, int num2, int num3) {
      int result = num1 - num2 - num3;
      return result;
   }
   
   // 실버
   // 두 정수의 나눗셈을 해주는 메소드(몫과 나머지)
   int[] div(int num1, int num2) {
      int[] result = new int[2];
      result[0] = num1 / num2;
      result[1] = num1 % num2;
      
      return result;
   }
   
   // 1~n까지의 합을 구해주는 메소드
   int sumFrom1(int end) {
      int total = 0;
      for (int i = 0; i < end; i++) {
         total += i + 1;
      }
      return total;
   }
   
   // 골드
   // 홀수를 짝수로, 짝수를 홀수로 바꿔주는 메소드
   int change(int num) {
      return ++num;
   }
   
   // 문자열을 입력받고 소문자는 대문자로, 대문자는 소문자로 바꿔주는 메소드
   String changeString(String str) {
      char c = ' ';
      String result = "";
      
      for (int i = 0; i < str.length(); i++) {
         c = str.charAt(i);
         if(c >= 65 && c <= 90) {
            result += (char)(c + 32);
         }else if(c >= 97 && c <= 122) {
            result += (char)(c - 32);
         }else {
            result += c;
         }
      }
      
      return result;
   }
   
   // 플래티넘
   // 문자열을 입력받고 원하는 문자의 개수를 구해주는 메소드
   int getCount(String str, char c) {
      int count = 0;
      for (int i = 0; i < str.length(); i++) {
         if(str.charAt(i) == c) {
            count ++;
         }
      }
      
      return count;
   }
   
   // 5개의 정수를 입력받은 후 원하는 번째 값을 구해주는 메소드
   int getValue(int[] arNum, int index) {
      return arNum[index - 1];
   }
   
   // 다이아
   // 한글을 정수로 바꿔주는 메소드
   // 입력 예) 일공이사
   // 출력 예) 1024
   // ※ String 클래스의 indexOf()메소드를 구글링하여 사용한다.
   int changeToInteger(String hangle) {
      String hangleOriginal = "공일이삼사오육칠팔구";
      String result = "";
      
      for (int i = 0; i < hangle.length(); i++) {
         result += hangleOriginal.indexOf(hangle.charAt(i));
      }
      return Integer.parseInt(result);
   }
   
   // 마스터
   // 5개의 정수를 입력받고 최대값과 최소값을 구해주는 void형 메소드
   // 메소드 안에서 출력하지 않는다.
   // 리턴 타입은 void이다.
   
   void getMaxAndMin(int[] arNum, int[] result) {
      result[0] = arNum[0];
      result[1] = arNum[0];
      
      for (int i = 1; i < arNum.length; i++) {
         if(result[0] < arNum[i]) { result[0] = arNum[i]; }
         if(result[1] > arNum[i]) { result[1] = arNum[i]; }
      }
   }
   
//   void test(int[] data) {
//      data[0] = 20;
//   }
   
   public static void main(String[] args) {
      MethodTask mt = new MethodTask();
//      int[] arNum = {3, 5, 1, 2, 6};
//      
//      System.out.println(mt.getValue(arNum, 4));
      
//      int[] result = new int[2];
//      int[] arNum = {3, 5, 1, 2, 6};
//      
//      mt.getMaxAndMin(arNum, result);
//      
//      System.out.println("최대값 : " + result[0]);
//      System.out.println("최소값 : " + result[1]);
      
      
//      int[] data = {10};
//      mt.test(data);
//      System.out.println(data[0]);
      
//      int[] result = new int[2];
      
//      Scanner sc = new Scanner(System.in);
//      
//      System.out.print("한글(정수형식) : ");
//      System.out.println(mt.changeToInteger(sc.next()));
      
//      int result = mt.change(31);
//      
//      if(result % 2 == 0) {
//         System.out.println("짝수로 변경되었습니다.");
//      }else {
//         System.out.println("홀수로 변경되었습니다.");
//      }
      
   }
}











