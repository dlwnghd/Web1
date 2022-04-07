package obj;

public class School {
	public static void main(String[] args) {
		Student han = new Student();
		Student hong = new Student("홍길동");
		han.setName("한동석");
		
		System.out.println(han);
		System.out.println(hong);
	}
}
