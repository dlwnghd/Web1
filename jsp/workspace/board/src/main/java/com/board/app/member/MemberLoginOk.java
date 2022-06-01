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
		int memberNumber = 0;
		
		MemberDAO memberDAO = new MemberDAO();
		
		HashMap<String, String> loginMap = new HashMap<>();
		
		loginMap.put("memberId", memberId);
		loginMap.put("memberPw", memberPw);
		
		memberNumber = memberDAO.login(loginMap);
		
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
				cookieId.setMaxAge(60*60*24*365);
				cookieSaveId.setMaxAge(60*60*24*365);
				
				//응답 객체에 생성한 쿠키를 넣어준다.
				resp.addCookie(cookieId);
				resp.addCookie(cookieSaveId);
				
			}else {
				//아이디 저장이 체크되지 않았을 경우
				if(req.getHeader("Cookie") != null) {
					//쿠키를 삭제해준다.
					Cookie[] cookies =req.getCookies();
					for(Cookie cookie : cookies) {
						cookie.setMaxAge(0);
						resp.addCookie(cookie);
					}
				}
			}
			
			//자동 로그인 체크 시
			if(autoLogin != null) {
				//아이디, 비밀번호, 자동로그인 체크박스를 쿠키에 저장
				Cookie cookieId = new Cookie("memberId", memberId);
				Cookie cookiePw = new Cookie("memberPw", memberPw);
				Cookie cookieAutoLogin = new Cookie("autoLogin", "autoLogin");
				
				cookieId.setMaxAge(60*60*24*365);
				cookiePw.setMaxAge(60*60*24*365);
				cookieAutoLogin.setMaxAge(60*60*24*365);
				
				resp.addCookie(cookieId);
				resp.addCookie(cookiePw);
				resp.addCookie(cookieAutoLogin);
				
			}else {
				//자동 로그인 해제 시 기존 쿠키 삭제
				if(req.getHeader("Cookie") != null) {
					Cookie[] cookies =req.getCookies();
					for(Cookie cookie : cookies) {
						cookie.setMaxAge(0);
						resp.addCookie(cookie);
					}
				}
			}
			
			actionInfo.setPath("/board/BoardListOk.bo");
			
		}else {
			actionInfo.setPath("/member/MemberLogin.me");
		}
		actionInfo.setRedirect(false);
		
		return actionInfo;
	}
}
















