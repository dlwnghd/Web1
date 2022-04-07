package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;

public class StreamTask_my {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 1~10까지 ArrayList에 담고 출력(IntStream)
//		ArrayList<Integer> data1 = new ArrayList<>();
//		IntStream.range(0, 10).forEach(i -> data1.add(i + 1));
//		data1.forEach(System.out::println);
//
//		// 1~100까지 중 짝수만 ArrayList에 담고 출력(filter)
//		ArrayList<Integer> data2 = new ArrayList<>();
//		IntStream.range(0, 100).filter(i -> i % 2 == 1).forEach(i -> data2.add(i + 1));
//		data2.forEach(System.out::println);
//
//		// A~F까지 담겨 있는 data
//		String data = "ABCDEF";
//
//		// A~F까지 ArrayList에 담고 출력(IntStream.range(), map)
//		ArrayList<Character> data3 = new ArrayList<>();
//		IntStream.rangeClosed(data.charAt(0),data.charAt(5)).forEach(i -> data3.add((char)i));
//		data3.forEach(System.out::println);
//		
//		// A~F까지 중 D 제외하고 ArrayList에 담은 후 출력(IntStream, map, 삼항 연산자)
//		ArrayList<Character> data4 = new ArrayList<>();
//		IntStream.rangeClosed(data.charAt(0),data.charAt(5)).filter(i -> i != 68). forEach(i -> data4.add((char)i));
//		data4.forEach(System.out::println);
//		
//		// 5개의 정수를 입력받은 후 ArrayList에 담고 최대값과 최소값 출력(구글링)(sorted 또는 mapToInt)
//		
//		// max와 min을 사용한 풀이
//		ArrayList<Integer> data5_1 = new ArrayList<>();
//		IntStream.range(0, 5).forEach(i -> data5_1.add(i = sc.nextInt()));
//		System.out.println(Collections.max(data5_1));
//		System.out.println(Collections.min(data5_1));
//		
//		//sort를 사용한 풀이
//		ArrayList<Integer> data5_2 = new ArrayList<>();
//		IntStream.range(0,5).forEach(i -> data5_2.add(i = sc.nextInt()));
//		Collections.sort(data5_2);
//		System.out.println(data5_2.get(0));
//		System.out.println(data5_2.get(data5_2.size()-1));
//		
//		// 문자열을 5개 입력받고 모두 소문자로 변경(IntStream, map)
//		ArrayList<String> data6 = new ArrayList<>();
//		System.out.print("문자열 5개 입력 : ");
//		IntStream.range(0, 5).forEach(i -> data6.add(sc.next()));
//		data6.stream().map(String::toLowerCase).forEach(System.out::println);
//		
//		// Apple, banana, Melon 중 첫번째 문자가 대문자인 문자열 출력(Arrays.asList(), filter, collect)
//		ArrayList<String> data7 = new ArrayList<>(Arrays.asList("Apple", "banana", "Melon"));
//		data7.stream().filter(c -> c.charAt(0) >= 65 && c.charAt(0) <= 90).forEach(System.out::println);

		// 한글을 정수로 변경(map)
		ArrayList<String> data8 = new ArrayList<>(); // 입력한 한글 숫자를 저장할 공간
		String hangeul = "영일이삼사오육칠팔구"; // 한글 숫자
		System.out.print("숫자를 한글로 입력 : ");
		String num = sc.next(); // 입력한 한글 숫자
//		
//		// 입력한 한글을 String타입으로 각각 저장
		IntStream.range(0, num.length()).forEach(i -> data8.add(Character.toString(num.charAt(i))));

		// Stream을 이용해 풀이 아쉽지만 못함
//		// 한글형태인 숫자를 String타입으로 각각 저장
//		ArrayList<String> data8_1 = new ArrayList<>();
//		IntStream.range(0, hangeul.length()).forEach(j -> data8_1.add(Character.toString(hangeul.charAt(j))));
//		
//		//반복으로 비교할 것이다.
//		IntStream.range(0,num.length()).filter(i -> data8.get(i) == 
//				// IntStream으로 리턴되어 나와 값을 비교할 수 없음
//				/*IntStream.range(0, hangeul.length()).forEach(j -> data8_1.get(j))*/
//				);
//		
//		data8.forEach(System.out::println);

//		//for문 풀이ㅠㅠ
//		// 만약 일치한다면
//		for(int i = 0; i < num.length(); i++) {
//			for(int j = 0; j < hangeul.length(); j++) {
//				if(data8.get(i).equals(Character.toString(hangeul.charAt(j)))) {
//					data8.set(i, Integer.toString(j));
//					break;
//				}
//			}
//		}
//		data8.forEach(System.out::println);

		// 정수를 한글로 변경
//		ArrayList<String> data9 = new ArrayList<>();
//		String sueja = "0123456789";
//		String hangeul = "영일이삼사오육칠팔구";
//		
//		System.out.print("정수 입력 : ");
//		String num2 = sc.next();
//		
//		// 입력한 한글을 String타입으로 각각 저장
//		IntStream.range(0, num2.length()).forEach(i -> data9.add(Character.toString(num2.charAt(i))));
//		
//		// 만약 일치한다면
//		for(int i = 0; i < num2.length(); i++) {
//			for(int j = 0; j < sueja.length(); j++) {
//				if(data9.get(i).equals(Character.toString(sueja.charAt(j)))) {
//					data9.set(i, Character.toString(hangeul.charAt(j)));
//					break;
//				}
//			}
//		}
//		data9.forEach(System.out::println);
	}
}