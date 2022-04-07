package task;

public class Grade {
   //등급 상승에 필요한 금액
   int money;
   //등급 점수
   int grade;
   //등급
   String position;
   //승급 확률
   int rating;
   //추가 수익률
   int income;

   public Grade() {;}
   
   public Grade(int money, int grade, String position, int rating, int income) {
      this.money = money;
      this.grade = grade;
      this.position = position;
      this.rating = rating;
      this.income = income;
   }
}