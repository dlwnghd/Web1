package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Test2 {
	public int solution(int[] winnum, int bonus, int[] usernum) {
		int answer = 0, count = 0;

		ArrayList<Integer> winnumList = (ArrayList<Integer>) Arrays.stream(winnum).boxed().collect(Collectors.toList());
		Integer[] temps = Arrays.stream(usernum).boxed().toArray(Integer[]::new);
		ArrayList<Integer> usernumList = new ArrayList<>(Arrays.asList(temps));

//      ArrayList<Integer> winnumList = new ArrayList<>();
//      ArrayList<Integer> usernumList = new ArrayList<>();
//      
//      for (int i = 0; i < winnum.length; i++) {
//         winnumList.add(winnum[i]);
//         usernumList.add(usernum[i]);
//      }

		for (int i = 0; i < usernumList.size(); i++) {
			if (usernumList.contains(winnumList.get(i))) {
				count++;
			}
		}

		switch (count) {
		case 6:
			answer = 1;
			break;
		case 5:
			if (usernumList.contains(bonus)) {
				answer = 2;
				break;
			}
			answer = 3;
			break;
		case 4:
			answer = 4;
			break;
		case 3:
			answer = 5;
			break;
		default:
			answer = -1;
			break;
		}

		return answer;
	}

	public static void main(String[] args) {
		int[] winnum1 = { 1, 11, 12, 14, 26, 35 };
		int[] winnum2 = { 10, 41, 44, 28, 31, 33 };

		int[] usernum1 = { 1, 35, 11, 14, 12, 26 };
		int[] usernum2 = { 1, 9, 10, 31, 33, 42 };

		int answer = 0;
		answer = new Test2().solution(winnum1, 6, usernum1);
		System.out.println(answer);

		answer = new Test2().solution(winnum2, 21, usernum2);
		System.out.println(answer);

	}
}
