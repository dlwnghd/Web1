package bakery;

public class BreadMaker implements Runnable{
	
	// Bakery에 있는 쓰레드를 멈추는 1번 방법
//	private boolean exit;
//	
//	public boolean isExit() {
//		return exit;
//	}
//	
//	public void setExit(boolean exit) {
//		this.exit = exit;
//	}
	
	@Override
	public void run() {	// 자원
		// 20개의 빵을 만들거임
		for (int i = 0; i < 20; i++) {
			// 쓰레드를 멈추는 1번 방법
//			if(exit) {break;}
			
			// BreadPlate에 있는 객체를 불러와 makeBread 메소드 실행
			BreadPlate.getInstance().makeBread();
			try {Thread.sleep(500);} catch (InterruptedException e) {break;}
		}
		System.out.println("재료 소진 ㅠㅠ");
	}
}
