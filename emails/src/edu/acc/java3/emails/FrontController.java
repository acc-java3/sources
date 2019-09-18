package edu.acc.java3.emails;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FrontController extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String action = request.getParameter("action"), destination;
		if (action == null || action.length() < 1)
			action = "subscribe";
		switch (action) {
			case "subscribe": destination = subscribe(request); break;
			case "unsubscribe": destination = unsubscribe(request); break;
			case "admin": destination = admin(request); break;
			default: destination = "subscribe";
		}
		
		request.getRequestDispatcher(destination + ".jsp")
			.forward(request,response);
	}
	
	protected String subscribe(HttpServletRequest request) {
		if (request.getMethod().equalsIgnoreCase("GET"))
			return "subscribe";
		String email = request.getParameter("email");
		email = email.trim().toLowerCase();
		if (!email.matches("^.+@.+\\..+$")) {
			request.setAttribute("flash", "Invalid email address");
			return "subscribe";
		}
		Set<String> subscribed = (Set<String>)this.getServletContext().getAttribute("subscribed");
		Set<String> unsubscribed = (Set<String>)this.getServletContext().getAttribute("unsubscribed");
		subscribed.add(email);
		unsubscribed.remove(email);
		request.setAttribute("success", "Thank you for subscribing!");
		return "subscribe";
	}
	
	protected String unsubscribe(HttpServletRequest request) {
		if (request.getMethod().equalsIgnoreCase("GET"))
			return "unsubscribe";
		String email = request.getParameter("email");
		email = email.trim().toLowerCase();
		if (!email.matches("^.+@.+\\..+$")) {
			request.setAttribute("flash", "Invalid email address");
			return "unsubscribe";
		}		
		Set<String> subscribed = (Set<String>)this.getServletContext().getAttribute("subscribed");
		Set<String> unsubscribed = (Set<String>)this.getServletContext().getAttribute("unsubscribed");
		subscribed.remove(email);
		unsubscribed.add(email);
		request.setAttribute("success", "You have unsubscribed. We'll miss you!");
		return "unsubscribe";
	}
	
	protected String admin(HttpServletRequest request) {
		return "admin";
	}	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		processRequest(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		processRequest(request, response);
	}
}