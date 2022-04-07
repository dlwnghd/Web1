package anonymous.task;

public class Nike {
   public void register(Form form) {
      String[] menus = form.getMenu();
      System.out.println("==========상품 목록===========");
      for (int i = 0; i < menus.length; i++) {
         System.out.println(i + 1 + ". " + menus[i]);
      }
      
      // 무료나눔점인지 아닌지 구분하기
      // marker를 사용해서도 할 수 있으나 marker는 진짜진짜 마지막에 사용함
      // 타입을 비교해서 FormAdapter타입일 경우 무료나눔점으로 인식
      if(form instanceof FormAdapter) { // 전달받은 매개변수 form이 FormAdapter타입이라면
         System.out.println("무료나눔 지점입니다.");	// 출력
         return;	// 종료
      }
      
      form.sell("티셔츠");
   }
}