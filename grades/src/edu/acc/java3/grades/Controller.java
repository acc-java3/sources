package edu.acc.java3.grades;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Controller extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {

        final double[] grades =
                {2.9, 2.9, 3.8, 3.1, 3.4, 2.7, 2.1, 2.8, 3.2, 3.3, 3.8, 2.6};
        final DoubleSummaryStatistics stats = Arrays.stream(grades).summaryStatistics();
        request.setAttribute("grades", grades);
        request.setAttribute("stats", stats);
        request.getRequestDispatcher("view.jsp").forward(request, response);
    }

}