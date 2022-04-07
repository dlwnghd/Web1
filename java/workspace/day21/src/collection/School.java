package collection;

import java.util.HashSet;

public class School {
	public static void main(String[] args) {
		Student han = new Student(1, "한동석");
		System.out.println(han.equals(new Student(1, "한동석")));
		
		//hashCode()를 사용하는 자료구조에서
		//정확한 결과를 내기 위해서는
		//equals()뿐만 아니라 hashCode()도 재정의 해야 한다.
		HashSet<Student> 출석부 = new HashSet<>();
		출석부.add(han);
		출석부.add(new Student(1, "한동석"));
		
		System.out.println(출석부.size());
		
		System.out.println(출석부);
		
		
	}
}
