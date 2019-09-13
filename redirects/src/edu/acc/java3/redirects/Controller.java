package edu.acc.java3.redirects;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Controller extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		
		String destination = request.getParameter("url");
		if (destination == null || !destination.matches("^https?.+"))
			destination = "http://www.austincc.edu";
		
		response.sendRedirect(destination);
	}
}