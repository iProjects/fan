package com.softwareproviders.fanikiwa.core.business;

import com.softwareproviders.fanikiwa.core.dao.MemberDAO;
import com.softwareproviders.fanikiwa.core.entity.Member;

public class RegisterComponent {
	

	public Member addMember(Member member) throws Exception
	{
		MemberDAO memberDac = new MemberDAO();
		return memberDac.addMember(member);
	}
}