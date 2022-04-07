package day04;

import java.util.Scanner;

public class IfTest2 {
   public static void main(String[] args) {
      //심리 테스트
      /*
       * Q.당신이 좋아하는 색을 선택하세요.
       * 1. 빨간색
       * 2. 노란색
       * 3. 검은색
       * 4. 흰색
       * 
       * 빨간색 : 불같고 열정적이고 적극적이다.
       * 노란색 : 발랄하고 밝고 귀엽고 개성있고 유하다.
       * 검은색 : 묵묵하고 든든하고 냉철하고 멋지다 그리고 강하다.
       * 흰색 : 천사같고 깔끔하고 정리를 좋아하고 배려심이 많다.
       * 
       */
      
      String qMsg = "Q.당신이 좋아하는 색을 선택하세요.\n";
      String choiceMsg = "1. 빨간색\n" + 
                           "2. 노란색\n" + 
                           "3. 검은색\n" + 
                           "4. 흰색";
      
      String redMsg = "불같고 열정적이고 적극적이다.";
      String yellowMsg = "발랄하고 밝고 귀엽고 개성있고 유하다.";
      String blackMsg = "묵묵하고 든든하고 냉철하고 멋지다 그리고 강하다.";
      String whiteMsg = "천사같고 깔끔하고 정리를 좋아하고 배려심이 많다.";
      String errMsg = "다시 시도해주세요";
      
      String result = "";
      
      Scanner sc = new Scanner(System.in);
      int choice = 0;
      
      System.out.println(qMsg + choiceMsg);
      choice = sc.nextInt();
      
      if(choice == 1) {
    	  result = redMsg;
      }else if(choice == 2) {
    	  result = yellowMsg;
      }else if(choice == 3) {
    	  result = blackMsg;
      }else if(choice == 4) {
    	  result = whiteMsg;    	  
      }else {
    	  result = errMsg;
      }
                  
      System.out.println(result);
   }
}
















