package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.UserVO;

public class UserDAO {
   //연결 객체
   Connection conn;
   
   //SQL 쿼리문을 실행 해주는 객체
   PreparedStatement pstm;
   
   //결과 테이블에 대한 정보를 가져올 수 있도록 도와주는 객체
   ResultSet rs;
   
   //아이디 중복검사
   public boolean checkId(String userId) {
      //실행할 SQL문 작성
      String query = "SELECT COUNT(USER_NUMBER) FROM TBL_USER WHERE USER_ID = ?";
      boolean check = false;
      try {
         //연결 객체 가져오기
         conn = DBConnection.getConnection();
         //연결 객체를 통해 SQL문을 담아줄 prepareStatement() 사용
         pstm = conn.prepareStatement(query);
         //SQL에 작성된 ?에 넣어줄 값을 설정
         pstm.setString(1, userId);
         //SQL 실행, 결과를 rs객체에 담아주기
         rs = pstm.executeQuery();

         //행 가져오기
         rs.next();
         //첫번째 열을 가져온 뒤 1일 경우 이미 있는 아이디로 판단(true)
         check = rs.getInt(1) == 1;
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         //열었던 순서의 반대 순서로 닫아준다.
         try {
            if(rs != null) {
               rs.close();
            }
            if(pstm != null) {
               pstm.close();
            }
            if(conn != null) {
               conn.close();
            }
         } catch (SQLException e) {
            //닫으면서 예외가 발생하면 반드시 프로그램을 강제 종료하여 메모리를 지켜준다!
            //throw : 예외 발생
            throw new RuntimeException(e);
         }
      }
      return check;
   }
   
   //회원가입
   //SQL문 실행 시 SELECT가 아니라면 executeUpdate()를 사용한다.
   public void join(UserVO userVO) {
      String query = "INSERT INTO TBL_USER (USER_NUMBER, USER_ID, USER_PW, USER_NAME, USER_AGE, USER_PHONE_NUMBER)";
      query += " VALUES(SEQ_USER.NEXTVAL, ?, ?, ?, ?, ?)";
      try {
         conn = DBConnection.getConnection();
         pstm = conn.prepareStatement(query);
         pstm.setString(1, userVO.getUserId());
         pstm.setString(2, userVO.getUserPw());
         pstm.setString(3, userVO.getUserName());
         pstm.setInt(4, userVO.getUserAge());
         pstm.setString(5, userVO.getUserPhoneNumber());
         
         pstm.executeUpdate();
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            if(pstm != null) {
               pstm.close();
            }
            if(conn != null) {
               conn.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e);
         }
      }
   }
   
   //로그인
   public boolean login(String id, String pw) {
	   String query = "SELECT * FROM user"
	   		+ "WHERE USER_ID = ? AND USER_PW = ?";
	   boolean check = false;
	      try {
	         conn = DBConnection.getConnection();
	         pstm = conn.prepareStatement(query);
	         pstm.setString(1, id);
	         pstm.setString(2, pw);
	         
	         rs = pstm.executeQuery();
	         
	         rs.next();
	         //첫번째 열을 가져온 뒤 1일 경우 이미 있는 아이디로 판단(true)
	         check = rs.getInt(1) == 0;
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            if(pstm != null) {
	               pstm.close();
	            }
	            if(conn != null) {
	               conn.close();
	            }
	         } catch (SQLException e) {
	            throw new RuntimeException(e);
	         }
	      }
	   
	   return check;
   }
}

































