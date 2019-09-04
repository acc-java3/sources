package edu.acc.java3.hello;        // all jee-compatible classes must be packaged

import java.io.*;                   // for IOException and PrintWriter
import java.util.Date;
import javax.servlet.*;             // for ServletException
import javax.servlet.http.*;        // for HttpServlet, HttpServletRequest, and HttpServletResponse

public class HelloServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        // first, we have to tell the browser what kind of information is coming
        response.setContentType("text/html");
        
        // Then we can get a text stream to the browser and start sending stuff
        PrintWriter pw = response.getWriter();
        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("\t<body>");
        pw.println("\t\t<h1>");
        
        Date now = new Date();
        pw.println("\t\t\t" + now);
        
        pw.println("\t\t</h1>");
        pw.println("\t</body>");
        pw.println("</html>");
        
        // reaching the end of doGet() completes the response
    }
}
