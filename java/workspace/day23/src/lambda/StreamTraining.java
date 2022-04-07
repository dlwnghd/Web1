package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTraining {
	public static void main(String[] args) {
		// stream() : Stream타입으로 변경(stream에 정의된 기능들을 사용할 수 있는 상태로 변경)
		// map() : 기존의 데이터를 다른 데이터로 변경
		// filter() : 조건식을 전달하여 true인 값만 추출
		// collect() : 결과를 원하는 타입으로 변경
		// forEach() : 향상된 for문과 같이 앞의 반복자의 요소를 각각 가져온 후 로직 작성 가능
		// sorted() : 오름차순 정렬
		// IntStream.range(start, end) : 특정 범위의 여러 개의 값을 생성할 때 사용한다. end는 포함시키지 않는다.

		// 1~100까지 ArrayList에 담기
//      ArrayList<Integer> datas = new ArrayList<>();
//      IntStream.range(0, 100).forEach(i -> datas.add(i + 1));
//      datas.forEach(System.out::println);

		// 100~1까지 ArrayList에 담기
//      ArrayList<Integer> datas = new ArrayList<>();
//      IntStream.range(0, 100).forEach(i -> datas.add(100 - i));
//      datas.forEach(System.out::println);

		// ABCDEF를 각 문자별로 출력하기
		// 문자열에 chars()라는 메소드가 stream타입이다.
//      String data = "ABCDEF";
//      data.chars().forEach(System.out::println);
//      data.chars().forEach(i -> System.out.println((char)i));

		// BCDEFG를 출력하기
//      data.chars().map(c -> c + 1).forEach(c -> System.out.println((char)c));

		// C 제외하고 출력하기
		// filter(v -> 조건식) : 조건식이 true인 애들만!
//      data.chars().filter(c -> c != 67).forEach(c -> System.out.println((char)c));

		// 정렬
//      ArrayList<Integer> datas = new ArrayList<>(Arrays.asList(10, 40, 20, 30));
		// ::는 void 메소드일 경우 참조형 사용이 가능하다.

		// 오름차순
//      ArrayList<Integer> sortedAscDatas = 
//            (ArrayList<Integer>)datas.stream().sorted().collect(Collectors.toList());

		// 내림차순
//      datas.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

		// 실습
		ArrayList<String> datas = new ArrayList<>(Arrays.asList("black", "white", "red", "yellow"));

		// 1. 전체 대문자로 변경 후 출력(BLACK, WHITE, RED, YELLOW)
		// 강사님 풀이
		datas.stream().map(String::toUpperCase).forEach(System.out::println);
		// 내풀이
		datas.stream().forEach(c -> System.out.println(c.toUpperCase()));

		// 2. 전체 대문자가 아닌 앞 글자만 대문자로 변경 후 출력(Black, White, Red, Yellow)
		// 강사님 풀이
		datas.stream().map(c -> c.charAt(0) >= 97 && c.charAt(0) <= 122 ? c.replace(c.charAt(0), (char) (c.charAt(0) - 32)) : c).forEach(System.out::println);

		// 내풀이
		datas.stream().forEach(c -> System.out.println(c.substring(0, 1).toUpperCase() + c.substring(1, c.length())));

		// joining : 각 요소를 원하는 구분점으로 연결하여 문자열로 리턴한다.
		System.out.println(datas.stream().collect(Collectors.joining(" ")));

	}
}
