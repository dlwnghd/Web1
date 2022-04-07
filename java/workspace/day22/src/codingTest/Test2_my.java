package codingTest;

import java.util.Arrays;

public class Test2_my {
	
	// 당첨번호의 배열에 있는 값에 correctnum이 있다면 true를 반환하는 contains메소드 선언
	public static boolean contains(final int[] winnum, final int correctnum) {
		// anyMatch는 .앞에있는 요소에 ()안에 있는 값이 존재한다면 true 아니라면 false를 반환
		// 람다식을 이용함
		return Arrays.stream(winnum).anyMatch(i -> i == correctnum);
	}

	public int solution(int[] winnum, int bonus, int[] usernum) {
		int answer = -1;	// 초기값을 -1로 잡아 놓은 answer
		int count = 0;	// 일치하는 번호를 새어주는 변수 count
		// winnum 전체를 int타입 i로 하여 반복
		for (int i : winnum) {
			// usernum에 있는 번호들안에 i값이 있다면 : 번호가 일치 한다면
			if (contains(usernum, i)) {
				count++;	// 일치하는 번호 +1
			}
		}

		// 일치하는 번호의 수에 따라 switch문 실행
		switch (count) {
		case 6:	// 6개 일치
			answer = 1;// 1등
			break;
		case 5:	// 5개 일치
			if (contains(usernum, bonus)) {// 5개 일치 + 보너스번호 일치
				answer = 2;	// 2등
				break;
			}
			answer = 3;// 3등
			break;
		case 4:	// 4개 일치
			answer = 4;// 4등
			break;
		case 3:	// 3개 일치
			answer = 5;// 5등
			break;
		default:// 나머지는 -1등
			break;
		}
		return answer;
	}

	public static void main(String[] args) {
		
		int[] winnum = { 1, 11, 12, 14, 26, 35 };
		int[] usernum = { 1, 35, 11, 14, 12, 26 };
		int bonus = 6;
		int count = 0;	// 일치하는 번호를 새어주는 변수 count
		int answer = -1;	// 초기값을 -1로 잡아 놓은 answer

		new Test2_my().solution(winnum, bonus, usernum);
		
		
//		// winnum 전체를 int타입 i로 하여 반복
//		for (int i : winnum) {
//			// usernum에 있는 번호들안에 i값이 있다면 : 번호가 일치 한다면
//			if (contains(usernum, i)) {
//				count++;	// 일치하는 번호 +1
//			}
//		}
//
//		// 일치하는 번호의 수에 따라 switch문 실행
//		switch (count) {
//		case 6:	// 6개 일치
//			answer = 1;// 1등
//			break;
//		case 5:	// 5개 일치
//			if (contains(usernum, bonus)) {// 5개 일치 + 보너스번호 일치
//				answer = 2;	// 2등
//				break;
//			}
//			answer = 3;// 3등
//			break;
//		case 4:	// 4개 일치
//			answer = 4;// 4등
//			break;
//		case 3:	// 3개 일치
//			answer = 5;// 5등
//			break;
//		default:// 나머지는 -1등
//			break;
//		}
//		System.out.println(answer+"등");
////		return answer;
	}
}