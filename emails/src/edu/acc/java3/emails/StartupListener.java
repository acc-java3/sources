package edu.acc.java3.emails;

import java.util.*;
import javax.servlet.*;

public class StartupListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent e) {
		Set<String> subscribed = new HashSet<>();
		Set<String> unsubscribed = new HashSet<>();
		e.getServletContext().setAttribute("subscribed", subscribed);
		e.getServletContext().setAttribute("unsubscribed", unsubscribed);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent e) {
		
	}
	
}