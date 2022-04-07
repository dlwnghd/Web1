// 함수형 인터페이스
// 인터페이스 중 추상 메소드를 하나만 가지고 있는 인터페이스
package lambda.task1;

//@FunctionalInterface를 인터페이스 위에 작성하여 단 하나의 추상메소드만 선언할 수 있도록 제한
@FunctionalInterface
public interface PrintName {
	// 외부에서 이름과 성을 전달받는 추상 메소드 선언 리턴타입은 String
   public String getName(String firstName, String lastName);
}