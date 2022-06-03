package com.board.app.domain.dao;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.board.app.domain.vo.BoardDTO;
import com.board.app.domain.vo.BoardVO;
import com.board.app.domain.vo.FileVO;
import com.mybatis.config.MyBatisConfig;
import com.oreilly.servlet.MultipartRequest;

public class FileDAO {
	SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
	SqlSession sqlSession;
	
	public FileDAO() {
		sqlSession = sqlSessionFactory.openSession(true);
	}
	
	public void insert(MultipartRequest multipartRequest, int boardNumber) {
		FileVO file = new FileVO();
		//type="file"인 태그의 name 값들
		Enumeration<String> files = multipartRequest.getFileNames();
		
		while(files.hasMoreElements()) {
			String name = files.nextElement();
			//원본 파일 이름
			String fileNameOriginal = multipartRequest.getOriginalFileName(name);
			//중복 시 변경되는 이름
			String fileName = multipartRequest.getFilesystemName(name);
			
			if(fileName == null) {continue;}
			
			file.setFileName(fileName);
			file.setFileNameOriginal(fileNameOriginal);
			file.setBoardNumber(boardNumber);
			
			insert(file);
		}
	}
	
	public void insert(FileVO fileVO) {
		sqlSession.insert("File.insert", fileVO);
	}
	
	public void delete(int boardNumber) {
		sqlSession.delete("File.delete", boardNumber);
	}
	
	public List<FileVO> select(int boardNumber){
		return sqlSession.selectList("File.select", boardNumber);
	}
}












