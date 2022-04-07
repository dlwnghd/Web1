// 함수형 인터페이스
// 인터페이스 중 추상 메소드를 하나만 가지고 있는 인터페이스

package lambda;

// @FunctionalInterface를 인터페이스 위에 작성하여 단 하나의 추상메소드만 선언할 수 있도록 제한
@FunctionalInterface
public interface LambdaInter {
	// 10의 배수인지 아닌지 확인하는 메소드 checkMultipleOf10
	// boolean타입으로 return하는 checkMultipleOf10메소드 int타입 number를 매개변수로 받는다. 현재 여기선 구현되어 있지 않음
	boolean checkMultipleOf10(int number);
}