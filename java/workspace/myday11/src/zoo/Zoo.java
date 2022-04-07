package zoo;

import java.util.Random;
import java.util.Scanner;

public class Zoo {

	// 메소드의 2번째 목적 소스 코드의 간결화
	// 다른 장소에서도 사용하기위함
	// sleep(잠자기) 메소드
	void sleep(Animal animal) {
		// 자는 중 출력
		System.out.print("자는 중");
		for (int j = 0; j < 3; j++) {	// int는 j값 0부터; 3까지 반복; j++
			try {	// try문
				Thread.sleep(1000);	// Thread클래스의 sleep메소드에 매개변수 1000을 줌
			} catch (InterruptedException e) {	// InterruptedException 발생 시 ;을 통해 무시
				;
			}
			// . 출력
			System.out.print(".");
		}
		System.out.println();	// 줄바꿈
		animal.sleep();	// 받아온 animal매개변수의 sleep메소드 실행
		System.out.println("잘 잤다! 생명이 1 증가했어요!");	// 생명력 1증가 출력
		System.out.println(animal.name + "의 생명 : " + animal.life);	// animal.name(동물의 이름)과 animal.life(생명) 출력
	}

	public static void main(String[] args) {
		Zoo zoo = new Zoo();	// Zoo타입의 zoo는 새로운 Zoo값을 받음
		Animal[] animals = new Animal[3];	// Animal타입의 배열 animals는 새로운 Animal타입의 값 3개를 받음
		Animal animal = null;	// animal타입의 animal은 null(주소값의 초기값) 저장

		animals[0] = new Animal("기린", 10, "풀", 5, 5);
		animals[1] = new Animal("거북이", 15, "해초", 8, 2);
		animals[2] = new Animal("여우", 3, "고기", 4, 6);

		Quiz[] arQuiz = { new Quiz("Q. 다음 중 프로그래밍 언어가 아닌 것은?\n1.JAVA\n2.C언어\n3.파이썬\n4.망둥어", 4, 2),
				new Quiz("Q. JAVA에 없는 챕터는?\n1.변수\n2.클래스\n3.메소드\n4.포인터", 4, 100, true),
				new Quiz("Q. 다음 중 JAVA 기본 자료형이 아닌 것은?\n1.int\n2.boolean\n3.char\n4.String", 4, 50, true) };
		Quiz quiz = null;	// Quiz타입의 quiz는 null(주소값의 초기값) 저장

		Scanner sc = new Scanner(System.in);

		String title = "★놀러와요 동물 천국★";
		String menuMsg = "안녕하세요! 캐릭터를 선택해봐요~";
		String actionMsg = "1. 먹기\n2. 잠자기\n3. 산책하기\n4. 작별인사하기";

		int charNum = 0;
		int actionChoice = 0;
		int answer = 0;

		while (true) {
			int i = 0;
			System.out.println(menuMsg);	// munuMsg 출력
			for (i = 0; i < animals.length; i++) {
				System.out.println(i + 1 + ". " + animals[i].name);
			}
			System.out.println(i + 1 + ". 나가기");
			charNum = sc.nextInt(); // 사용자가 입력한 값 charNum에 int타입으로 저장
			if (charNum == i + 1) {	// charNum이 i+1(나가기)와 같다면
				System.out.println("게임을 종료합니다.");
				break;
			}

			animal = animals[charNum - 1]; // animal은 animals의 [charNum-1]번째 배열

			while (true) {	// 무한 반복
				System.out.println(actionMsg);	// actionMsg 출력
				actionChoice = sc.nextInt();	// actionChoice의 값을 사용자로부터 받음

				if (actionChoice == 4) {	// actionChocie의 값이 4라면
					break;	// 반복문 탈출
				}

				switch (actionChoice) {	// actionChoice값을 switch문으로 받아
				case 1:	// actionChoice의 값이 1이라면
					// 먹기
					if (animal.eat()) {	// animal.eat메소드의 return값이 True라면
						System.out.println(animal.name + "(이)가 " + animal.feed + "(을)를 냠냠 먹는 중!");	// 동물의 이름과 먹이의 이름을 출력
						System.out.println("현재 " + animal.feed + " 개수 : " + animal.feedCount + "개");	// 현재 animal.feed(먹이의 종류)와 animal.feedCount(먹이의 갯수)를 출력
						System.out.println("현재 체력 : " + animal.life);	// animal.life의 값을 출력
						break;	// case문 탈출
					}
					// 먹이가 없는 경우
					// animal.eat가 true가 아니면 위의 if문을 실행하지 않고 여기로 옴
					System.out.println(animal.feed + "(이)가 없어요~! 얼른 산책하러 가요!"); // animal.feed(먹이의 종류가) 없다고 산책가자는 메세지를 출력
					break;	// case문 탈출
				case 2:	// actionChoice의 값이 2라면
					// 잠자기
					zoo.sleep(animal);// animal값을 매개변수로 받은 zoo클래스의 sleep메소드 호출
					break;	// case문 탈출
				case 3: // actionChoice의 값이 3이라면
					// 산책하기
					// 생명 확인 하기
					if (animal.life > 1) {	// animal매개변수의 life가 1초과라면 
						quiz = animal.walk(arQuiz);	// arQuiz값을 매개변수로 받은 animal클래스의 walk메소드를 통해 나온 return값은 quiz
						// 잭팟
						if (quiz.jackpot) {	// quiz의 jackpot의 값이 true라면
							System.out.println("★★★★★★★★★잭팟★★★★★★★★★");	// 잭팟 출력
						}

						System.out.println(quiz.question);	// quiz클래스의 question을 출력 => 문제 제출
						answer = sc.nextInt();	// 사용자가 입력한 정답값을 받음
						
						// 정답일 경우
						// 사용자가 입력한 answer값이 quiz클래스의 answer값과 같을 경우
						if (quiz.answer == answer) {
							animal.feedCount += quiz.feedCount;	// animal타입의 feedCount값을 quiz타입의 feedCount값만큼 증가 => quiz에 들어있는 먹이값을 추가
							System.out.println("와 ~ 훌륭합니다! 정답이에요!");	// 정답 메세지 출력
							System.out.println("먹이를 " + quiz.feedCount + "개 획득했어요!");	// 획득한 먹이의 갯수를 출력
							System.out.println("현재 " + animal.feed + " 개수 : " + animal.feedCount);	// 먹이의 종류의 이름과 남은 먹이의 갯수를 출력
							break;	// case문 탈출
						}

						// 오답일 경우
						// 사용자가 입력한 answer값이 quiz클래스의 answer값과 다를 경우
						System.out.println("아이고... 아까워요! 다음에 다시 도전해보세요~!!");	// 아쉬움 메세지 출력
						animal.life--;	// animal객체의 life값을 1감소
						System.out.println("현재 체력 : " + animal.life);	// 현재 체력 출력

						// animal객체의 life값이 2였는데 오답을 통해서 체력이 0이 된 경우
						// animal객체의 life값이 0이라면
						if (animal.life == 0) {	
							zoo.sleep(animal);	// zoo클래스의 sleep메소드에 animal값을 넣어줌
						}

					} else {	// animal매개변수의 life가 1이하라면 => 현재 생명이 2보다 작다면
						System.out.println("체력이 없어요!! 잠을 자고 오세요~!");	// 체력이 없다면 메세지 출력
					}
					break;	// case문 탈출
				}
			}
		}
	}
}

