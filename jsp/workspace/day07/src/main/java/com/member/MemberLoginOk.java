package com.member;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.action.Action;
import com.member.action.ActionInfo;
import com.member.domain.dao.MemberDAO;

public class MemberLoginOk implements Action {

	@Override
	public ActionInfo execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		
		ActionInfo actionInfo = new ActionInfo();
		HttpSession session = req.getSession();
		HashMap<String, String> memberMap = new HashMap<>();
		MemberDAO memberDAO = new MemberDAO();
		String memberId = req.getParameter("memberId");
		String memberPw = req.getParameter("memberPw");
		int memberNumber = 0;
//		암호화된 것을 받았기 때문에 함호화된 것으로 비교해 주어야한다.
		memberPw = new String(Base64.getEncoder().encode(memberPw.getBytes()));
		
//		MemberMapper에서 쓴 이름 그대로 담아주기
		memberMap.put("memberId", memberId);
		memberMap.put("memberPw", memberPw);
		
		try {
//			로그인 실패시, null들어온다!
//			그래서 int로 못바꾸니까 Exception 뜸!
//			memberNumber = memberDAO.login(memberMap);
			//여기 밑으로 내려오는 건 로그인 성공 시에만 가능
			session.setAttribute("memberNumber", memberNumber);
				//세션 초기화
//			session.invalidate();
		} catch (Exception e) {
			//로그인 실패
			System.out.println("로그인 실패");
			actionInfo.setRedirect(false);
			actionInfo.setPath("/login.jsp");
		}
		actionInfo.setRedirect(false);
		actionInfo.setPath("/loginSuccess.jsp");
		
		return actionInfo;
	}

}

















