package edu.acc.java3.ctxlisten;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Controller extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		Dog dog = (Dog)getServletContext().getAttribute("dog");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>\n<html>\n");
		out.print("\t<body><h1>" + dog + "</h1></body>\n");
		out.print("</html>");
	}
}