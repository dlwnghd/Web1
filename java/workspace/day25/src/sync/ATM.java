package sync;

public class ATM implements Runnable{
	int money = 10000;
	
	@Override
	public void run() {	// 자원
		// int타입 i는 0; i가 5미만동안 반복; i++
		for (int i = 0; i < 5; i++) {
			// 매개변수 1000을 받는 withdraw메소드 실행
			withdraw(1000);
			// 0.5초 쉼
			try {Thread.sleep(500);} catch (InterruptedException e) {;}
		}
	}
	
	// 동기화 된 int타입 money를 매개변수로 받는 withdraw메소드
	public synchronized void withdraw(int money) {
		// 동기화된 코드 -> 이 코드가 실행 중일때 다른 쓰레드가 동시에 같은 자원에 접근하는 것을 막음
		/*synchronized (this) {*/this.money -= money;/*}*/
		// 출력문
		System.out.println(Thread.currentThread().getName() + "이(가) " + money + "원 출금");
		System.out.println("현재 잔액 : " + this.money + "원");
	}
}
