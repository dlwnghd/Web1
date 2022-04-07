package realStock;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class StockMarket {
   public static void main(String[] args) {
      int choice = 0;
      Bank user = new Bank();
      Thread t = new Thread(user);
      String[] btns = {"매도하기", "나가기"};
      Scanner sc = new Scanner(System.in);
      
      System.out.print("투자액 : ");
      user.depositMoney = sc.nextInt();
      user.stockMoney = user.depositMoney;
      
      t.start();
      while(true) {
         choice = JOptionPane.showOptionDialog(null, "", "", JOptionPane.DEFAULT_OPTION,
               JOptionPane.PLAIN_MESSAGE, null, btns, null);
         
         if(choice == 1) {
            System.exit(0);
         }
         if(choice == 0) {
            t.interrupt();
            try {
				t.join();
			} catch (InterruptedException e) {;}
            user.sell();
            break;
         }
      }
   }
}