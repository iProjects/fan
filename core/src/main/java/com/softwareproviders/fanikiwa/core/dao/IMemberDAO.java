package com.softwareproviders.fanikiwa.core.dao;

import java.util.List;

import com.softwareproviders.fanikiwa.core.entity.Member;

public interface IMemberDAO  {
	 Member addMember(Member member) throws Exception;
	 List<Member> getMembers();
}
