package lambda.task2;

@FunctionalInterface
public interface MyMath {
   //외부에서 두 정수를 전달받은 뒤 int로 리턴한다.
   //아직 +로 연산할 지, -로 연산할 지 알 수 없기 때문에
   //구현되지 않은 상태로 선언만 해놓는다.
   public int calc(int num1, int num2);
}