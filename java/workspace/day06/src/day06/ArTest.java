package day06;

public class ArTest {
	public static void main(String[] args) {
		int[] arData = {3,5,1,9,7};
		
		// 5 4 3 2 1 넣고 출력하기
		for(int i = 0; i < arData.length; i++) {
			arData[i] = 5-i;
			System.out.println(arData[i]);
		}
		
	}
}
