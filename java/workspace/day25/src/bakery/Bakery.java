package bakery;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Bakery {
	public static void main(String[] args) {
		BreadMaker maker = new BreadMaker();	// 자원
		Thread makerThread = new Thread(maker);	// 쓰레드
		// 하나의 객체에만 접근하기 위해 아래와 같이 선언
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
				makerThread.interrupt();
				break;
			}
		}
	}
}








