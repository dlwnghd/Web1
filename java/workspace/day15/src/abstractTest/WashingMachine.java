package abstractTest;

public class WashingMachine extends Electronics{

	@Override
	void on() {
		off();
	}

	@Override
	void off() {
		System.out.println("전원 누르기");
	}

}
