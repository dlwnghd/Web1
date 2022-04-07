package thread.threadTest1;

public class Animal implements Runnable{
	@Override
	public void run() { // 자원
		for (int i = 0; i < 10; i++) {
			System.out.println(/*접근한 쓰레드의 이름 : */Thread.currentThread().getName());
			// 1초 지연
			try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		}
	}
}
