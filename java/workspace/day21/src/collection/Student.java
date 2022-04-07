package collection;

public class Student {
	int num;
	String name;

	public Student() {;}
	
	public Student(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(obj instanceof Student) {
			Student std = (Student)obj;
			if(this.num == std.num) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return num;
	}
	
}




















