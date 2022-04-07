package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class ArrayListTest <T extends Number>{
	
	public static void main(String[] args) {
		// <?> : 제네릭(이름이 없는)
		// 임시로 타입을 선언하여 임시 타입으로 설계한다.
		// 따로 다운 캐스팅을 할 필요가 없다.
		// 지정할 타입에 제한을 둘 수 있다.
		ArrayList<Integer> datas = new ArrayList<>();
		
		datas.add(10);
		datas.add(20);
		datas.add(40);
		datas.add(50);
		datas.add(90);
		datas.add(80);
		datas.add(70);
		datas.add(60);
		
		System.out.println(datas);
		
//		System.out.println(datas.size());
//		
//		try {
//			for (int i = 0; i < datas.size(); i++) {
//				System.out.println(datas.get(i));
//			}
//		} catch (IndexOutOfBoundsException e) {
//			System.out.println("칸을 넘었어요!");
//		}
		
		Collections.sort(datas);
		System.out.println(datas);
		
		Collections.reverse(datas);
		System.out.println(datas);
		
		Collections.shuffle(datas);
		System.out.println(datas);
		
		//추가(삽입)
		// 50 뒤에 500 삽입
		// 단, 50이 있을 때에만 삽입한다.
		if(datas.contains(50)) {
			datas.add(datas.indexOf(50) + 1, 500);
		}
		System.out.println(datas);
		
		//수정
		// 90을 9로 수정
		if(datas.contains(90)) {
			System.out.println(datas.set(datas.indexOf(90), 9) + "이 9로 변경되었습니다.");
		}
		System.out.println(datas);
		
		//삭제
		// 80 삭제
//		if(datas.contains(80)) {
			// 1. 인덱스로 삭제
//			System.out.println(datas.remove(datas.indexOf(80)) + "이 삭제되었습니다.");
//		}
		// 2. 값으로 삭제
		if(datas.remove(Integer.valueOf(80))) {
			System.out.println("삭제 성공");
		}
		System.out.println(datas);
	}
}




























