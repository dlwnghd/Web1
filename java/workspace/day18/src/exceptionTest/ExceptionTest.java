package exceptionTest;

public class ExceptionTest {
	public static void main(String[] args) {
		// 반드시 실행해야 하는 문장이 출력되도록 try catch를 사용한다.
		try {
			System.out.println(10 / 0);
		} catch (Exception e) {
			System.out.println("반드시 실행해야 하는 문장");
			// TODO: handle exception
		}
//		int[] arData = new int[4];
//		arData[-1] = 10;
//		System.out.println("반드시 실행해야 하는 문장");
	}
}
