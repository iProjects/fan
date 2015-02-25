package com.softwareproviders.fanikiwa.core.dao;

import java.util.ArrayList;

import com.softwareproviders.fanikiwa.core.entity.Member;

public class MockMemberDAO implements IMemberDAO {
	public static ArrayList<Member> members = new ArrayList<Member>(); 
	public Member addMember(Member member) throws Exception
	{
		if(member == null) throw new Exception("Member cannot be null");
		members.add(member);
		return member;
	}

	public ArrayList<Member> getMembers()
	{
		return members;
	}
}
