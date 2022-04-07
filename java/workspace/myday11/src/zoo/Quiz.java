package zoo;

public class Quiz {
	String question;
	int answer;
	int feedCount;
	boolean jackpot;
	
	// 기본 생성자
	public Quiz() {;}
	
	public Quiz(String question, int answer, int feedCount) {
		this.question = question;
		this.answer = answer;
		this.feedCount = feedCount;
	}
	
	public Quiz(String question, int answer, int feedCount, boolean jackpot) {
		this.question = question;
		this.answer = answer;
		this.feedCount = feedCount;
		this.jackpot = jackpot;
	}
	
	
}