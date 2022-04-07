package task;

import java.util.Random;

//원하는 직업 클래스를 선언하고, 필드를 구성한다.
//1. 반드시 수익 창출이 되어야 한다.
//2. 확률을 가미한다.
//3. 구현에 필요한 필드는 얼마든지 선언 가능하다.
public class Primitive {
   //등급
   String position = "원시인";
   //등급점수
   int grade = 3;
   //현재 잔액
   int money;
   //수익률
   int income;
   //사냥 추가 성공률
   int rating;
   
   //전역변수(모든 영역에서 Random 객체를 사용하기 위해 선언)
   Random r = new Random();
   
   //기본 생성자
   public Primitive() {;}
   
   //수렵하기(사냥)
   //외부에서 야생동물을 전달받는다.
   boolean hunt(Wild wild) {
      //10%단위 확률 배열
      int[] arData = new int[10];
      
      //확률
      int rating = 0;
      
      //야생동물 사냥 성공 확률에 추가 성공률을 더한 확률을 구한다.
      rating = this.rating + wild.rating;
      
      //확률 제작
      for (int i = 0; i < rating / 10; i++) {
         arData[i] = 1;
      }
      
      //1이 나올 확률은 rating%이다.
      if(arData[r.nextInt(arData.length)] == 1) {
         //사냥 성공
         return true;
      }
      //사냥 실패
      return false;
   }
   
   //등급업
   //등급에 대한 정보를 외부에서 전달받는다.
   boolean gradeUp(Grade grade) {
      //확률 배열(10단위)
      int[] arData = new int[10];
      
      for (int i = 0; i < grade.rating / 10; i++) {
         arData[i] = 1;
      }
      
      if(arData[r.nextInt(arData.length)] == 1) { //승급 성공 시
         //성공한 캐릭터의 등급 점수를 1 상승 시킨다.
         this.grade --;
         return true; //승급 성공
      }
      return false; //승급 실패
   }
   
   //내 정보
   String getInfo() {
      String str = "등급 : " + position + "\n";
      str += "현재 잔액 : " + money + "만 뼈다귀\n";
      str += "현재 수익률 : " + income + "%\n";
      str += "현재 추가 사냥률 : " + rating + "%";
      return str;
   }
}










