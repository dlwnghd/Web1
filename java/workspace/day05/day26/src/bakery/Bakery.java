package bakery;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Bakery {
	public static void main(String[] args) {
		BreadMaker maker = new BreadMaker();
		Thread makerThread = new Thread(maker);
		BreadPlate plate = BreadPlate.getInstance();
		
		String[] btns = {"빵 먹기", "나가기"};
		int choice = 0;
		
		ImageIcon icon = new ImageIcon("src/img/bakery.gif");
		
		makerThread.start();
		
		while(true) {
			choice = JOptionPane.showOptionDialog(null, "", "동석이네 빵집", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, icon, btns, null);
			
			if(choice == 0) {
				plate.eatBread();
			}else {
				//쓰레드가 실행 중에 종료 시키면 비정상 종료가 되므로
				//멈춘 상태에서 종료 시키는 기술이 필요하다.
//				maker.setExit(true);
//				makerThread.interrupt();
				System.exit(0);
				break;
			}
		}
	}
}








