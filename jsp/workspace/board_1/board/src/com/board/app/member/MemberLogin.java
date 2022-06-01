package com.board.app.member;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.app.action.Action;
import com.board.app.action.ActionInfo;

public class MemberLogin implements Action {

	@Override
	public ActionInfo execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		ActionInfo actionInfo = new ActionInfo();
		
		//쿠키 검사
		String memberId = null;
		String memberPw = null;
		String saveId = null;
		String autoLogin = null;
		
		String cookieCheck = req.getHeader("Cookie");
		
		
		if(cookieCheck != null) {
			Cookie[] cookies = req.getCookies();
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("memberId")) {
					memberId = cookie.getValue();
					
				} else if(cookie.getName().equals("memberPw")) {
					memberPw = cookie.getValue();
					
				} else if(cookie.getName().equals("saveId")) {
					saveId = cookie.getValue();
					
				}else if(cookie.getName().equals("autoLogin")) {
					autoLogin = cookie.getValue();
					
				}
			}
		}
		
		req.setAttribute("memberId", memberId);
		req.setAttribute("memberPw", memberPw);
		req.setAttribute("saveId", saveId);
		req.setAttribute("autoLogin", autoLogin);
		
		System.out.println(memberId);
		System.out.println(memberPw);
		System.out.println(saveId);
		System.out.println(autoLogin);
		
		actionInfo.setPath("/app/member/login.jsp");
		actionInfo.setRedirect(false);
		
		return actionInfo;
	}

}





















