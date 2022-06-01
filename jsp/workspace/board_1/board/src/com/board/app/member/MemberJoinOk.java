package com.board.app.member;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.app.action.Action;
import com.board.app.action.ActionInfo;
import com.board.app.domain.dao.MemberDAO;
import com.board.app.domain.vo.MemberVO;

public class MemberJoinOk implements Action {

	@Override
	public ActionInfo execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		ActionInfo actionInfo = new ActionInfo();
		MemberDAO memberDAO = new MemberDAO();
		MemberVO memberVO = new MemberVO();
		
		memberVO.setMemberId(req.getParameter("memberId"));
		memberVO.setMemberPw(new String(Base64.getEncoder().encode(req.getParameter("memberPw").getBytes())));
		memberVO.setMemberName(req.getParameter("memberName"));
		memberVO.setMemberAge(Integer.parseInt(req.getParameter("memberAge")));
		memberVO.setMemberGender(req.getParameter("memberGender"));
		memberVO.setMemberEmail(req.getParameter("memberEmail"));
		memberVO.setMemberZipcode(req.getParameter("memberZipcode"));
		memberVO.setMemberAddress(req.getParameter("memberAddress"));
		memberVO.setMemberAddressDetail(req.getParameter("memberAddressDetail"));
		
		memberDAO.insert(memberVO);
		
		actionInfo.setPath("/member/MemberLogin.me");
		actionInfo.setRedirect(false);
		return actionInfo;
	}

}

















