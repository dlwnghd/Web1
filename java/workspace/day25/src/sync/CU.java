package sync;

public class CU {
	public static void main(String[] args) {
		ATM atm = new ATM(); // 공유할 자원 1개만 정의

		// 각각의 쓰레드가 동일한 자원에 접근함

		// 쓰레드 1
		Thread mom = new Thread(atm, "엄마");
		// 쓰레드 2
		Thread son = new Thread(atm, "아들");

		mom.start();
		son.start();
	}
}