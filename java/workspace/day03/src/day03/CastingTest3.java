package day03;

public class CastingTest3 {
	public static void main(String[] args) {
//		System.out.println(1 + "3");
//		System.out.println(1 + "" + 9);
		
		//두 정수를 더하여 결과가 정수로 나오게 하기
		String data1 = "1";
		String data2 = "3";
		String data3 = "3.7";
		
		System.out.println(Integer.parseInt(data1) + Integer.parseInt(data2));
		System.out.println(Double.parseDouble(data3) + 1);
		
	}
}
