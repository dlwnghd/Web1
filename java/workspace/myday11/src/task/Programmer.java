package task;

import java.util.Random;

// 원하는 직업 클래스를 선언하고, 필드를 구성한다.
// 프로그래머
// 1. 반드시 수익 창출이 된어야 한다.
// 회사의 프로젝트에 참여하여 돈을 범 프로젝트는 소, 중, 대로 나눔
// 2. 확률을 가미한다.
// 프로젝트가 대성공을 하면 승진 => 월급이 10% 상승
// 승진확률 80% 실패확률 20%
// 3. 구현에 필요한 필드는 얼마든지 선언 가능하다.

public class Programmer {
	String position = "신입"; // 계급명
	int grade = 4; // 등급
	int success; // 성공한 프로젝트의 수
	int money; // 통장 잔고
	int income; // 수익
	int rating; // 프로젝트 성공확률

	Random r = new Random(); // Random 호출

	// 기본 생성자
	public Programmer() {
		;
	}

	// 프로젝트 참여하기
	boolean Project(Project projectName) {
		int[] arData = new int[10];
		int rating = 0;
		rating = this.rating + projectName.rating; // 프로젝트 성공확률 = 프로그래머의 프로젝트 성공확률 + 프로젝트의 성공확률
		for (int i = 0; i < rating / 10; i++) {
			arData[i] = 1;
		}

		// 성공
		if (arData[r.nextInt(arData.length)] == 1) {
			return true;
		}
		return false;

	}

	// 등급업
	boolean gradeUp(Grade grade) {
		int[] arData = new int[10];

		for (int i = 0; i < grade.rating / 10; i++) {
			arData[i] = 1;
		}

		if (arData[r.nextInt(arData.length)] == 1) {
			this.grade++;
			return true;
		}
		return false;

	}

	String getInfo() {
		String str = "등급 : " + position + "\n";
		str += "현재 성공한 프로젝트 수 : " + success + "\n";
		str += "현재 추가 프로젝트 성공률 : " + rating + "%\n";
		str += "현재 잔액 : " + money + "만원\n";
		str += "현재 수익률 : " + income;
		return str;
	}
}
