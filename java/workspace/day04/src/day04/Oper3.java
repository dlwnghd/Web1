package day04;

import java.util.Scanner;

public class Oper3 {
   public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   int choice = sc.nextInt();
	   
	   System.out.println("Q.당신이 좋아하는 색을 선택하세요.\r\n"
	   		+ "1. 빨간색\r\n"
	   		+ "2. 노란색\r\n"
	   		+ "3. 검은색\r\n"
	   		+ "4. 흰색");
	    String result = "";
	   
	   result = choice == 1 ? "빨간색 : 불같고 열정적이고 적극적이다." :
		   choice == 2 ? "노란색 : 발랄하고 밝고 귀엽고 개성있고 유하다." :
			   choice == 3 ? "검은색 : 묵묵하고 든든하고 냉철하고 멋지다 그리고 강하다." :
				   choice == 4 ? "흰색 : 천사같고 깔끔하고 정리를 좋아하고 배려심이 많다." : "잘못 입력하셨습니다.";
	   System.out.println(result);
   }
}