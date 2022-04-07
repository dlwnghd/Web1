package obj;

public class Student {
	private static int seq;
	private int num;
	private String name;

	// static 필드
	// 메모리에 1번만 할당해줌
	static {
		System.out.println("[학생 관리 프로그램]");
	}

	// 초기화 필드
	{
		System.out.println("학생이 한 명 추가되었습니다.");
		this.num = ++seq;
	}

	public Student() {
		;
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		String str = this.num + ". " +this.name;
		return str;
	}

}