package thread;

public class Thread1 extends Thread{
	String data;
	
	public Thread1() {;}

	public Thread1(String data) {
		super();
		this.data = data;
	}
	
	@Override
	public void run() { // 자원
		for (int i = 0; i < 10; i++) {
			try {Thread.sleep(1000);} catch (InterruptedException e) {;}
			System.out.println(data);
		}
	}
}
