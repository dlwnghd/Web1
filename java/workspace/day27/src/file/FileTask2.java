package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTask2 {
	// 일괄처리
	// throws를 이용해 오류가 났을 경우 main메소드를 받는 객체가 알아서 처리하도록 오류를 떠넘김
	public static void main(String[] args) throws IOException {
//		// 생선
//		// fish.txt
//		// 도미, 고등어, 갈치, 광어
//		// String배열타입의 fishs는 {"도미", "고등어", "갈치", "광어"}로 선언
//		String[] fishs = { "도미", "고등어", "갈치", "광어" };
////		 BufferedWriter타입 bw는 새로운 BufferedWriter의 "fish.txt"파일 생성
//		BufferedWriter bw = new BufferedWriter(new FileWriter("fish.txt"));
////		 int타입 i는 0부터 fishs의 길이까지 1씩 증가하여 반복
//		for (int i = 0; i < fishs.length; i++) {
//			// fishs의 i번째 값과 줄바꿈을 매개변수로 받는 bw의 write메소드 실행
//			bw.write(fishs[i] + "\n");
//		}
//		bw.close();

		// =============수정과 삭제는 덮어쓰기를 이용해서 해결===================
		
		// 수정(고등어 -> 놀래미)
		// 한줄 씩 검사 -> '고등어' 검색 -> Reader
		// temp라는 저장공간을 생성하여 if문으로 일치한다면 temp에 수정할정보를 더하고 continue
		// 아니라면 temp에 기존에 있는 line과 줄바꿈을 더함
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("fish.txt"));
			String line = null;
			String temp = "";
			
			while((line = br.readLine()) != null) {
				if(line.equals("고등어")) {
					temp += "놀래미\n";
					continue;
				}
				temp += line + "\n";
			}
//			try{
//				a(수정하기)
//				b(덮어쓰기)
//			}
//			
//			try문에 있는 a작업에 오류가 발생하면, b작업은 실행되지 않는다.
//			a가 문제 없이 진행되어야 b를 실행할 수 있다면 위와 같이 로직을 작성한다.
//			고등어 검색 후 수정 부분에서 문제가 생긴다면, 기존 파일을 temp로 덮어쓰면 안되기 때문에
//			try문 안에서 temp로 덮어씌워 준다.
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("fish.txt"));
			bw.write(temp);
			bw.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("경로를 찾을 수 없습니다.");
		} finally /*열린장치나 열린파일을 닫을 때 finally를 사용*/{
			if(br != null) {
				br.close();
			}
		}

//		//삭제
//		//갈치 삭제
//		BufferedReader br = null;
//		try {
//			br = new BufferedReader(new FileReader("fish.txt"));
//			String line = null;
//			String temp = "";
//			
//			while((line = br.readLine()) != null) {
//				if(line.equals("갈치")) {
//					continue;
//				}
//				temp += line + "\n";
//			}
//			
//			BufferedWriter bw = new BufferedWriter(new FileWriter("fish.txt"));
//			bw.write(temp);
//			bw.close();
//			
//		} catch (FileNotFoundException e) {
//			System.out.println("경로를 찾을 수 없습니다.");
//		} finally {
//			if(br != null) {
//				br.close();
//			}
//		}
//		
	}

}
