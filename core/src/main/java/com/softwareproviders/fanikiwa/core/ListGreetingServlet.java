package com.softwareproviders.fanikiwa.core;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.utils.SystemProperty;
import com.softwareproviders.fanikiwa.core.entity.Member;

/**
 * Servlet implementation class ListGreetingServlet
 */
public class ListGreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListGreetingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HandleRequest( request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HandleRequest( request,  response);
	}
	
	  public void HandleRequest(HttpServletRequest req, HttpServletResponse res)
		      throws IOException {
		    res.setContentType("text/plain");

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

		    // List all the rows.
		    res.getWriter().println("To add a greeting click <a href=addGreeting.jsp>here</> <br/> ");
		    EntityManager em = emf.createEntityManager();
		    em.getTransaction().begin();
		    List<Member> result = em
		        .createQuery("FROM Member", Member.class)
		        .getResultList();
		    for (Member g : result) {
		        res.getWriter().println(
		            g.getEmail() + " " +
		            g.getSurname() + "(" + g.getPwd() + "): " +
		            g.getTelephone() + "<br/>");
		      }

		    em.getTransaction().commit();
		    em.close();

		  }
		}


