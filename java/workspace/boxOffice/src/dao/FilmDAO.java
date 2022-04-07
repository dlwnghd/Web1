package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import vo.FilmVO;

public class FilmDAO {
	
	//마지막 순위
	public int getLastRanking() throws IOException{
		BufferedReader br = DBConnecter.getReader();
		int lastRanking = 0;
		while(br.readLine() != null) {
			lastRanking ++;
		}
		
		return lastRanking;
	}
	
	//추가와 삽입
	public void appendAndInsert(FilmVO film) throws IOException{
		if(film.getRanking() != 0) {
			insert(film);
			return;
		}
		append(film);
	}
	
	//추가
	//마지막에 영화를 추가하기 때문에 영화 순위는 전달받지 않는다.
	private void append(FilmVO film) throws IOException{
		BufferedReader br = DBConnecter.getReader();
		int lastRanking = 0;
		String data = null;
		String content = null;
		
		while(br.readLine() != null) {
			lastRanking ++;
		}
		br.close();
		
		//전체 내용을 문자열로 가져온다.
		content = new String(Files.readAllBytes(Paths.get(DBConnecter.getPath())));
		
		//전체 내용 중 가장 마지막 문자가 \n인지 검사한다.
		//만약 마지막에 \n이 없다면 data에 \n부터 추가해준다.
		data = content.charAt(content.length() - 1) == '\n' ?  "" : "\n";
		
		//순위를 제외한 나머지 정보 앞에 계산한 마지막 순위를 연결해준다.
		data += lastRanking + 1 + film.toString().substring(film.toString().indexOf("\t"));
		
		BufferedWriter bw = DBConnecter.getAppend();
		bw.write(data);
		bw.close();
	}
	
	//삽입
	private void insert(FilmVO film) throws IOException{
		BufferedReader br = DBConnecter.getReader();
		String line = null;
		String temp = "";
		int newRanking = film.getRanking();
		boolean check = false;
		
		while((line = br.readLine()) != null) {
			//삽입할 순위 검색
			if(Integer.parseInt(line.split("\t")[0]) == film.getRanking()) {
				//삽입
				temp += film.toString() + "\n";
				check = true;
			}
			
			//삽입되었다면 순위 변경
			// - 기존 랭킹을 전위형으로 1씩 증가시키기 때문에 기존순위 + 1로 변경된다. 
			
			//삽입이 안되었다면 순위 유지
			temp += check ? ++newRanking +  line.substring(line.indexOf("\t")): line;
			temp += "\n";
		}
		br.close();
		
		BufferedWriter bw = DBConnecter.getWriter();
		bw.write(temp);
		bw.close();
	}
	
	//수정
	//영화 제목만 수정이 가능하다고 가정한다.
	//영화 제목에 중복이 있을 수 있기 때문에, 영화 순위끼리 비교하여 정확한 수정을 유도한다.
	//외부에서 수정한 영화의 전체 정보를 받는다.
	public void update(FilmVO film) throws IOException{
		// DBConnecter에 만들어놓은 Reader를 getReader메소드를 호출하여 DB에 연결
		BufferedReader br = DBConnecter.getReader();
		String line = null;
		String temp = "";
		
		// 데이터가 없을 때까지 반복
		while((line = br.readLine()) != null) {
			// 순위가 사용자가 수정하고 싶은 순위와 같다면
			// line을 Tab으로 구분한것의 0번째 방을 int화 한것이 film의 getRanking메소드의 return값과 같다면
			if(Integer.parseInt(line.split("\t")[0]) == film.getRanking()) {
				// temp에 사용자가 입력한 전체 수정 정보를 넣어줌
				temp += film.toString() + "\n";
				// 다음 데이터를 가져오기위해서 continue를 이용해 다음 줄에 있는 정보를 불러옴
				continue;
			}
			// 수정하지 않는 정보를 temp에 추가
			temp += line + "\n";
		}
		br.close();
		
		BufferedWriter bw = DBConnecter.getWriter();
		bw.write(temp);
		bw.close();
	}
	
