package com.member.domain.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.member.domain.vo.MemberVO;
import com.mybatis.config.MyBatisConfig;

public class MemberDAO {
	SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
	SqlSession sqlSession;
	
	public MemberDAO() {
		sqlSession = sqlSessionFactory.openSession(true);
	}
	
	//회원가입
	public void join(MemberVO memberVO) {
		sqlSession.insert("Member.join", memberVO);
	}
}
