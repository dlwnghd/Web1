package com.board.app.domain.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.board.app.domain.vo.MemberVO;
import com.mybatis.config.MyBatisConfig;

public class MemberDAO {
	SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
	SqlSession sqlSession;
	
	public MemberDAO() {
		sqlSession = sqlSessionFactory.openSession(true);
	}
	
	//아이디 중복검사
	public boolean checkId(String memberId) {
		return (Integer)sqlSession.selectOne("Member.checkId", memberId) == 1;
	}
	
	//회원가입
	public void insert(MemberVO memberVO) {
		sqlSession.insert("Member.insert", memberVO);
	}
	
	//로그인
	public int login(HashMap<String, String> loginMap) {
		return sqlSession.selectOne("Member.login", loginMap);
	}
}
