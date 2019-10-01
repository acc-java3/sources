package edu.acc.java3.guess;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Controller extends HttpServlet {
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
			case "start": destination = start(request); break;
			case "guess": destination = guess(request); break;
		}
		request.getRequestDispatcher(viewDir + "/" + destination + viewType).forward(request, response);		
	}
	
	private String start(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int range = (Integer)this.getServletContext().getAttribute("range");
		Game game = new Game(range);
		session.setAttribute("game", game);
		return "start";
	}
	
	private String guess(HttpServletRequest request) {
		if (request.getMethod().equalsIgnoreCase("GET")) return "start";
		Game game = (Game)request.getSession().getAttribute("game");
		String destination = "guess";
		String guessText = request.getParameter("guess");		
		try {
			int guess = Integer.parseInt(guessText);
			int result = game.guess(guess);
			if (result < 0)
				request.setAttribute("message", "Guess higher than " + guess);
			else if (result > 0)
				request.setAttribute("message", "Guess lower than " + guess);
			else 
				destination = "win";
		} catch (IllegalArgumentException | NullPointerException e) {
			request.setAttribute("flash",
				"Guess must be a number between 1 and " + game.getRange());
		} finally {
			return destination;
		}
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