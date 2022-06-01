package com.member;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.action.Action;
import com.member.action.ActionInfo;
import com.member.domain.dao.MemberDAO;
import com.member.domain.vo.MemberVO;

public class MemberJoinOk implements Action{
	
	@Override
	public ActionInfo execute(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		req.setCharacterEncoding("UTF-8");
		ActionInfo actionInfo = new ActionInfo();
		MemberVO memberVO = new MemberVO();
		MemberDAO memberDAO = new MemberDAO();
		
		memberVO.setMemberId(req.getParameter("memberId"));
		memberVO.setMemberName(req.getParameter("memberName"));
//		⬇️암호화된 것을 집어 넣음
		memberVO.setMemberPw(new String(Base64.getEncoder().encode(req.getParameter("memberPw").getBytes())));
		memberVO.setMemberGender(req.getParameter("memberGender"));
		memberVO.setMemberAddress(req.getParameter("memberAddress"));
		memberVO.setMemberAddressDetail(req.getParameter("memberAddressDetail"));

		memberDAO.join(memberVO);
		
//		req.setAttribute("memberName", memberVO.getMemberName());
		req.setAttribute("memberList", memberDAO.selectMembers());
		System.out.println(memberDAO.selectMembers().get(0).getMemberName());
		
		actionInfo.setRedirect(false);
		actionInfo.setPath("/joinSuccess.jsp");
		
		return actionInfo;
	}
}






