package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class HashMapTest {
	public static void main(String[] args) {
		//아이디, 비밀번호, 이름, 나이
		// HashMap< key의 타입 , value의 타입 >
		HashMap<String, Object> userMap = new HashMap<>();
		
		// 순서가 없음
		// userMap에 put메소드를 사용하여 key값과 value값을 받아옴
		userMap.put("id", "hds");
		userMap.put("pw", "1234");
		userMap.put("name", "한동석");
		userMap.put("age", 20);
//		userMap.put("phone", "010-1234-1234");
		
		// userMap 출력
		System.out.println(userMap);
		// Map은 순서가 없음, 
		// Iterator를 이용해서 순서를 부여함
		Iterator<Entry<String, Object>> iter = userMap.entrySet().iterator();
		
		// iter가 없을때 까지 반복
		while(iter.hasNext()) {
			// Enty타입의 entry에 iter를 집어 넣어줌
			Entry<String, Object> entry = iter.next();
			// entry에서 키와 벨류값을 따로따로 불러올 수 있음
			System.out.println(entry.getKey() + ": " + entry.getValue());  
		}
		
		System.out.println(userMap.size());
		
	}
}




















