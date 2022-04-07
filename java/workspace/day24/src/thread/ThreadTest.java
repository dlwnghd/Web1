package thread;

public class ThreadTest {
	public static void main(String[] args) {
//		Runnable t1 = new Thread2();
//		Thread2 t2 = new Thread2();
//		
//		Thread thread1 = new Thread(t1, "!");
//		Thread thread2 = new Thread(t2, "?");
		
		Thread thread1 = new Thread(()->{
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName());
				try {Thread.sleep(500);} catch (InterruptedException e) {;}
			}
		}, "!") ;
		Thread thread2 = new Thread(()->{
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName());
				try {Thread.sleep(500);} catch (InterruptedException e) {;}
			}
		}, "?");

		//join() : 사용한 쓰레드가 다 끝나야 다른 쓰레드가 동작한다. 
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("main 쓰레드 종료");
		
//		Thread1 t1 = new Thread1("★");
//		Thread1 t2 = new Thread1("♥");
////		t1.run();
////		t2.run();
//		
//		t1.start();
//		t2.start();
		
	}
}
