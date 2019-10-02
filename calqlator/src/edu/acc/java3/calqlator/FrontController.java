package edu.acc.java3.calqlator;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FrontController extends HttpServlet {

	private String actionDefault;
	private String viewDir;
	private String viewType;
	
	@Override
	public void init() {
		ServletContext sc = this.getServletContext();
		actionDefault = sc.getInitParameter("action.default");
		viewDir = sc.getInitParameter("view.dir");
		viewType = sc.getInitParameter("view.type");
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		String action = request.getParameter("action"), destination = actionDefault;
		if (action == null || action.length() < 1) action = actionDefault;
		switch (action) {
			default:
			case "calculate": destination = calculate(request); break;

		}
		request.getRequestDispatcher(viewDir + "/" + destination + viewType).forward(request, response);		
	}

	@SuppressWarnings("unchecked")
	private String calculate(HttpServletRequest request) {
		String destination = "calculate";
		if (request.getMethod().equalsIgnoreCase("GET")) return destination;
		String op1 = request.getParameter("op1");
		String op2 = request.getParameter("op2");
		String op = request.getParameter("op");
		if (op1 == null || op == null || op2 == null) return destination;
		
		try {
			double result = Calqlator.execute(op1, op, op2);
			String lastCalc = String.format("%s %s %s = %f", op1, op, op2, result);
			LinkedList<String> calcList = (LinkedList<String>)request.getSession()
					.getAttribute("calcList");
			calcList.addFirst(lastCalc);
			request.setAttribute("lastCalc", lastCalc);
		}
		catch (NumberFormatException nfe) {
			request.setAttribute("flash", "Error " + nfe.getMessage() + ". Use real numbers only.");
		}
		catch (UnsupportedOperationException uoe) {
			request.setAttribute("flash", op + " is not a recognized operation.");
		}
		return destination;
	}
	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		processRequest(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		processRequest(request, response);
	}
	
}