/**
 * Copyright 2012 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.softwareproviders.fanikiwa.core;

import com.google.appengine.api.utils.SystemProperty;
import com.softwareproviders.fanikiwa.core.dao.MemberDAO;
import com.softwareproviders.fanikiwa.core.entity.Member;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.*;

public class HibernateJpaServlet extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws IOException {
	  HandleRequest(req,res);
  }
  
  public void doPost(HttpServletRequest req, HttpServletResponse res)
	      throws IOException {
		  HandleRequest(req,res);
	  }
  
  public void HandleRequest(HttpServletRequest req, HttpServletResponse res)
      throws IOException {
    res.setContentType("text/plain");

    // Insert a few rows.
    String email = req.getParameter("email");
    String pwd = req.getParameter("pwd");
    String surname = req.getParameter("surname");
    String telno = req.getParameter("telno");
    
    Member member = new Member();
    member.setEmail(email);
	member.setPwd(pwd);
	member.setStatus("A");
	member.setSurname(surname);
	member.setGender("M");
	member.setTelephone(telno);
	
    MemberDAO mdac = new MemberDAO();
    try
    {
    mdac.addMember(member);
    }catch(Exception x)
    {
    	res.getWriter().println(x.toString());
    }

  }
}
