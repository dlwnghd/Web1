package variable;

public class Variable1 {
	int data = 10;
	static int data_s = 10;

	void increaseData() {
		System.out.println(++data);
	}

	// static 필드에서는 static 변수만 사용 가능!
	static void increaseData_s() {
		System.out.println(++data_s);
	}
}