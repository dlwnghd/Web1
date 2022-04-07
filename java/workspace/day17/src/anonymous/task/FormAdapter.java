// 인터페이스의 강제성을 없애기 위해 만든 추상 클래스
package anonymous.task;	// . 을 이용한 내부 패키지, 하위 경로

public abstract class FormAdapter implements Form {	// Form 인터페이스를 상속받음

   @Override
   public String[] getMenu() {return null;}	// {}(body)가 생기면 이 추상 클래스에서는 구현이 되기때문에 강제성이 없어짐

   @Override
   public void sell(String order) {;}

}