package day07;

import java.util.Scanner;

public class ArTask1 {
	public static void main(String[] args) {
		// 골드
		// 5개의 정수를 입력받고 배열에 담은 후 최대값과 최소값 출력
//      int[] arData = new int[5];
//      int max = 0, min = 0;
//      
//      Scanner sc = new Scanner(System.in);
//      
//      for (int i = 0; i < arData.length; i++) {
//         System.out.print(i + 1 + "번째 정수 : ");
//         arData[i] = sc.nextInt();
//      }
//      
//      max = arData[0];
//      min = arData[0];
//      
//      for (int i = 1; i < arData.length; i++) {
//         if(max < arData[i]) {max = arData[i];}
//         if(min > arData[i]) {min = arData[i];}
//      }
//      
//      System.out.println("최대값 : " + max);
//      System.out.println("최소값 : " + min);

		// 다이아
		// 사용자가 입력할 정수의 개수만큼 배열을 만든 후 정수를 입력받고 평균 구하기
		int[] arData = null;
		int total = 0;
		double avg = 0.0;
		Scanner sc = new Scanner(System.in);

//      System.out.print("입력할 정수의 개수 : ");
		System.out.println("몇 개의 정수를 입력 하시겠습니까?");
		arData = new int[sc.nextInt()];

		for (int i = 0; i < arData.length; i++) {
			System.out.print(i + 1 + "번째 정수 : ");
			arData[i] = sc.nextInt();
			total += arData[i];
		}

		// 총 합에서 전체 개수를 나누어 평균을 구한다.
		avg = total / (double) arData.length;

		// String.format("서식문자", "값,...") : 서식문자에 들어간 값을 문자열로 바꿔준다.
		// 예) String.foramt("%d", 10) == "10"
		// 문자열로 결과가 나오기 때문에 다시 실수로 변경하기 위해서는
		// Double클래스에 있는 parseDouble("문자열")을 사용한다.
		// 기존에 있던 avg값을 서식문자로 변경된 avg값으로 수정한다.
		avg = Double.parseDouble(String.format("%.2f", avg));

		for (int i = 0; i < arData.length; i++) {
			// 사용자가 입력한 정수를 출력한다.
			System.out.print(arData[i]);
			if (i != arData.length - 1) {// 마지막 반복이 아니라면
				// 출력한 정수 뒤에 " ,"를 출력해준다.
				System.out.print(", ");
			}
		}
		System.out.println("\n총 합 : " + total);
		System.out.println("평균 : " + avg);
	}
}
