package com.board.app.member;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.app.action.Action;
import com.board.app.action.ActionInfo;

public class MemberLogout implements Action {

	@Override
	public ActionInfo execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ActionInfo actionInfo = new ActionInfo();
		HttpSession session = req.getSession();
		
		session.invalidate();
		
		if(req.getHeader("Cookie") != null) {
			Cookie[] cookies = req.getCookies();
			for(Cookie cookie : cookies) {
				cookie.setMaxAge(0);
				resp.addCookie(cookie);
			}
		}
		
		actionInfo.setRedirect(true);
		actionInfo.setPath(req.getContextPath() + "/member/MemberLogin.me");
		
		return actionInfo;
	}

}
