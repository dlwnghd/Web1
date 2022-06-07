package com.board.app.domain.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.board.app.domain.vo.ReplyDTO;
import com.board.app.domain.vo.ReplyVO;
import com.mybatis.config.MyBatisConfig;

public class ReplyDAO {
	SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
	SqlSession sqlSession;
	
	public ReplyDAO() {
		sqlSession = sqlSessionFactory.openSession(true);
	}

	public List<ReplyDTO> getList(int boardNumber) {
		return sqlSession.selectList("Reply.select", boardNumber);
	} 
	
	public void insert(ReplyVO replyVO) {
		sqlSession.insert("Reply.insert", replyVO);
	}
	
	public void delete(int replyNumber) {
		sqlSession.delete("Reply.delete", replyNumber);
	}
	public void update(ReplyVO replyVO) {
		sqlSession.update("Reply.update", replyVO);
	}
	
}












