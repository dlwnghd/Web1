package bakery;

public class BreadMaker implements Runnable{
	
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
	public void run() {
		for (int i = 0; i < 20; i++) {
//			if(exit) {break;}
			BreadPlate.getInstance().makeBread();
			try {Thread.sleep(500);} catch (InterruptedException e) {break;}
		}
		System.out.println("재료 소진 ㅠㅠ");
	}
}
