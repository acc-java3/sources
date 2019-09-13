package edu.acc.java3.ctxlisten;

import javax.servlet.*;

public class StartupListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent e) {
		Dog fido = new Dog("Fido", "Hound");
		e.getServletContext().setAttribute("dog", fido);
		e.getServletContext().log("*** App started with " + fido);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent e) {
		e.getServletContext().log("*** App shutting down");
	}
}