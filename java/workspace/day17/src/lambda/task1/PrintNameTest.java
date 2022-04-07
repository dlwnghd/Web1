package lambda.task1;

public class PrintNameTest {
	// 이름을 전체로 받는 메소드 선언 PrintName타입의 name을 매개변수로 받음 return값은 없어도 됨
	public static void printFullName(PrintName name) {
		System.out.println(name.getName("동석", "한"));
	}

	// 메인 메소드
	public static void main(String[] args) {
		// PrintNameTest클래스의 printeFullName메소드에 매개변수 f와 l값을 받아와서 l + f를 리턴
		PrintNameTest.printFullName((f, l) -> l + f);
	}
}