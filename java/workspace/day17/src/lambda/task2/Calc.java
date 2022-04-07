package lambda.task2;

import java.util.Scanner;

public class Calc {
	
   //외부에서 연산자를 전달받는다.
   public static MyMath calculator(String oper) {
      MyMath math = null;
      
      switch(oper) {
      //+일 경우
      case "+":
         math = (num1, num2) -> num1 + num2;
         break;
      //-일 경우
      case "-":
         math = (num1, num2) -> num1 - num2;
         break;
      
      }
      
      return math;
   }
   
   public static void main(String[] args) {
      //람다식으로 구현
      OperCheck opercheck = (expression) -> {
         String temp = "";
         for (int i = 0; i < expression.length(); i++) {
            //전체 식의 각 문자를 c에 담아준다.
            char c = expression.charAt(i);
            //혹시 +(43)이거나 -(45)이라면
            //연산자라는 뜻이므로
            if(c == 43 || c == 45) {
               //temp에 해당 연산자를 누적하여 연결해준다.
               temp += c;
            }
         }
         //만약 사용자가 3+9-6을 입력하였다면,
         //temp에는 "+-"가 담겨있고,
         //temp.split("")을 하면 각 문자 모두를 분리해주기 때문에
         //String[] opers = {"+", "-"}라는 결과가 나온다.
         return temp.split(""); //이 문자열 배열을 리턴해준다.
      };
      
      String[] nums = null;
      String[] opers = null;
      int num1 = 0, num2 = 0;
      String expression = null;
      String msg = "정수의 덧셈, 뺄셈에 대한 식을 입력하세요";
      String exMsg = "예)7+65-8";
      Scanner sc = new Scanner(System.in);
      
      System.out.println(msg);
      System.out.println(exMsg);
      //사용자가 입력한 전체 수식
      expression = sc.next();
      //전체 수식 중 연산자를 기준으로 앞 뒤를 잘라준다.
      //각 문자열 값은 연산이 필요한 정수들이다.
      nums = expression.split("\\+|\\-");
      //연산자만 추출하여 opers에 담아준다.
      opers = opercheck.getOpers(expression);
      
      //1. nums[0]이 ""값과 다르다면, 양수로 시작하는 수식
      //      첫번째 값을 정수로 변환하여 num1에 저장
      //2. nums[0]이 ""값과 같다면, 음수로 시작하는 수식
      //      첫번째 연산자(-)와 두번째 값(정수)을 연결하여 음수로 바꾼 후
      //      정수로 변환해준다.
      num1 = Integer.parseInt(nums[0].equals("") ? opers[0] + nums[1] : nums[0]);
      
      for (int i = 0; i < opers.length; i++) {
         //만약 첫번째 정수가 음수이고, 첫번째 반복일 경우
         //""에 연산을 하기 때문에 다음 반복으로 넘어가준다.
         if(i == 0 && num1 < 0) {continue;}
         //두 번째 정수는 nums의 두 번째에 위치하기 때문에 i+1로 접근한다.
         num2 = Integer.parseInt(nums[i + 1]);
         //calculator 메소드에 연산자 한 개를 전달한다.
         //전달한 연산자에 따라 덧셈 결과 또는 뺄셈 결과를 리턴하는 calc를 바로 사용해준다.
         num1 = calculator(opers[i]).calc(num1, num2);   //매 반복마다 num2가 변하고 num1은 이전의 결과값을 담아놓도록 한다.
      }
      //연산 결과를 출력한다.
      System.out.println(num1);
   }
}











