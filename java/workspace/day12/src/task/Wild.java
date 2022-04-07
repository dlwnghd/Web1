package task;

public class Wild {
   //야생 동물의 이름
   String name;
   //야생 동물 사냥 성공 시 획득 가능한 돈
   int money;
   //사냥 성공 확률
   int rating;
   
   public Wild() {;}
   
   public Wild(String name, int money, int rating) {
      super();
      this.name = name;
      this.money = money;
      this.rating = rating;
   }
   
   
}