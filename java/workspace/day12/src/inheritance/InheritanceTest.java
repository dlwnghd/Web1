package inheritance;

class A{
	String nameA = "A";
	int data = 10;
}

class B extends A{
	String nameB = "B";
	
	void printData(){
		System.out.println(data);
	}
}


public class InheritanceTest {
	public static void main(String[] args) {
		B b = new B();
		b.printData();
		System.out.println(b.nameA);
		System.out.println(b.nameB);
	}
}
