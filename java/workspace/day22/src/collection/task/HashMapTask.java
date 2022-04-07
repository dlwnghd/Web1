package collection.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.function.UnaryOperator;

public class HashMapTask {
	public static void main(String[] args) {
		//KEY는 Student, Value는 ArrayList인 HashMap
		HashMap<Student, ArrayList<Integer>> studentMap = new HashMap<>();
		
		//학생 정보 3개를 배열에 담는다.
		Student[] stds = {
				new Student(1, "한동석"),
				new Student("홍길동"),
				new Student(1, "이순신") //번호가 같은 학생이므로 1번 학생과 동일한 학생 이다.
		};

		
		for (int i = 0; i < stds.length; i++) {
			System.out.println(stds[i].num);
		}
		
		//Arrays.asList(T...a)
		//배열 또는 가변 인자를 전달해주면, List타입으로 리턴해준다.
		//ArrayList의 생성자에 Collection 타입을 전달하면
		//전달한 Collection의 모든 값이 해당 ArrayList로 복사되어 초기화된다.
		Integer[] arData = {30, 90, 60};
		ArrayList<Integer> std1Scores = new ArrayList<>(Arrays.asList(arData));
		ArrayList<Integer> std2Scores = new ArrayList<>(Arrays.asList(100, 90, 70));
		ArrayList<Integer> std3Scores = new ArrayList<>(Arrays.asList(20, 50, 60));
		
		studentMap.put(stds[0], std1Scores);
		studentMap.put(stds[1], std2Scores);
		studentMap.put(stds[2], std3Scores); //동일한 번호의 학생이 1번으로 들어갔기 때문에, 이 학생은 들어가지 않는다.
		
		//학생의 이름 변경
		//3번 학생과 같은 번호를 가진 학생을 조회한 뒤
		//학생 3번의 이름으로 변경해준다.
		
		//학생의 정보에 대한 문제이므로, KEY부분만 따로 빼서 작업한다.
		Iterator<Student> iter = studentMap.keySet().iterator();
		while(iter.hasNext()) {
			//각 학생객체를 std에 담아준다.
			Student std = iter.next();
			
			//각 학생의 번호와 마지막 학생의 번호를 비교하여
			if(std.num == stds[2].num) { //같다면,
				//그 학생의 이름을 마지막 학생의 이름으로 수정해준다.
				std.name = stds[2].name;
			}
		}
		
		//이름이 잘 수정되었는 지 확인한다.
		//※ iterator는 마지막까지 반복을 돌았다면 재사용할 수 없다.
		Iterator<Student> iter2 = studentMap.keySet().iterator();
		while(iter2.hasNext()) {
			System.out.println(iter2.next().name);
		}
		
		//학생 1번의 점수를 수정
//		int[] arScore = {1, 2, 3};
//		
//		//빠른 for문, 향상된 for문, forEach
//		for(int score : arScore) {
//			System.out.println(score);
//		}
		
		
//		System.out.println(studentMap.get(stds[0]));
		
		//모든 값을 하나의 값으로 수정할 때에는 replaceAll()을 사용한다.
		//replaceAll()에 UnaryOperator의 구현된 필드 주소를 전달하면,
		//구현한 apply메소드의 리턴 값으로 반복하여 값이 수정된다.
		studentMap.get(stds[0]).replaceAll(new UnaryOperator<Integer>() {
			@Override
			public Integer apply(Integer t) {
				return 100;
			}
		});
		
		//변경된 점수를 빠른 for문을 사용하여 확인한다.
		for(int score : studentMap.get(stds[0])) {
			System.out.println(score);
		}
		
		//학생 별 평균 점수 구하기
		//학생 수 만큼 배열을 할당한다.
		int[] arTotal = new int[studentMap.size()];
		double[] arAvg = new double[studentMap.size()];
		int index = 0;
		
		//VALUE에 대한 작업이기 때문에 values()를 사용하여 VALUE만 분리한다.
		for(ArrayList<Integer> scoreList : studentMap.values()) {//한 번 접근하면 ArrayList
			for(int score : scoreList) {//두 번 접근하면 Integer 타입의 점수이다.
				arTotal[index] += score;
			}//안에 있는 for문이 끝났다는 것은 한 학생의 전체 점수를 구했다는 뜻이다.
			
			//평균
			arAvg[index] = (double)arTotal[index] / scoreList.size();
			index++; //다음 학생에 접근하기 위해서 index를 1 증가시킨다.
		}
		
		//학생 별 평균 점수를 확인한다.
		for (int i = 0; i < arAvg.length; i++) {
			System.out.println(arAvg[i]);
		}
	}
}













