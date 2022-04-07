package task;

import java.util.Random;
import java.util.Scanner;

public class Mountain {
   
   //소스코드 간결화
   //승급에 대한 로직 작성
   //승급을 시도한 캐릭터의 정보와(person)
   //등급에 대한 정보(grade)를 전달받는다.
   void getGradeInfo(Primitive person, Grade grade) {
      //사냥 추가 성공률
      int[] gradeRatings = {10, 30};
      
//      int[] arData = new int[100];
//      Random r = new Random();
      Scanner sc = new Scanner(System.in);
      
      System.out.println(grade.position + "로 승급하시겠습니까?");
      System.out.println("※ 승급에 필요한 돈 : " + grade.money + "만 뼈다귀");
      System.out.println("※ 승급 확률 : " + grade.rating + "%");
      System.out.println("※ 승급 성공 시 획득 뼈다귀 +" + grade.income + "%");
      System.out.println("※ 승급 성공 시 사냥 성공률 +" + person.rating + "%");
      System.out.println("[y / n]");
      //toUpperCase() : 앞의 문자열을 모두 대문자로
      //toLowerCase() : 앞의 문자열을 모두 소문자로
      String answer = sc.next().toLowerCase();
      
      if(!answer.equals("y")) { //승급 취소
         //void형 메소드에서 강제 종료 시 return;을 적어준다.
         return;
      }
      
      //돈이 부족하다면
      if(person.money < grade.money) {
         //알맞는 메시지 출력 후
         System.out.println("승급에 필요한 돈이 부족합니다.");
         //메소드 종료
         return;
      }
      
//      //승급할 확률 제작
//      for (int i = 0; i < grade.rating; i++) {
//         arData[i] = 1;
//      }

      //승급에 성공하든, 실패하든 무조건 돈은 차감되도록 구현한다.
      person.money -= grade.money;
      
      //첫번째 승급 성공 시 grade : 2
      //두번째 승급 성공 시 grade : 1
      if(person.gradeUp(grade)) {
         //승급 성공
         person.rating = gradeRatings[2 - person.grade]; //사냥 추가 성공률 반영
         person.position = grade.position; // 캐릭터의 등급을 승급한 등급으로 수정
         person.income = grade.income; // 캐릭터의 수익률을 승급한 등급의 수익률로 수정
         System.out.println(person.position + "으(로) 승급 성공!");
         return;
      }
      
      //승급 실패
      System.out.println("승급 실패...");
   }
   
   public static void main(String[] args) {
//      printf에서는 %%두 개를 써야 %문자로 인식한다.
//      System.out.printf("%%");
      
      Primitive han = new Primitive();
      Grade[] arGrade = {
            new Grade(20000, 2, "창지기", 100, 10),
            new Grade(40000, 1, "제사장", 100, 100)
      };
      Grade grade = null;
      Wild[] arWild = {
            new Wild("맘모스", 15000, 50),
            new Wild("시조새", 55000, 30),
            new Wild("공룡", 100000, 10)
      };
      Wild wild = null;
      Scanner sc = new Scanner(System.in);
      Random r = new Random();
      Mountain m = new Mountain();
      
      String answer = null;
      
      int[] arData = new int[10];
      
      int choice = 0;
      
      while(true) {
         System.out.println("1. 사냥하기\n2. 등급 올리기\n3. 내 정보\n4. 나가기");
         choice = sc.nextInt();
         
         //나가기
         if(choice == 4) {break;}
         if(choice < 1 || choice > 4) { //메뉴 번호의 범위를 벗어났을 때
            System.out.println("잘못 입력하셨습니다.");
            continue;
         } 
         
         //랜덤한 야생동물 소환 후 wild객체에 담아주기
         wild = arWild[r.nextInt(arWild.length)];
         
         switch(choice) {
         case 1: //사냥하기
            //소환한 야생동물을 전달하여 사냥 성공/실패 여부를 확인한다.
            if(han.hunt(wild)) {   //사냥에 성공했다면
               //야생동물의 전리품(돈)에 추가 수익률을 더한 돈을 캐릭터 통장에 넣어준다.
               //wild.money * 1.0 : 기본 수익률
               //han.income * 0.01 : 추가 수익률
               han.money += wild.money * (1.0 + han.income * 0.01);
               System.out.println(wild.name + " 사냥 성공!!!!");
               System.out.println((int)(wild.money * (1.0 + han.income * 0.01)) + "만 뼈다귀 만큼 획득했어요!");
               break;
            }
            System.out.println("악!" + wild.name + " 사냥 실패! 도망가자~!");
            break;
         case 2: //승급하기
            if(han.grade == 1) {//최고 등급에 도달했을 경우
               System.out.println("이미 경지에 올랐습니다."); 
               break;
            }
            //사용자가 승급 성공 시 받아야 할 혜택들을 grade에 담아준다.
            //아직 승급 성공인지 실패인지 모른다.
            grade = arGrade[3 - han.grade];
            //캐릭터 정보와 성공 시 혜택 정보를 전달한다.
            m.getGradeInfo(han, grade);
            break;
         case 3:
            //내 정보
            System.out.println(han.getInfo());
            break;
         }
      }
      
   }
}

















