package lambda;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class StreamTask {
	public static void main(String[] args) {
		// 1~10까지 ArrayList에 담고 출력(IntStream)
//		ArrayList<Integer> data1 = new ArrayList<>();
//		IntStream.range(0, 10).forEach(i -> data1.add(i + 1));
//		data1.forEach(System.out::println);

		// 1~100까지 중 짝수만 ArrayList에 담고 출력(filter)
//		ArrayList<Integer> data2 = new ArrayList<>();
//		IntStream.range(0, 100).filter(i -> i % 2 == 1).forEach(i -> data2.add(i + 1));
//		data2.forEach(System.out::println);

		// A~F까지 ArrayList에 담고 출력(IntStream.range(), map)
//		String data = "ABCDEF";
//		ArrayList<Character> data3 = new ArrayList<>();
//		IntStream.rangeClosed(data.charAt(0),data.charAt(5)).forEach(i -> data3.add((char)i));
//		data3.forEach(System.out::println);
		
		// A~F까지 중 D 제외하고 ArrayList에 담은 후 출력(IntStream, map, 삼항 연산자)
		
		// 내풀이 삼항 연산자 없이
		String data = "ABCDEF";
		ArrayList<Character> data4 = new ArrayList<>();
		IntStream.rangeClosed(data.charAt(0),data.charAt(5)).filter(i -> i != 68). forEach(i -> data4.add((char)i));
		data4.forEach(System.out::println);
		
		// 5개의 정수를 입력받은 후 ArrayList에 담고 최대값과 최소값 출력(구글링)(sorted 또는 mapToInt)
		// 문자열을 5개 입력받고 모두 소문자로 변경(IntStream, map)
		// Apple, banana, Melon 중 첫번째 문자가 대문자인 문자열 출력(Arrays.asList(), filter, collect)
		// 한글을 정수로 변경(map)
		// 정수를 한글로 변경
	}
}