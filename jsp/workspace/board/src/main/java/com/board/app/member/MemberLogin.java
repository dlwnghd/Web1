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
      
      
      if(cookieCheck != null) {	// 기존에 쿠키가 있는지 검사
			Cookie[] cookies = req.getCookies();
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("memberId")) {	// cookie에 있는 name중에서 "memberId"라는 이름의 쿠키가 있다면
					memberId = cookie.getValue();	// id 저장
					
				} else if(cookie.getName().equals("memberPw")) {	// cookie에 있는 name중에서 "memberPw"라는 이름의 쿠키가 있다면
					memberPw = cookie.getValue();	// pw 저장
					
				} else if(cookie.getName().equals("saveId")) {	// cookie에 있는 name중에서 "saveId"라는 이름의 쿠키가 있다면
					saveId = cookie.getValue();	// 아이디 저장 체크박스 체크정보
					
				}else if(cookie.getName().equals("autoLogin")) {		// cookie에 있는 name중에서 "autoLogin"라는 이름의 쿠키가 있다면
					autoLogin = cookie.getValue();	// 자동 로그인 체크박스 체크정보
					
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
      
      // login.jsp에서 위 객체들을 가지고 옴
      actionInfo.setPath("/app/member/login.jsp");
      actionInfo.setRedirect(false);
      
      return actionInfo;
   }

}




















