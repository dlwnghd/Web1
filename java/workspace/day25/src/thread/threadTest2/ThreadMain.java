package thread.threadTest2;

import java.util.Scanner;

public class ThreadMain {
	public static void main(String[] args) {
		// Scanner 호출
		Scanner sc = new Scanner(System.in);
		// int타입 배열 arInput을 길이 3으로 만들어줌
		int[] arInput = new int[3];
		// Thread타입의 배열 arThread는 길이 3으로 만들어줌
		Thread[] arThread = new Thread[3];

		// ThreadTask타입의 tt를 새로 만들어줌
		ThreadTask tt = new ThreadTask();

		// int i는 0; i는 arThread의 길이미만동안 반복; i++
		for (int i = 0; i < arThread.length; i++) {
			// arThread의 i번째 배열에 tt를 매개변수로 가지는 Thread타입으로 선언
			arThread[i] = new Thread(tt);
		}

		System.out.print("입력 : "); // 사용자로부터 입력을 유도
		// int i는 0; i는 arInput의 길이미만동안 반복; i++
		for (int i = 0; i < arInput.length; i++) {
			// arInput의 [i]번째 방에 입력한 값을 String타입으로 넣어줌
			arInput[i] = sc.nextInt();
			// arThread의 [i]번째 방의 이름을 ar[i]번째 값을 String타입으로 바꾼 값
			arThread[i].setName(arInput[i] + "");
		}

		// int i는 0; i는 arThread의 길이미만동안 반복; i++
		for (int i = 0; i < arThread.length; i++) {
			// arThread의 i번째 시작
			arThread[i].start();
			// arThread[i]번째를 join함
			// 이미 start()된 쓰레드는 join()의 영향을 받지 않는다.
			try {arThread[i].join();} catch (InterruptedException e) {;}
		}

	}
}
