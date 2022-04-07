package polymorphism;

class Car{
	// 변수
	// 브랜드, 색상, 가격
	String brand;
	String color;
	int price;
	
	//기본 생성자
	public Car() {;}
	
	//초기화 생성자
	public Car(String brand, String color, int price) {
		super();
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	
	// 메소드
	//"열쇠로 시동 킴" 출력
	void sidongOn(){
		System.out.print("열쇠로 시동 킴");
	}
	//"열쇠로 시동끔 출력
	void sidongOff(){
		System.out.println("\n열쇠로 시동 끔");
	}
}

class SuperCar extends Car{
	// 변수
	// 브랜드, 색상, 가격
	String mode;
	
	//기본생성자
	public SuperCar() {;}
	
	//초기화생성자
	public SuperCar(String brand, String color, int price, String mode) {
		super(brand,color,price);
		this.mode = mode;
	}
	//메소드
	//"열쇠로 시동 킴", "음성으로 시동 킴"
	@Override
	void sidongOn() {
		super.sidongOn();
		System.out.println(", 음성으로 시동 킴");
	}
	//"음성으로 시동 끔" 출력
	void sidongOff() {
		System.out.println("음성으로 시동 끔");
	}
	//"지붕 열림" 출력
	void roofOpen() {
		System.out.println("지붕 열림");
	}
	//"지붕 닫힘" 출력
	void roofClose() {
		System.out.println("지붕 닫힘");
	}
}

public class Road {
	public static void main(String[] args) {
		SuperCar sc = new SuperCar();
		Car c = new Car();
		c.sidongOn();
		c.sidongOff();
		
		sc.sidongOn();
		sc.sidongOff();
		sc.roofOpen();
		sc.roofClose();
	}

}
