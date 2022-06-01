package com.member.domain.dao;

import java.util.HashMap;
import java.util.List;

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
   
   //아이디 중복검사
   public boolean checkId(String memberId) {
      return (Integer)sqlSession.selectOne("Member.checkId", memberId) == 1;
   }
   
   //회원 전체 목록
   public List<MemberVO> selectMembers(){
	   return sqlSession.selectList("Member.selectMembers");
   }
   
   //로그인
   public String login(HashMap<String, String> memberMap) {
	   return sqlSession.selectOne("Member.login", memberMap);
   }
}