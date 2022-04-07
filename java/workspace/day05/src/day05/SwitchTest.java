package day05;

import java.util.Scanner;

public class SwitchTest {
   public static void main(String[] args) {

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
      
      switch (choice) {
      case 1:
    	  result = redMsg;
    	  System.out.println(1);
    	  break;
      case 2:
    	  result = yellowMsg;
    	  System.out.println(2);
    	  break;
      case 3:
    	  result = blackMsg;
    	  System.out.println(3);
    	  break;
      case 4:
    	  result = whiteMsg;
    	  System.out.println(4);
    	  break;
      default:
    	  result = errMsg;
    	  break;
	}
      
      System.out.println(result);
      
   
   }
}