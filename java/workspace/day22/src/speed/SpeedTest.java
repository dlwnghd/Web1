package speed;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class SpeedTest {
	public static void main(String[] args) {
		// 사람이 볼 떄 ,는 숫자를 보기 좋게 해주지만 컴퓨터는 문자로 인식하기 때문에
		// _ 를 이용하여 개발자가 보기도 쉽고 컴퓨터는 무시하기 때문에 사용하기에 편리하다
		final int SIZE = 10_000_000; // n부터 시작했을 때 찾을 마지막 값
		final int DATA = 5_000_000; // 찾을 값

//		인터페이스
		final List<Integer> arrayList = new ArrayList<>(); // ArrayList -> List : 업캐스팅(자식 -> 부모)
		final Set<Integer> hashSet = new HashSet<>();
		
		// 람다식
		// 클래스.메소드()
		// range(처음 값, 마지막 값) : 처음값부터 마지막 값 전까지
		IntStream.range(0, SIZE).forEach(value -> {
			arrayList.add(value);
			hashSet.add(value);
		});
		
		// arrayList 속도 계산
		// Instant타입의 start는 Instant클래스의 now메소드 return값 ------------ (a)
		Instant start = Instant.now();
		// contain메소드 : arrayList가 DATA를 포함하면 true 반환 포함하지 않으면 false 반환
		arrayList.contains(DATA);
		// Instant타입의 end는 Instant클래스의 now메소드 return값-------------- (b)
		Instant end = Instant.now();
		
		// b-a를 이용해 걸린 시간을 구할 것인데 메소드를 이용해 더 정확하게 구할 것임
		// long타입 elapsedTime은 Duration클래스의 between메소드에 매개변수 strat와 end를 받아 나온 return 값을 toMills를 통해 밀리초로 바꾸어줌
		long elapsedTime = Duration.between(start, end).toMillis();
		// 출력
		System.out.println("arrayList : " + elapsedTime * 0.001 + "초");

		// hashSet 속도 계산
		// 선언에 타입을 생략한 것과 hashSet으로 선언한 것 외에는  위와 동일
		start = Instant.now();
		hashSet.contains(DATA);
		end = Instant.now();
		elapsedTime = Duration.between(start, end).toMillis();
		System.out.println("hashSet : " + elapsedTime * 0.001 + "초");
	}
}
