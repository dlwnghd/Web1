package obj;

public class Zoo {
	public static void main(String[] args) {
		Animal cat = new Animal(1,"고양이");
		cat.equals(new Animal(1,"고양이"));
	}
}
