package anonymous.task;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

public class ButtonTest extends Frame implements ActionListener { // Frame이라는 클래스를 상속, ActionListener라는 인터페이스를 상속
	// ButtonTest메소드
	// 생성자
	public ButtonTest() {
		super/*부모*/("버튼 테스트");
		int x = 0; 
		int y = 0;

		JButton btn1 = new JButton("눌러줘1!");
		JButton btn2 = new JButton("눌러줘2!");

		setLayout(new FlowLayout());

		btn1.setFont(new Font("", Font.BOLD, 50));
		btn2.setFont(new Font("", Font.BOLD, 50));

		// ButtonTest라는 this도 ActionListener의 타입이기 때문에 this로 사용이 가능
		// ButtonTest(자식) -> ActionListener(부모) : 업 캐스팅
		btn1.addActionListener(this);	// upCasting을 통해 받았기 때문에 this를 사용
		btn2.addActionListener(this);

		add(btn1);
		add(btn2);

		setSize(500, 700);	// 크기
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		x = (screen.width - this.getWidth()) / 2;
		y = (screen.height - this.getHeight()) / 2;

		setLocation(x, y);	// x축과 y출 좌표값을 받음
		
		// Listener
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("앗 닫힐거같아");
				System.exit(0);	// 프로그램 종료
			}
		});

		setVisible(true);	// 우리눈에 보일 수 있게끔 setVisible이라는 필드에 true를 전달함
	}

	public static void main(String[] args) {
		new ButtonTest(); // 생성자 호출
	}

	@Override
	// ActionEvent객체가 어떤 버튼이 눌렸는지 알고있음
	public void actionPerformed(ActionEvent e) {
		// 눌려진 값이 case라면 실행하도록 switch문에 넣어줌
		switch (e.getActionCommand()) {
		case "눌러줘1!":
			System.out.println("첫 번째 버튼 클릭됨!");
			break;
		case "눌러줘2!":
			System.out.println("두 번째 버튼 클릭됨!");
			break;
		}
	}

}
