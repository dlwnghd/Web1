package inheritance;

// 부모 클래스
class Human{
	void eat() {
		System.out.println("먹기");
	}
	void sleep() {
		System.out.println("자기");
	}
	void walk() {
		System.out.println("걷기");
	}
}

// 자식 클래스
class Monkey extends Human{
	
	@Override
	void walk() {
		super.walk();
		System.out.println("두발 또는 네 발로 걷기");
	}
	
	void eatLouse() {
		System.out.println("냐미~");
	}
}

public class InheritanceTest2 {
	public static void main(String[] args) {
		Monkey kingkong = new Monkey();
		kingkong.eat();
		kingkong.walk();
		kingkong.sleep();
		kingkong.eatLouse();
	}
}
