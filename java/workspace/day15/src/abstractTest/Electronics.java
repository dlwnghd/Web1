package abstractTest;

public abstract class Electronics {
	abstract void on();
	abstract void off();
	
	final void intro() {
		System.out.println("안녕 난 전자제품이야.");
	}
}
