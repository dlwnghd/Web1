package bank;

import java.util.Random;
import java.util.Scanner;

public class ATM {
   public static void main(String[] args) {
      String msg = "1. 동석은행\n2. 국민은행\n3. 신한은행\n4. 나가기";
      String menu = "1. 계좌개설\n2. 입금하기\n3. 출금하기\n4. 잔액조회\n5. 계좌번호 찾기\n6. 은행 선택";
      
      Bank user = null;
      Scanner sc = new Scanner(System.in);
      Random r = new Random();
      
      int bankNum = 0;
      int choice = 0;
      int lengthOfAccount = 0;
      
      String account = "";
      String name = null;
      String phone = null;
      String pw = null;
      int money = 0;
      
      boolean condition1 = false;
      boolean condition2 = false;
      
      while(true) {
         System.out.println(msg);
         bankNum = sc.nextInt();
         if(bankNum == 4) {break;}
         
         while(true) {
            System.out.println(menu);
            choice = sc.nextInt();
            if(choice == 6) {break;}
            
            switch(choice) {
            case 1: //계좌 개설
               //6자리 랜덤 계좌번호(000000 ~ 999999)
               //기존 고객의 계좌번호와 중복이 없는 번호로 개설해야 한다.
               Bank[] arBank = {new Dongseok(), new Kookmin(), new Shinhan()};
               user = arBank[bankNum - 1];
               
               do {
                  account = "";
                  account += r.nextInt(1000000);
                  
                  lengthOfAccount = 6 - account.length();
                  
                  for (int i = 0; i < lengthOfAccount; i++) {
                     account = "0" + account;
                  }
                  
               }while(Bank.checkAccount(account) != null);
               
               System.out.print("예금주 : ");
               name = sc.next();
               
               do {
                  condition1 = false;
                  condition2 = false;
                  
                  System.out.println("핸드폰 번호를 입력해주세요\n예)01012345678");
                  phone = sc.next();
                  
                  //입력한 핸드폰 번호가 11자리가 아닐 때 true
                  condition1 = phone.length() != 11;
                  
                  for (int i = 0; i < phone.length() && !condition2; i++) {
                     //각각의 문자를 정수로 변환
                     int num = phone.charAt(i) - 48;
                     //0~9범위가 아닐 때 true
                     condition2 = num < 0 || num > 9;
                  }
                  
               } while (condition1 || condition2 || Bank.checkPhone(phone) != null);
               
               
               do {
                  System.out.print("비밀번호 : ");
                  pw = sc.next();
                  condition1 = pw.length() != 4;
                  
                  for (int i = 0; i < pw.length() && !condition2; i++) {
                     int num = pw.charAt(i) - 48;
                     condition2 = num < 0 || num > 9;
                  }
                  
               } while (condition1 || condition2);
               
               user.setAccount(account);
               user.setName(name);
               user.setPhone(phone);
               user.setPw(pw);
               
               Bank.banks[bankNum - 1][Bank.arCount[bankNum - 1]] = user;
               Bank.arCount[bankNum - 1]++;
               
               System.out.println("*********계좌 개설 완료*********");
               System.out.println(name + "님의 계좌번호 : " + account);
               System.out.println("※ 계좌번호는 다시 알려드리기 어렵습니다.\n분실 시 계좌번호가 변경되오니 참고해주세요.");
               
//               [테스트] 가입된 고객의 이름 출력
//               for (int i = 0; i < Bank.arCount[bankNum - 1]; i++) {
//                  System.out.println(Bank.banks[bankNum - 1][i].getName());
//               }
               
               break;
            case 2: //입금 하기
               System.out.print("계좌번호 : ");
               account = sc.next();
               
               System.out.print("비밀번호 : ");
               pw = sc.next();
               
               user = Bank.login(account, pw);
               
               if(user != null) { //로그인 성공
                  System.out.print("입금액 : ");
                  money = sc.nextInt();
                  
                  if(money <= 0) {
                     System.out.println("다시 시도해주세요");
                     continue;
                  }
                  
                  user.deposit(money);
                  System.out.println(user.getName() + "님의 현재 잔액 : " + user.getMoney() + "원");
                  break;
               }
               System.out.println("계좌번호 또는 비밀번호를 다시 확인해주세요.");
               break;
            case 3:// 출금 하기
               System.out.print("계좌번호 : ");
               account = sc.next();
               
               System.out.print("비밀번호 : ");
               pw = sc.next();
               
               user = Bank.login(account, pw);
               
               if(user != null) { //로그인 성공
                  System.out.print("출금액 : ");
                  money = sc.nextInt();
                  
                  if(money <= 0) {
                     System.out.println("다시 시도해주세요");
                     continue;
                  }
                  
                  if(user.getMoney() < money * (bankNum == 2 ? 1.5 : 1.0)) {
                     System.out.println("잔액이 부족합니다.");
                     continue;
                  }
                  
                  user.withdraw(money);
                  System.out.println(user.getName() + "님의 현재 잔액 : " + user.getMoney() + "원");
                  break;
               }
               System.out.println("계좌번호 또는 비밀번호를 다시 확인해주세요.");
               break;
            case 4:// 잔액 조회
               System.out.print("계좌번호 : ");
               account = sc.next();
               
               System.out.print("비밀번호 : ");
               pw = sc.next();
               
               user = Bank.login(account, pw);
               
               if(user != null) { //로그인 성공
                  System.out.println(user.getName() + "님의 현재 잔액 : " + user.getBalance() + "원");
                  break;
               }
               System.out.println("계좌번호 또는 비밀번호를 다시 확인해주세요.");
               break;
            case 5:// 계좌번호 찾기
               System.out.print("핸드폰 번호 : ");
               phone = sc.next();
               
               System.out.print("비밀번호 : ");
               pw = sc.next();
               
               user = Bank.checkPhone(phone);
               if(user.getPw().equals(pw)) {
                  do {
                     account = "";
                     account += r.nextInt(1000000);
                     
                     lengthOfAccount = 6 - account.length();
                     
                     for (int i = 0; i < lengthOfAccount; i++) {
                        account = "0" + account;
                     }
                     
                  }while(Bank.checkAccount(account) != null);
                  
                  user.setAccount(account);
                  System.out.println("*********계좌 변경 완료*********");
                  System.out.println(user.getName() + "님의 계좌번호 : " + account);
                  System.out.println("※ 계좌번호는 다시 알려드리기 어렵습니다.\n분실 시 계좌번호가 변경되오니 참고해주세요.");
                  break;
               }
               System.out.println("계좌번호 또는 비밀번호를 다시 확인해주세요.");
               break;
            }
         }
      }
   }
}














