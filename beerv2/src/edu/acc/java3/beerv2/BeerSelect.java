package edu.acc.java3.beerv2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.List;

public class BeerSelect extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String color = request.getParameter("color");

        // New code uses a beer expert to produce a list of palatable beers
        BeerExpert expert = new BeerExpert();
        List<String> beerSuggestions = expert.getBrands(color);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("\t<head>");
        out.println("\t\t<title>BeerV1 Suggestion</title>");
        out.println("\t</head>");
        out.println("\t<body>");
        out.println("\t\tGot beer color: " + color);

        // New code produces an unordered list of delicious beer suggestions in the page
        out.println("\t\t<ul>");
        for (String beer : beerSuggestions)
            out.println("\t\t\t<li>" + beer + "</li>");

        out.println("\t\t</ul>");
        out.println("\t</body>");
        out.println("</html>");
    }

}

