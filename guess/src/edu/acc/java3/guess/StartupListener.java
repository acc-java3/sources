package edu.acc.java3.guess;

import javax.servlet.*;

public class StartupListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent e) {
		ServletContext sc = e.getServletContext();
		int range = Integer.parseInt(sc.getInitParameter("range"));
		sc.setAttribute("range", range);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent e) {
	}
	
}