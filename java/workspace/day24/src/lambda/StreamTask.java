package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTask {
	public static void main(String[] args) {
		//1~10까지 ArrayList에 담고 출력(IntStream)
//		ArrayList<Integer> datas = new ArrayList<>();
//		IntStream.rangeClosed(1, 10).forEach(data -> datas.add(data));
//		System.out.println(datas);
		
		//1~100까지 중 짝수만 ArrayList에 담고 출력(filter)
//		ArrayList<Integer> datas = new ArrayList<>();
//		IntStream.range(1, 51).forEach(data -> datas.add(data * 2));
//		IntStream.range(1, 51).map(data -> data * 2).forEach(data -> datas.add(data));
//		IntStream.range(1, 101).filter(data -> data % 2 == 0).forEach(data -> datas.add(data));
//		System.out.println(datas);
		
		//A~F까지 ArrayList에 담고 출력(IntStream.range(), map)
//		ArrayList<Character> datas = new ArrayList<>();
//		IntStream.range(0, 6).forEach(data -> datas.add((char)(data + 65)));
//		IntStream.range(65, 71).forEach(data -> datas.add((char)data));
//		IntStream.range(0, 6).map(data -> data + 65).forEach(data -> datas.add((char)data));
//		System.out.println(datas);
		
		//A~F까지 중 D 제외하고 ArrayList에 담은 후 출력(IntStream, map, 삼항 연산자)
//		ArrayList<Character> datas = new ArrayList<>();
//		IntStream.range(0, 5).map(data -> data > 2 ? data + 1 : data).forEach(data -> datas.add((char)(data + 65)));
//		IntStream.range(0, 5).map(data -> data > 2 ? data + 1 : data).map(data -> data + 65).forEach(data -> datas.add((char)data));
//		System.out.println(datas);
		
		//5개의 정수를 입력받은 후 ArrayList에 담고 최대값과 최소값 출력(구글링)(sorted 또는 mapToInt)
//		ArrayList<Integer> datas = new ArrayList<>(Arrays.asList(10, 20, 50, 30, 40));
//		datas.stream().sorted(Comparator.reverseOrder());
//		System.out.println(datas.stream().mapToInt(data -> data).max().getAsInt());
//		System.out.println(datas.stream().mapToInt(data -> data).min().getAsInt());
		
		//문자열을 5개 입력받고 모두 소문자로 변경(IntStream, map)
//		Scanner sc = new Scanner(System.in);
//		ArrayList<String> datas = new ArrayList<>();
//		IntStream.rangeClosed(0, 4).forEach(data -> datas.add(sc.next()));
//		datas.stream().map(String::toLowerCase).forEach(System.out::println);
		
		//Apple, banana, Melon 중 첫번째 문자가 대문자인 문자열 출력(Arrays.asList(), filter, collect)
//		ArrayList<String> fruits = new ArrayList<>(Arrays.asList("Apple", "banana", "Melon"));
//		String result = fruits.stream().filter(fruit -> fruit.charAt(0) >= 65).filter(fruit -> fruit.charAt(0) <= 90)
//			.collect(Collectors.joining(", "));
//		System.out.println(result);
		
		//한글을 정수로 변경(map)
		//입력 예 : 일공이사
		//출력 예 : 1024
//		String hangle = "공일이삼사오육칠팔구";
//		Scanner sc = new Scanner(System.in);
//		String data = null;
//		System.out.print("입력 : ");
//		data = sc.next();
//		
//		data.chars().map(c -> hangle.indexOf(c)).forEach(System.out::print);
		
		//정수를 한글로 변경
		//입력 예 : 1024
		//출력 예 : 일공이사
//		String hangle = "공일이삼사오육칠팔구";
//		Scanner sc = new Scanner(System.in);
//		String data = null;
//		System.out.print("입력 : ");
//		data = sc.next();
//		
//		data.chars().map(c -> c - 48).forEach(c -> System.out.print(hangle.charAt(c)));
		
		
	}
}