	//삭제
	//외부에서 삭제할 영화의 순위를 전달받는다.
	//영화가 삭제되면 아래의 영화 순위들이 위로 하나씩 올라와야 한다.
	public void delete(int ranking) throws IOException {
		BufferedReader br = DBConnecter.getReader();
		String line = null;
		String temp = "";
		// flag 혹은 check : 확인을 위해 만드는 boolean타입의 객체
		boolean check = false;
		int deletedRanking = ranking;
		
		while((line = br.readLine()) != null) {
			if(Integer.parseInt(line.split("\t")[0]) == ranking){
				check = true;
				continue;
			}
			// 삼항연산자에서 check(삭제확인)가 true라면 삭제된 랭킹에 맞는 랭킹과 나머지 정보를 입력
			temp += check ?  deletedRanking++ + line.substring(line.indexOf("\t")) : line;
			temp += "\n";
		}
		br.close();
		
		BufferedWriter bw = DBConnecter.getWriter();
		bw.write(temp);
		bw.close();
	}
	
	//검색
	//영화 제목으로 조회
	//사용자가 입력한 키워드가 제목에 포함되어 있어도 결과에 담아준다.
	//"아" 검색 시 "아바타"도 검색 결과에 포함
	//외부에서 사용자가 검색하고자 하는 키워드를 전달받는다.
	//검색 결과는 한 개가 아니라 여러 개이므로 ArrayList에 담아서 리턴한다.
	public ArrayList<FilmVO> selectFilm(String keyword) throws IOException {
		BufferedReader br = DBConnecter.getReader();
		String line = null;
		FilmVO film = null;
		ArrayList<FilmVO> films = new ArrayList<>();
		
		while((line = br.readLine()) != null) {
			String[] filmDatas = line.split("\t");
			
			// filmDatas의 1번째방이 keyword에 담긴 값과 같다면
			if(filmDatas[1].contains(keyword)) {
				film = new FilmVO();
				
				film.setRanking(Integer.parseInt(filmDatas[0]));
				film.setName(filmDatas[1]);
				film.setReleaseDate(filmDatas[2]);
				// data에 컴마와 S가 포함되어 있음 -> 불필요한정보
				// 데이터를 형태에 맞게 바꾸기 위해 컴마와 S가 포함되어 있다면 제거후에 set으로 저장
				film.setIncome(Long.parseLong(removeComma(filmDatas[3].equals("") ? "0" : filmDatas[3])));	// 콤마
				film.setAudience(Integer.parseInt(removeS(removeComma(filmDatas[4]))));	// S, 콤마
				film.setScreenCount(Integer.parseInt(removeS(removeComma(filmDatas[5]))));	// S, 콤마
				
				films.add(film);
			}
		}
		br.close();
		
		return films;
	}
	
	//목록
	//전체 정보 리턴
	public ArrayList<FilmVO> selectAll() throws IOException {
		BufferedReader br = DBConnecter.getReader();
		String line = null;
		FilmVO film = null;
		ArrayList<FilmVO> films = new ArrayList<>();
		
		while((line = br.readLine()) != null) {
			String[] filmDatas = line.split("\t");
			
			film = new FilmVO();
			
			film.setRanking(Integer.parseInt(filmDatas[0]));
			film.setName(filmDatas[1]);
			film.setReleaseDate(filmDatas[2]);
			film.setIncome(Long.parseLong(removeComma(filmDatas[3].equals("") ? "0" : filmDatas[3])));
			film.setAudience(Integer.parseInt(removeS(removeComma(filmDatas[4]))));
			film.setScreenCount(Integer.parseInt(removeS(removeComma(filmDatas[5]))));
			
			films.add(film);
		}
		br.close();
		
		return films;
	}
	
	
	//콤마 지우기
	public String removeComma(String data) {
		// 매개변수 1번과 일치하는 모든 것을 매개변수 2번으로 변
		return data.replaceAll(",", "");
	}
	
	//S  지우기
	public String removeS(String data) {
		return data.replaceAll("S ", "");
	}
}
























