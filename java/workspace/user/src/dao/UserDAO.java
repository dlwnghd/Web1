package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import vo.UserVO;

public class UserDAO {
	// 로그인 성공 시 로그인된 회원의 번호를 저장할 변수
	public static int userNumber;
	public static final int GOODBYE_ACCOUNT = -1;
	public static final int LOGIN_SUCCESS = 1;
	public static final int LOGIN_FAILURE = 0;

	// 연결 객체
	Connection conn;

	// SQL 쿼리문을 실행 해주는 객체
	PreparedStatement pstm;

	// 결과 테이블에 대한 정보를 가져올 수 있도록 도와주는 객체
	ResultSet rs;

	// 아이디 중복검사
	public boolean checkId(String userId) {
		// 실행할 SQL문 작성
		String query = "SELECT COUNT(USER_NUMBER) FROM TBL_USER WHERE USER_ID = ?";
		boolean check = false;
		try {
			// 연결 객체 가져오기
			conn = DBConnection.getConnection();
			// 연결 객체를 통해 SQL문을 담아줄 prepareStatement() 사용
			pstm = conn.prepareStatement(query);
			// SQL에 작성된 ?에 넣어줄 값을 설정
			pstm.setString(1, userId);
			// SQL 실행, 결과를 rs객체에 담아주기
			rs = pstm.executeQuery();

			// 행 가져오기
			rs.next();
			// 첫번째 열을 가져온 뒤 1일 경우 이미 있는 아이디로 판단(true)
			check = rs.getInt(1) == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 열었던 순서의 반대 순서로 닫아준다.
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// 닫으면서 예외가 발생하면 반드시 프로그램을 강제 종료하여 메모리를 지켜준다!
				// throw : 예외 발생
				throw new RuntimeException(e);
			}
		}
		return check;
	}

	// 회원가입
	// SQL문 실행 시 SELECT가 아니라면 executeUpdate()를 사용한다.
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
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	// 로그인
	public int login(String userId, String userPw) {
		userNumber = 0;
		String query = "SELECT USER_NUMBER, STATUS FROM TBL_USER WHERE USER_ID = ? AND USER_PW = ?";

		// 초기값은 0이다(로그인 실패).
		int check = LOGIN_FAILURE;
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			pstm.setString(2, userPw);
			// executeQuery() : SELECT
			// executeUpdate() : INSERT, UPDATE, DELETE
			rs = pstm.executeQuery();

			if (rs.next()) { // 사용자가 입력한 아이디와 비밀번호가 DB에서 조회된다면
				userNumber = rs.getInt(1); // 로그인 된 회원의 번호를 userNumber에 담는다.

				check = rs.getInt(2) == 0 ? LOGIN_SUCCESS : GOODBYE_ACCOUNT;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return check;
	}

	// 아이디 찾기
	// 1. 핸드폰 번호로 랜덤한 인증번호 6자리 전송
	public String sendSMS(String userPhoneNumber) {
		String api_key = "";
		String api_secret = "";
		String code = "";
		int length = 0;
		Random r = new Random();

		code += r.nextInt(1000000);

		length = 6 - code.length();

		for (int i = 0; i < length; i++) {
			code = "0" + code;
		}

		Message coolsms = new Message(api_key, api_secret);

		// 4 params(to, from, type, text) are mandatory. must be filled
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", userPhoneNumber);
		params.put("from", "01000000000");
		params.put("type", "SMS");
		params.put("text", "인증번호[" + code + "]를 입력해주세요.");
		params.put("app_version", "test app 1.2"); // application name and version

		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
		return code;
	}

	// 2. 전송된 인증번호 검사(화면에서 처리)
	// 3. 인증성공 시 해당 아이디 출력

	// 한 사람당 한 개
	public String findId(String userPhoneNumber) {
		String query = "SELECT USER_ID FROM TBL_USER WHERE USER_PHONE_NUMBER = ?";
		String userId = null;
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userPhoneNumber);
			// executeQuery() : SELECT
			// executeUpdate() : INSERT, UPDATE, DELETE
			rs = pstm.executeQuery();

			rs.next();
			userId = rs.getString(1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return userId;
	}

	// 한 사람당 여러 개
	public ArrayList<String> findIdAll(String userPhoneNumber) {
		String query = "SELECT USER_ID FROM TBL_USER WHERE USER_PHONE_NUMBER = ?";
		ArrayList<String> ids = new ArrayList<>();
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userPhoneNumber);
			// executeQuery() : SELECT
			// executeUpdate() : INSERT, UPDATE, DELETE
			rs = pstm.executeQuery();

			while (rs.next()) {
				ids.add(rs.getString(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return ids;
	}

	// 비밀번호 찾기
	// 새로운 비밀번호로 변경하기
	public void findPw(String userId, String userPw) {
		String query = "UPDATE TBL_USER SET USER_PW = ? WHERE USER_ID = ?";

		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userPw);
			pstm.setString(2, userId);

			// executeQuery() : SELECT : 결과 테이블(ResultSet) 리턴
			// executeUpdate() : INSERT, UPDATE, DELETE : 실행 건수 리턴
			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

	}

	// 임시 비밀번호 전송
//   public void findPw(String userId, String userPhoneNumber) {
//   }

	// 회원 정보 수정(이름, 나이, 핸드폰번호, 비밀번호 수정)
	public void updateInfo(UserVO user) {
		String query = "UPDATE TBL_USER SET USER_NAME = ?, USER_AGE = ?, USER_PHONE_NUMBER = ?, USER_PW = ? ";
		query += "WHERE USER_NUMBER = ?";

		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, user.getUserName());
			pstm.setInt(2, user.getUserAge());
			pstm.setString(3, user.getUserPhoneNumber());
			pstm.setString(4, user.getUserPw());
			pstm.setInt(5, user.getUserNumber());

			// executeQuery() : SELECT : 결과 테이블(ResultSet) 리턴
			// executeUpdate() : INSERT, UPDATE, DELETE : 실행 건수 리턴
			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	// 회원 탈퇴
	// 회원 탈퇴시 회원의 상태는 1로 변경된다.
	public void goodbyeUser() {
		String query = "UPDATE TBL_USER SET STATUS = 1 WHERE USER_NUMBER = ?";

		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			// 로그인된 회원의 번호로 그 회원의 상태를 1로 변경한다.
			pstm.setInt(1, userNumber);

			// executeQuery() : SELECT : 결과 테이블(ResultSet) 리턴
			// executeUpdate() : INSERT, UPDATE, DELETE : 실행 건수 리턴
			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

	}

	// 회원 복구
	// 로그인 시 탈퇴된 계정이라면, 복구 버튼 출력
	// 복구 버튼 클릭 시 회원 status를 0으로 수정
	public void restore() {
		String query = "UPDATE TBL_USER SET STATUS = 0 WHERE USER_NUMBER = ?";

		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, userNumber);

			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

	}

	// 핸드폰 번호 중복검사
	public boolean checkPhoneNumber(String userPhoneNumber) {
		String query = "SELECT COUNT(USER_PHONE_NUMBER) FROM TBL_USER WHERE USER_PHONE_NUMBER = ?";
		boolean check = false;

		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userPhoneNumber);

			rs = pstm.executeQuery();
			rs.next();
			check = rs.getInt(1) == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return check;
	}
}
