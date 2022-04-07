package anonymous.task;

public class DepartmentStore {
	public static void main(String[] args) {

		// 잠실점 오픈
		// 잠실점은 판매하지 않고 무료 나눔행사 지점이다.
		// 본사에 등록 시 판매할 상품 목록만 구현한다.
		// 본사에서는 무료나눔 지점인지 검사를 한 뒤
		// 무료나눔 지점이라면 sell()을 테스트 하지 않고,
		// "무료나눔 지점입니다" 출력
		
//		Nike타입의 jamsil은 새로운 Nike타입으로 생성
		Nike jamsil = new Nike();
		
//		Nike타입의 gangnam은 새로운 Nike타입으로 생성
		Nike gangnam = new Nike();

//		jamsil의 register메소드를 새로운 FormAdapter메소드의 구현내용의 retrun값을 전달받아서 실행
		// FormAdapter로 업 캐스팅(자식 -> 부모)
		jamsil.register(new FormAdapter() /*익명*/{
			
			// 아래 내용도 FormAdapter라는 추상 클래스에서 구현을 해서 생략이 가능하지만 문제에서 구현해달라고 함
			// 물론 FormAdapter에서는 기능을 실제로 구현해 놓지는 않고 {;}로 처리해 놓음
			@Override
			public String[] getMenu() {
				String[] menus = { "티셔츠", "신발", "바지", "가방" };
				return menus;
			}
		});

		
//		gangnam의 register메소드를 new Form이라는 생성자를 전달받아서 실행
		gangnam.register(new Form() /*익명*/{

			@Override
			public void sell(String order) {
				String[] menus = getMenu();
				for (int i = 0; i < menus.length; i++) {
					if (order.equals(menus[i])) {
						System.out.println(order + "판매 완료");
					}
				}
			}

			@Override
			public String[] getMenu() {
				String[] menus = { "티셔츠", "신발", "바지", "가방" };
				return menus;
			}
		});
	}
}