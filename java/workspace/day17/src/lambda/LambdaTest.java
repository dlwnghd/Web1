package lambda;

public class LambdaTest {
	// 메인 메소드
	public static void main(String[] args) {

		// 람다식
		// ↓ 선언
		// LambdaInter타입의 inter
		LambdaInter inter = /* 선언 시작 오른쪽 전체는 리턴값*/(n) -> n % 10 == 0; /* 선언 끝 */ // 자료형은 LabbdaInter에서 선언된 것을 받아오기 때문에 적지 않아도 됨
		System.out.println(inter.checkMultipleOf10(10));
		
		
		// LambdaInter타입의 lambda
		LambdaInter lambda = (number) -> {
			System.out.println("10의 배수 검사");
			return number % 10 == 0;
		};
		System.out.println(lambda.checkMultipleOf10(15));

		// 원래는 아래처럼 해야 햇다
//      LambdaInter inter = /* 선언 시작 */new LambdaInter() {
//         
//         @Override
//         public boolean checkMultipleOf10(int number) {
//            return number % 10 == 0;
//         }
//      };	/* 선언 끝 */
//      inter.checkMultipleOf10(10);
	}
}