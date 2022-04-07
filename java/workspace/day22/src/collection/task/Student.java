package collection.task;

public class Student {
	private static int seq;
	public int num;
	public String name;
	
	//초기화 블럭
	//생성자 호출 시 가장 먼저 실행된다.
	{
		this.num = ++seq;
	}
	
	public Student() {;}

	public Student(String name) {
		this.name = name;
	}

	public Student(int num, String name) {
		this.num = num;
		this.name = name;
	}
	
	
	// equals 재정의
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(obj instanceof Student) {
			Student anotherStd = (Student)obj;	// obj를 Student타입으로 다운 캐스팅 한 후 anotherStd에 담아줌
			if(this.num == anotherStd.num) {
				return true;
			}
		}
		
		return false;
	}
	
	// hashCode 재정의
	@Override
	public int hashCode() {
		return this.num;
	}
	
}























