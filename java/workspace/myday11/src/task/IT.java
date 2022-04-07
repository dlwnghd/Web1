package task;

import java.util.Random;
import java.util.Scanner;

public class IT {
	
	// 소스코드 간결화
	void getGradeInfo(Programmer person, Grade grade) {
		int[] gradeRatings = {10, 30, 50};
		int[] arData = new int[10];
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		 
		System.out.println(grade.position + "로 승급하시겠습니까?");
		System.out.println("- 승급에 필요한 프로젝트 수 : " + grade.success);
		System.out.println("- 승급 확률 : " + grade.rating + "%");
		System.out.println("- 승급 시 수익 상승 : " + grade.income + "%");
		System.out.println("- 승급 시 승급 성공률 : " + person.rating + "%");
		System.out.println("- [y/n]");
		//toUpperCase() : 앞의 문자열을 모두 대문자로
		//toLowerCase() : 앞의 문자열을 모두 소문자로
		String answer = sc.next().toLowerCase();
		
		if(!answer.equals("y")) {
			return;
		}
		
		if(person.success < grade.success) {
			System.out.println("승급에 필요한 프로젝트 수가 부족합니다.");
			return;
		}
		
		for(int i = 0; i < grade.rating/10; i++) {
			arData[i] = 1;
		}
		// success 수 빼기
//		person.success -= grade.success;
		
		if(arData[r.nextInt(arData.length)] == 1) {
			// 승급 성공
			person.rating =  gradeRatings[4-person.grade];
			person.grade = grade.grade;
			person.position = grade.position;
			person.income = grade.income;
			System.out.println(person.position+"으(로) 승급 성공");
			return;
		}
		
		// 승급 실패
		System.out.println("승급 실패!");
	}
	
	public static void main(String[] args) {
		// Programmer타입의 person는 새롭게 정의
		// 신입, 주니어, 시니어, 네이버
		Programmer lee = new Programmer();
		Grade[] arGrade = {
			new Grade(5, 3, "주니어", 60, 10),
			new Grade(10, 2, "시니어", 50, 20),
			new Grade(20, 1, "네이버", 30, 30)
		};
		Grade grade = null;
		
		Project[] arProject = {	// Project타입의 arProject는
				new Project("소형",2500,50),	// 0번째
				new Project("중형",5500,30),	// 1번째
				new Project("대형",10000,10)	// 3번째
		};
		
		Project project = null;	// Project타입 project는 null값
		
		Scanner sc = new Scanner(System.in);	// Scanner 호출
		Random r = new Random();	// Random 호출
		IT it = new IT();
		String answer = null;
		
		int[] arData = new int[10];
		
		int choice = 0;	// int 타입의 choice는 0 => 사용자가 입력한 값을 저장할 공간
		
		while(true){	// 무한 반복
			// 메인 메뉴
			System.out.println("1. 프로텍트 찹여하기\n2. 개발등급 올리기\n3. 내 정보\n4.나가기");
			choice = sc.nextInt();	// 사용자가 입력한 값을 Int타입으로 받아와 choice에 저장
			
			if(choice == 4) { // choice가 4라면
				System.out.println("프로그램을 종료합니다"); // 프로그램 종료 메세지 출력
				break;	// while문 탈출
				}
			
			project = arProject[r.nextInt(arProject.length)]; // project는 arProject의 랜덤한 프로젝트 실행
			
			switch (choice) {	// choice값에 대한 switch문
			case 1:	// choice가 1일 경우 => 프로젝트 참여하기
				if(lee.Project(project)) {	// person객체의 매개변수 project값을 받은 Project메소드가 true라면
					lee.money += project.money *(1.0 + lee.income*0.01);
					lee.success ++;	// 성공한 프로젝트 수 증가
					System.out.println(project.projectName + " 프로젝트 성공!!!");
					System.out.println(project.money + lee.income+"만원 획득했어요!!!");
					break;	// switch문 탈출
				}
				System.out.println(project.projectName + " 프로젝트 실패!");
				break;	// switch문 탈출
			case 2:
				if(lee.grade == 1) {
					System.out.println("이미 경지에 올랐습니다."); 
					break;
				}
				grade = arGrade[4 - lee.grade];
				it.getGradeInfo(lee, grade);
				break;	// switch문 탈출
			case 3:
				System.out.println(lee.getInfo());
				break;	// switch문 탈출
			}				
			
		}
		
	}
}
