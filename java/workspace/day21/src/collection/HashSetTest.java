package collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
	public static void main(String[] args) {
		HashSet<String> foodSet = new HashSet<>();
		
		foodSet.add("치킨");
		foodSet.add("떡볶이");
		foodSet.add("족발");
		foodSet.add("막국수");
		foodSet.add("계란");
		foodSet.add("포켓몬빵");
		foodSet.add("포켓몬빵");
		foodSet.add("포켓몬빵");
		
		System.out.println(foodSet.toString());
		System.out.println(foodSet.contains("치킨"));
		
		Iterator<String> iter = foodSet.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}
}













