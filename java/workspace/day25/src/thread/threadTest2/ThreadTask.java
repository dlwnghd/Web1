package thread.threadTest2;

// 3개의 쓰레드가 있다.
// Thread1, Thread2, Thread3
// 사용자가 입력한 순서대로 각 알맞는 문자열이 출력된다.

// 입력 예) 3 1 2
// 출력 예) third first second

// 단, Thread들은 항상 1, 2, 3 순서로 실행되어야 한다.

// Thread1 : third
// Thread2 : first
// Thread3 : second

// 출력 시 쓰레드의 번호도 출력할 경우 가산점으로 처리한다.
// 아마 scope를 이용할 줄 아는가를 묻기위함이라고 추측

public class ThreadTask implements Runnable {
	
	// static int타입의 count를 선언
	// 값을 넣어주지 않았기 때문에 초기값 0으로 저장됨
	public static int count;

	// 기본 생성자
	public ThreadTask() {
		;
	}

	public void printFirst(Runnable first) {
		first.run(); // 수정 금지
	}

	public void printSecond(Runnable second) {
		second.run(); // 수정 금지
	}

	public void printThird(Runnable third) {
		third.run(); // 수정 금지	--> 단일 쓰레드
	}

	@Override
	public void run() { // 자원	--> 멀티 쓰레드
		// 1. 쓰레드의 이름을 설정할 수 있어야 한다.
		switch (/* 접근한 쓰레드의 이름 : */Thread.currentThread().getName()) {
		case "1":	// 1번의 경우
			// printFirst를 실행
			printFirst(() -> System.out.println("Thread" + ++count + ": first"));
			break;
		case "2":
			// printSecond를 실행
			printSecond(() -> System.out.println("Thread" + ++count + ": second"));
			break;
		case "3":
			// printThird를 실행
			printThird(() -> System.out.println("Thread" + ++count + ": third"));
			break;
		}
	}
}
