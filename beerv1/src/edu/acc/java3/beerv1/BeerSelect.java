package edu.acc.java3.beerv1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class BeerSelect extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String color = request.getParameter("color");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("\t<head>");
        out.println("\t\t<title>BeerV1 Suggestion</title>");
        out.println("\t</head>");
        out.println("\t<body>");
        out.println("\t\tGot beer color: " + color);
        out.println("\t</body>");
        out.println("</html>");
    }

}
