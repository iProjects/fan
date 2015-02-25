package com.softwareproviders.fanikiwa.core.dao;

import org.junit.Test;

import com.softwareproviders.fanikiwa.core.dao.*;
import com.softwareproviders.fanikiwa.core.entity.*;

public class MemberDaoTest {

	@Test
	public void TestaddMember()
	{
		try
		{
//	MockMemberDAO dac=new MockMemberDAO();
	MemberDAO dac=new MemberDAO();
//	MemberDataStoreDAO dac=new MemberDataStoreDAO();
	Member member=new Member();
	member.setEmail("M@M.m");
	member.setPwd("p.12345");
	member.setStatus("A");
	member.setSurname("DDD");
	member.setGender("M");
	member.setTelephone("012345");
	
	dac.addMember(member);
	
	for(Member m : dac.getMembers())
	{
		System.out.println("Member " + m.getSurname());
	}
		}
		catch(Exception ex)
		{
			 System.out.println(ex);
		}
		
	}
}
