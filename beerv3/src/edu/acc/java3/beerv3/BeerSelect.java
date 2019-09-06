package edu.acc.java3.beerv3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.List;

public class BeerSelect extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String color = request.getParameter("color");

        BeerExpert expert = new BeerExpert();
        List<String> beerSuggestions = expert.getBrands(color);

		// New code makes the list of suggestions available to the view JSP
		request.setAttribute("styles", beerSuggestions);

		// This is the code that delegates the response to the JSP
		request.getRequestDispatcher("result.jsp").forward(request, response);
    }

}

