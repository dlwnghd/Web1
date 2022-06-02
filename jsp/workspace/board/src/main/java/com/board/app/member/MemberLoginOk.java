package com.board.app.member;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.app.action.Action;
import com.board.app.action.ActionInfo;
import com.board.app.domain.dao.MemberDAO;

public class MemberLoginOk implements Action{
	@Override
	public ActionInfo execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		
		ActionInfo actionInfo = new ActionInfo();
		
		String memberId = req.getParameter("memberId");
		String memberPw = req.getParameter("memberPw");
		String saveId = req.getParameter("saveId");
		String autoLogin = req.getParameter("autoLogin");
		int memberNumber = 0;	// 초기화
		
		MemberDAO memberDAO = new MemberDAO();
		
		HashMap<String, String> loginMap = new HashMap<>();
		
		loginMap.put("memberId", memberId);
		loginMap.put("memberPw", memberPw);
		
		memberNumber = memberDAO.login(loginMap);	// memberDAO의 login메소드에 loginMap을 전달
		
		//로그인 성공 시
		if(memberNumber != 0) {
			//세션에 회원번호를 저장한다.
			req.getSession().setAttribute("memberNumber", memberNumber);
			
			//쿠키 생성
			//아이디 저장이 체크되었다면
			if(saveId != null) {
				//쿠키에 아이디와 체크박스 saveId 저장
				Cookie cookieId = new Cookie("memberId", memberId);
				Cookie cookieSaveId = new Cookie("saveId", "saveId");
				
				//유통 기한을 1년으로 설정
				cookieId.setMaxAge(60*60*24*365);	// 60초 * 60분 * 24시간 * 365일
				cookieSaveId.setMaxAge(60*60*24*365);	// 60초 * 60분 * 24시간 * 365일
				
				//응답(respose) 객체에 생성한 쿠키를 넣어준다.
				resp.addCookie(cookieId);	// ID
				resp.addCookie(cookieSaveId);	// SaveId
				
			}else {
				//아이디 저장 체크박스가 체크되지 않았을 경우
				if(req.getHeader("Cookie") != null) {
					//쿠키를 삭제해준다.
					Cookie[] cookies =req.getCookies();
					for(Cookie cookie : cookies) {
						cookie.setMaxAge(0);	// 쿠키 삭제 처리
						resp.addCookie(cookie);	//응답 객체에 비어있는 cookie값을 넣어준다.
					}
				}
			}
			
			//자동 로그인 체크 시
			if(autoLogin != null) {	// 자동 로그인 체크박스가 체크 되어 있다면
				//아이디, 비밀번호, 자동로그인 체크박스를 쿠키에 저장
				Cookie cookieId = new Cookie("memberId", memberId);
				Cookie cookiePw = new Cookie("memberPw", memberPw);
				Cookie cookieAutoLogin = new Cookie("autoLogin", "autoLogin");
				
				
				//유통 기한을 1년으로 설정
				cookieId.setMaxAge(60*60*24*365);	// 60초 * 60분 * 24시간 * 365일
				cookiePw.setMaxAge(60*60*24*365);	// 60초 * 60분 * 24시간 * 365일
				cookieAutoLogin.setMaxAge(60*60*24*365);	// 60초 * 60분 * 24시간 * 365일
				
				//응답(respose) 객체에 생성한 쿠키를 넣어준다.
				resp.addCookie(cookieId);	// ID
				resp.addCookie(cookiePw);	// PW
				resp.addCookie(cookieAutoLogin);	// AutoLogin
				
			}else {
				//자동 로그인 해제 시 기존 쿠키 삭제
				if(req.getHeader("Cookie") != null) {
					Cookie[] cookies =req.getCookies();
					for(Cookie cookie : cookies) {
						cookie.setMaxAge(0);
						resp.addCookie(cookie);
					}
					System.out.println("자동로그인 쿠키 삭제");
				}
			}
			
			// 로그인 성공 시 게시판으로 이동
			actionInfo.setPath("/board/BoardListOk.bo");
			
		}else {
			// 로그인 실패 시 로그인 페이지로 이동
			actionInfo.setPath("/member/MemberLogin.me");
		}
		actionInfo.setRedirect(false);
		
		return actionInfo;
	}
}
















