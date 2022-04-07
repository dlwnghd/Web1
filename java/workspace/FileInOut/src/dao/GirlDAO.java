package dao;

import java.io.*;
import java.util.*;

import vo.KidsVO;;

public class GirlDAO {
	
	// 콤마 지우기
	public String removeComma(String data) {
		// 매개변수 1번과 일치하는 모든 것을 매개변수 2번으로 변
		return data.replaceAll(",", "");
	}

	// 변경된 데이터
	private KidsVO setObject() throws IOException {
		BufferedReader br = DBConnecter.getReader();
		String line = null;
		KidsVO Kid = null;
		ArrayList<KidsVO> girls = new ArrayList<>();

		while ((line = br.readLine()) != null) {
			String[] kidsDatas = line.split("\t");

			Kid = new KidsVO();

			Kid.setSex("M");
			Kid.setName(kidsDatas[0]);
			Kid.setRanking(Integer.parseInt(kidsDatas[1]));
			Kid.setNameCount(Integer.parseInt(removeComma(kidsDatas[2])));
			girls.add(Kid);
		}
		br.close();

		return Kid;
	}
}
