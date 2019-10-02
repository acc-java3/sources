package edu.acc.java3.calqlator;

import java.util.*;
import javax.servlet.http.*;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent e) {
		LinkedList<String> calcList = new LinkedList<>();
		e.getSession().setAttribute("calcList", calcList);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public void sessionDestroyed(HttpSessionEvent e) {
		LinkedList<String> calcList = (LinkedList<String>)e.getSession().getAttribute("calcList");
		calcList.clear();
		e.getSession().removeAttribute("calcList");
		calcList = null;
	}
}