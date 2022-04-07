package day06;

import java.util.Scanner;

public class ArTask1 {
	public static void main(String[] args) {
		// 브론즈
		// 1~10까지 배열에 담고 출력
		// 10~1까지 중 짝수만 배열에 담고 출력
		// 1~100까지 배열에 담은 후 홀수만 출력
		
		//실버
		//1~100까지 배열에 담은 후 짝수의 합 출력
		//A~F까지 배열에 담고 출력
		//A~F까지 중 C 제외하고 배열에 담은 후 출력
		
		//골드
		//5개의 정수를 입력받고 배열에 담은 후 최대값과 최소값 출력
		
		//다이아
		//사용자가 입력할 정수의 개수만큼 배열을 만든 후 정수를 입력받고 평균 구하기
		int sum = 0, ave = 0, want = 0;	// int타입 sum, ave, want를 선언
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력할 정수의 개수 : ");		// 사용자로부터 정수의 개수 입력 유도
		int num1 = sc.nextInt();	// 사용자가 입력한 값 int타입 num1에 대입
		int[] num2 = new int[num1];	// int타입 배열 num2는 num1의 갯수만큼 배열 칸 생성
		
		for(int i =0; i < num1; i++) {		// int타입 i는 0; num1미만동안 반복; i++
			System.out.print(i+"번째 배열에 넣을 정수 : ");	// 어느 배열에 어떤 수를 넣을지 유도
			want = sc.nextInt();	// int타입 want는 사용자가 입력한 값
			num2[i] = want;	// num2[i]번째에 want값 대입
			sum += num2[i];	// sum = sum + num2[i]
		}
		
		ave = sum/num1;	// 평균 계산
		System.out.println("평균 : " + ave);	// 사용자에게 평균 보여주기
	}
}
