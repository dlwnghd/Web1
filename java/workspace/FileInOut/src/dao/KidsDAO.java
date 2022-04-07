package dao;

import java.io.*;
import java.util.*;
import java.nio.file.*;

import vo.KidsVO;;

public class KidsDAO {
	// 마지막 순위
	public int getLastRanking() throws IOException {
		BufferedReader br = DBConnecter.getReader();
		int lastRanking = 0;
		while (br.readLine() != null) {
			lastRanking++;
		}

		return lastRanking;
	}

	
	
}
