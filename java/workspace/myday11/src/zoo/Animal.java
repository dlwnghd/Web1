package zoo;

import java.util.Random;

public class Animal {
	// 이름
	// 나이
	// 먹이 종류
	// 먹이 개수
	// 생명
	String name;
	int age;
	String feed;
	int feedCount;
	int life;
	
	public Animal() {;}
	
	public Animal(String name, int age, String feed, int feedCount, int life) {
		this.name = name;
		this.age = age;
		this.feed = feed;
		this.feedCount = feedCount;
		this.life = life;
	}

	// 먹기
	// 먹이 개수 1 감소(먹이 개수가 0개라면 먹기 실패)
	// 생명 1 증가
	boolean eat() {
		if (feedCount < 1) {
			return false;
		}
		feedCount--;
		life++;
		return true;
	}

	// 잠자기
	// 생명 1 증가
	// Thread.sleep()를 사용해서 3초에 생명 1이 증가하도록 구현
	void sleep() {
		life++;
	}

	// 산책하기(한동석)
	// 생명 1 감소
	// 랜덤한 문제를 출제하여
	// 맞출 시 먹이 2개 획득
	// 틀릴 시 생명 1 감소
	// 잭팟을 구현하여 낮은 확률로 많은 먹이를 얻을 수 있도록 구현
	Quiz walk(Quiz[] arQuiz) {
		life--;
		int rating = 10;
		int[] arData = new int[10];
		Random r = new Random();
		Quiz quiz = new Quiz();

		for (int i = 0; i < rating / 10; i++) {
			arData[i] = 1;
		}

		if (arData[r.nextInt(arData.length)] == 1) {// 10%
			while (true) {
				quiz = arQuiz[r.nextInt(arQuiz.length)];
				if(quiz.jackpot) {break;}
			}
			
		} else {// 90%
			while (true) {
				quiz = arQuiz[r.nextInt(arQuiz.length)];
				if(quiz.jackpot) {break;}
			}
		}
		return quiz;
	}
}
