package com.softwareproviders.fanikiwa.core.dao;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.appengine.api.utils.SystemProperty;
import com.softwareproviders.fanikiwa.core.entity.*;

public class MemberDAO implements IMemberDAO {
	public Member addMember(Member member) throws Exception
	{
		if(member == null) throw new Exception("Member cannot be null");

	    Map<String, String> properties = new HashMap();
	    if (SystemProperty.environment.value() ==
	          SystemProperty.Environment.Value.Production) {
	      properties.put("javax.persistence.jdbc.driver",
	          "com.mysql.jdbc.GoogleDriver");
	      properties.put("javax.persistence.jdbc.url",
	          System.getProperty("cloudsql.url"));
	    } else {
	      properties.put("javax.persistence.jdbc.driver","com.mysql.jdbc.Driver");
	      properties.put("javax.persistence.jdbc.url",System.getProperty("cloudsql.url.dev"));
	      properties.put("javax.persistence.jdbc.user",System.getProperty("cloudsql.user.dev"));
	      properties.put("javax.persistence.jdbc.password",System.getProperty("cloudsql.password.dev"));
	    }

	    EntityManagerFactory emf = Persistence.createEntityManagerFactory(
	        "core", properties);

	    // Insert a few rows.
	    EntityManager em = emf.createEntityManager();
//	    em.getTransaction().begin();
	    em.persist(member);
//	    em.getTransaction().commit();
	    em.close();
		return member;
	}

	public List<Member> getMembers()
	{
		Map<String, String> properties = new HashMap();
	    if (SystemProperty.environment.value() ==
	          SystemProperty.Environment.Value.Production) {
	      properties.put("javax.persistence.jdbc.driver",
	          "com.mysql.jdbc.GoogleDriver");
	      properties.put("javax.persistence.jdbc.url",
	          System.getProperty("cloudsql.url"));
	    } else {
	      properties.put("javax.persistence.jdbc.driver","com.mysql.jdbc.Driver");
	      properties.put("javax.persistence.jdbc.url",System.getProperty("cloudsql.url.dev"));
	      properties.put("javax.persistence.jdbc.user",System.getProperty("cloudsql.user.dev"));
	      properties.put("javax.persistence.jdbc.password",System.getProperty("cloudsql.password.dev"));
	    }

	    EntityManagerFactory emf = Persistence.createEntityManagerFactory(
	        "core", properties);
	    EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    List<Member> result = em
	        .createQuery("FROM Member", Member.class)
	        .getResultList();
	    em.getTransaction().commit();
	    em.close();
	    
	    return result;
	}
}
