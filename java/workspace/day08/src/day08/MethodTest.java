package day08;

public class MethodTest {
   
   // f(x) = 2x+1
   // 단, x는 정수이다.
   
   int f(int x){
      int result = 2 * x + 1;
      return result;
   }
   
   //static : 컴파일 시 가장 먼저 메모리에 할당된다.
   //1. 같이 static을 붙여서 사용한다.
   //2. 메소드의 클래스 소속을 앞에 붙여준다.
   public static void main(String[] args) {
      MethodTest mt = new MethodTest();
      mt.f(3);
   }
}