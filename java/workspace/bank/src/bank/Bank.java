package bank;

public class Bank {
   
   //모든 은행의 고객을 관리하는 DB
   public static Bank[][] banks = new Bank[3][100];
   
   //각 은행별 고객 수
   public static int[] arCount = new int[banks.length];
   
   //접근자는 private으로 설정
   //예금주, 계좌번호, 핸드폰번호, 비밀번호, 잔액
   // private는 자주 사용할 예정
   private String name;
   private String account;
   private String phone;
   private String pw;
   private int money;
   
   //기본 생성자
   // 반드시 생성
   public Bank() {;}

   //초기화 생성자
   // OverRodding
   public Bank(String name, String account, String phone, String pw, int money) {
      super();
      this.name = name;
      this.account = account;
      this.phone = phone;
      this.pw = pw;
      this.money = money;
   }

   //getter, setter
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getAccount() {
      return account;
   }

   public void setAccount(String account) {
      this.account = account;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getPw() {
      return pw;
   }

   public void setPw(String pw) {
      this.pw = pw;
   }

   public int getMoney() {
      return money;
   }

   public void setMoney(int money) {
      this.money = money;
   }
   
   //입금
   public void deposit(int money) {
      this.money += money;
   }
   
   //출금
   public void withdraw(int money) {
      this.money -= money;
   }
   
   //잔액조회
   public int getBalance() {
      return this.money;
   }
   
   //계좌번호 중복검사
   public static Bank checkAccount(String account) {
      Bank user = null;
      for (int i = 0; i < banks.length; i++) {
         int j = 0;
         for (j = 0; j < arCount[i]; j++) {
            if(banks[i][j].account.equals(account)) {
               user = banks[i][j];
               break;
            }
         }
         if(j != arCount[i]) {break;}
      }
      return user;
   }
   
   //핸드폰 중복검사
   public static Bank checkPhone(String phone) {
      Bank user = null;
      for (int i = 0; i < banks.length; i++) {
         int j = 0;
         for (j = 0; j < arCount[i]; j++) {
            if(banks[i][j].phone.equals(phone)) {
               user = banks[i][j];
               break;
            }
         }
         if(j != arCount[i]) {break;}
      }
      return user;
   }
   
   //로그인(계좌번호, 비밀번호)
   public static Bank login(String account, String pw) {
      Bank user = checkAccount(account);
      if(user != null) {
         if(user.pw.equals(pw)) {
            return user;
         }
      }
      return null;
   }
}





















