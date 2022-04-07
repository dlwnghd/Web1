package thread.threadTest1;

public class Zoo {
	public static void main(String[] args) {
		// String타입의 배열 sounds에 "어흥", "꿱", "펭하"를 넣은 상태로 정의
		String[] sounds = {"어흥", "꿱", "펭하"};
		// Animal타입의 배열 animals는 sounds의 길이만큼 생성
		Animal[] animals = new Animal[sounds.length];
		// Thread타입의 threads는 sounds의 길이만큼 생성
		Thread[] threads = new Thread[sounds.length];
		
		// int타입 i는 0; i가 animals의 길이 미만동안 반복; i++
		for (int i = 0; i < animals.length; i++) {
			// animals의 [i]번째 배열은 Animal타입으로 선언
			animals[i] = new Animal();		// animals에는 각각에 run이 정의되어 있음
			// threads의 [i]번째 배열은 animals[i]와 sounds[i]를 매개변수로 같는 Threads타입으로 선언
			threads[i] = new Thread(animals[i], sounds[i]);
		}
		
		// int타입 i는 0; i가 threads의 길이 미만동안 반복; i++
		for (int i = 0; i < threads.length; i++) {
			// threads[i]번째에 start메소드 사용
			threads[i].start();
			// i가 0이 아니라면
			if(i != 0) {
				//이미 start()된 쓰레드는 join()의 영향을 받지 않는다.
				try {threads[i].join();} catch (InterruptedException e) {;}
			}
		}
	}
}
