package com.member;

import java.io.IOException;

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
		memberVO.setMemberPw(req.getParameter("memberPw"));
		memberVO.setMemberGender(req.getParameter("memberGender"));
		memberVO.setMemberAddress(req.getParameter("memberAddress"));
		memberVO.setMemberAddressDetail(req.getParameter("memberAddressDetail"));

		memberDAO.join(memberVO);
		
		req.setAttribute("memberName", memberVO.getMemberName());
		
		
		actionInfo.setRedirect(false);	// true면 데이터가 다 날아가니 false로 지정
		actionInfo.setPath("/joinSuccess.jsp");
		
		return actionInfo;
	}
}






