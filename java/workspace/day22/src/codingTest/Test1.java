package codingTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test1 {
	public int solution(String s) {
		int answer = -1;
		
		String[] arData = s.split("0");
		ArrayList<Integer> lengths = new ArrayList<>();
		if(arData.length == 0) {
			answer = 0;
		}else {
			for(String data : arData) {
				lengths.add(data.length());
			}
			
			Collections.sort(lengths, Comparator.reverseOrder());
			
			answer = lengths.get(0);
		}
		
		// 내풀이
//		int count = 0;
//		int max = 0;
//
//		for (int i = 0; i < s.length(); i++) {
//			// 1이 나올 떄마다 카운트
//			if (s.charAt(i) == '1') {
//				System.out.println("1");
//				count++;
//			} else if (s.charAt(i) == '0') {	// 0이 나오면
//				if (count > max) {	// count가 max보다 크다면
//					max = count;
//					count = 0;
//				}
//			}
//			if (i == s.length() - 1) {	// 마지막까지 하고 난 뒤에 
//				if (count > max) {	// count가 max보다 크다면
//					max = count;
//					count = 0;
//				}
//			}
//		}
//		answer = max;
		return answer;
	}
	public static void main(String[] args) {
		System.out.println(new Test1().solution("0011000"));
	}
}