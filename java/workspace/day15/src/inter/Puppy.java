package inter;

public class Puppy implements Pet {

	@Override
	public void sitDown() {
		System.out.println("앉습니다.");
	}

	@Override
	public void stop() {
		System.out.println("기다립니다.");
	}

	@Override
	public void poop() {
		System.out.println("싸겠습니다.");
	}

	@Override
	public void 빵야() {
		System.out.println("총 맞은 것 처럼 눕습니다.");
	}
}
