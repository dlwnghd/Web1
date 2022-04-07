package task;

public class Grade {
	int success;	// 등급 상승에 필요한 성공한 프로젝트 수
	int grade;	// 등급 수	
	String position;	// 계급명
	int rating;	// 프로젝트 성공률
	int income; // 수익
	
	public Grade() {;}
	
	// 초기화 생성자
	public Grade(int success, int grade, String position, int rating, int income) {
		super();
		this.success = success;
		this.grade = grade;
		this.position = position;
		this.rating = rating;
		this.income = income;
	}
	
	
} 