package lambda.task2;

@FunctionalInterface
public interface OperCheck {
   //사용자가 입력한 전체 식을 전달받아서
   //모든 연산자를 추출하여 리턴한다.
   public String[] getOpers(String expression);
}