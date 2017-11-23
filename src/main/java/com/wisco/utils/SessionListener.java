package com.wisco.utils;

import java.util.HashSet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		/*HttpSession session = event.getSession();
		ServletContext application = session.getServletContext();
		HashSet sessions = (HashSet) application.getAttribute("sessions");
		if(sessions == null){
			sessions = new HashSet();
			application.setAttribute("sessions" , sessions);
		}
		sessions.add(session);
		
		System.out.println(sessions.size());*/
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		 HttpSession session = event.getSession();
	      ServletContext application = session.getServletContext();
	      HashSet sessions = (HashSet) application.getAttribute("sessions");
	      
	      // 销毁的session均从HashSet集中移除
	      sessions.remove(session);
		System.out.println(sessions.size());
	}

}
