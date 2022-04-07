package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTask {
	// 일괄처리
	// throws를 이용해 오류가 났을 경우 main메소드를 받는 객체가 알아서 처리하도록 오류를 떠넘김
	public static void main(String[] args) throws IOException {
		// food.txt 파일을 현재 경로에 생성하고,		출력
		// 파일 내용은 족발, 보쌈, 짜장면, 탕수육 네 가지 음식으로 작성한다.
		// 각 음식은 줄바꿈 후 다음 음식을 넣도록한다.
		// 반복문을 사용해서 데이터를 출력한다.

		// String타입의 배열 foods에 {"족발", "보쌈", "짜장면", "탕수육"}을 넣어준다.
		String[] foods = { "족발", "보쌈", "짜장면", "탕수육" };
		// BufferedWriter타입 bw를 BufferedWriter에 만드는데 food.txt로 만들어줌(상대경로)
		BufferedWriter bw = new BufferedWriter(new FileWriter("food.txt"));

		// int타입 i는 0부터 foods의 길이까지 1씩 증가하면서 반복
		for (int i = 0; i < foods.length; i++) {
			// bw의 foods[i]번째와 줄바꿈을 매개변수로 받아 write메소드를 사용
			bw.write(foods[i] + "\n");
		}

		// bw의 close메소드를 이용하여 버퍼를 닫아줌
		bw.close();

		// 작성한 내용을 콘솔에 출력한다.

		// BufferedReader타입의 br은 null
		BufferedReader br = null;
		try {
			// br은 BufferedReader타입으로 불러옴 위치는 상대위치
			br = new BufferedReader(new FileReader("food.txt"));
			// String타입의 line은 null
			String line = null;
			// br.readLine메소드를 담은 line값이 null이 아닌동안 반복
			while ((line = br.readLine()) != null) {
				// line을 출력
				System.out.println(line);
			}
			// br의 close메소드를 이용해 버퍼닫기
			br.close();
		} catch (FileNotFoundException e) {// 파일을 찾지 못한 경우
			//	해당경로에 파일이 존재하지 않는다는 오류를 아래의 출력문으로 띄어줌
			System.out.println("해당 경로에 파일이 없습니다.");
		}
		
		// 삭제
		// File타입의 f는 새로운 파일을 만드는데 food.txt를 매개변수로 받아 상대위치에 생성
		File f = new File("food.txt");
		// 만약 f가 존재한다면
		if (f.exists()) {
			// f의 delete메소드를 이용해 해당 파일을 삭제
			f.delete();
		}
	}
}
