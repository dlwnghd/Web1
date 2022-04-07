package bakery;

public class BreadPlate {
	
	// 다른 곳에서 수정하지 못하도록 private를 걸어줌
	private static BreadPlate plate;
	
	// int타입 breadCount
	int breadCount;
	// int타입 eatCount
	int eatCount;
	
	// 싱글톤 패턴
	// 무조건 객체가 단 한 개만 있어야 할 때
	private BreadPlate() {;}
	
	// 값을 수정할 수 없기 때문에 setter는 삭제

	// getInstance
	public static BreadPlate getInstance() {
		// plate가 null이면
		if(plate == null) {
			// 객체 생성
			plate = new BreadPlate();
		}
		return plate;
	}

	// 빵 만들기 
	public synchronized void makeBread() {
		// 만약 빵의 갯수가 9개를 넘어가면
		if(breadCount > 9) {
			// "빵이 가득 찼습니다." 출력
			System.out.println("빵이 가득 찼습니다.");
			try {wait();} catch (InterruptedException e) {;}
		}
		// 빵의 갯수 + 1
		breadCount++;
		// "빵을 1개 만들었습니다."와 빵의 총 갯수 출력
		System.out.println("빵을 1개 만들었습니다. 총 : " + breadCount + "개");
	}
	
	// 빵 먹기
	public synchronized void eatBread() {
		// 빵을 먹은 갯수가 20개라면
		if(eatCount == 20) {
			// 출력문
			System.out.println("빵이 다 떨어졌습니다.");
			
		}else if(breadCount < 1) {	// breadCount의 수가 1보다 적다면
			// 출력문
			System.out.println("🍩🍪🍩🍩🍪🍩🍪빵을 만들고 있어요!");
			
		}else {
			// 빵 갯수 - 1
			breadCount --;
			// 빵을 먹은 갯수 + 1
			eatCount++;
			// 출력문
			System.out.println("빵을 1개 먹었습니다. 총 : " + breadCount + "개");
			// 쓰레드를 깨워줌
			notify();
		}
	}
}

















