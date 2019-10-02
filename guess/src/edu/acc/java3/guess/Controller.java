package // your package name here

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FrontController extends HttpServlet {
	/*
		You can configure these in the deployment descriptor and load
		values using an override of this Servlet's init() method or you
		can just set the defaults here as you wish;
	*/
	private String actionDefault; // the initial action of your app
	private String viewDir;		  // the folder where your JSPs are stored
	private String viewType;	  // the filename extension of your preferred view language (.jsp for us)
	
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
			/* Add a case for each action (feature) you want to define using this
				pattern:
				case "action-name-here": destination = action-name-here(request); break;
			*/
		}
		request.getRequestDispatcher(viewDir + "/" + destination + viewType).forward(request, response);		
	}
	
	/*
		Add handlers for your actions here using this pattern:
		private String action-name-here(HttpServletRequest request) {
		}
	
		Make sure to return the name of the destination view without the
		filename extension
	*/
	
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