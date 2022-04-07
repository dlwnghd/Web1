package anonymous.task;	// . 을 이용한 내부 패키지, 하위 경로

public interface Form {
	// 강제성이 있는 메소드
	// 구현이 되어 있지 않기 때문에 강제성이 부여됨
	public String[] getMenu();
	public void sell(String order);
}
