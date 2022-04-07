package file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileTest{
	//throws : 예외 던지기(일괄 처리)
	//메소드 내에서 자주 발생하는 예외를 메소드를 사용하는 쪽에서 한 번에 예외처리를 하고자 사용한다.
	public static void main(String[] args) throws IOException{
//		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("test.txt"), true));
//		bw.write("한동석\n");
//		bw.newLine();
//		bw.close();
		
		BufferedReader br = null;
		String line = null;
		try {
//			br = new BufferedReader(new FileReader("test2.txt"));
			br = new BufferedReader(new FileReader("test.txt"));
		
			while((line = br.readLine()) != null) {
				System.out.print(line);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("해당 경로에 파일이 없습니다.");
		}
		
	}
}
















