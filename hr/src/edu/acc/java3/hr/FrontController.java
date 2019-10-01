package edu.acc.java3.hr;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import edu.acc.java1.payroll.*;

@SuppressWarnings("unchecked")
public class FrontController extends HttpServlet {

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
        String action = request.getParameter("action"), destination;
        if (action == null || action.length() < 1)
            action = "list"; // or whatever your default action should be
        switch (action) {
			default:
            case "list": destination = list(request); break;
            case "details": destination = details(request); break;
        }

        request.getRequestDispatcher(destination + ".jsp").forward(request,response);
    }
	
	private String list(HttpServletRequest request) {
		return "list";
	}
	
	private String details(HttpServletRequest request) {
		String idTxt = request.getParameter("id");
		try {
			int id = Integer.parseInt(idTxt);
			List<Employee> staff = (List<Employee>)this.getServletContext().getAttribute("staff");
			Employee emp = null;
			for (Employee employee : staff)
				if (employee.getId() == id)
					emp = employee;
			if (emp == null) {
				request.setAttribute("flash", "No employee has id " + id);
			}
			else {
				if (emp instanceof Salaried)
					request.setAttribute("type", "S");
				else if (emp instanceof Pieceworker)
					request.setAttribute("type", "P");
				else if (emp instanceof Hourly)
					request.setAttribute("type", "H");
				request.setAttribute("emp", emp);
			}
		} catch (NullPointerException | NumberFormatException e) {
			request.setAttribute("flash", "Invalid id " + idTxt);
		}
		return "details";
	}


    /* Overrides of doGet() and doPost() should delegate to our initial handler above */

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