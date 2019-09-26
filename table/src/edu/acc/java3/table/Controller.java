package edu.acc.java3.table;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {
    private int defaultRows;
    private int minRows;
    private int maxRows;
    private int width;
    private String rowFill;    
    private String background;
    private String[] colors;
    
    @Override
    public void init() {
        ServletConfig sc = this.getServletConfig();
        final String defaultRowCount = sc.getInitParameter("rows.default");
        final String minRowCount     = sc.getInitParameter("rows.min");
        final String maxRowCount     = sc.getInitParameter("rows.max");
        final String defaultWidth    = sc.getInitParameter("table.width");
        defaultRows = Integer.parseInt(defaultRowCount);
        minRows = Integer.parseInt(minRowCount);
        maxRows = Integer.parseInt(maxRowCount);
        width = Integer.parseInt(defaultWidth);
        rowFill = sc.getInitParameter("rows.fill");
        background = sc.getInitParameter("table.bg");
        colors = sc.getInitParameter("table.colors").split(",");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        // Deal with the table dimensions
        final String requestedRowCount = request.getParameter("rows");
        int dimension = defaultRows;
        try {
            int requestedDimension = Integer.parseInt(requestedRowCount);
            if (requestedDimension >= minRows && requestedDimension <= maxRows)
                dimension = requestedDimension;
        } catch (NullPointerException | NumberFormatException e) {}
        
        // Deal with a fill change
        String requestedFill = request.getParameter("fill");
        if (requestedFill == null || requestedFill.length() < 1 || requestedFill.length() > rowFill.length())
            requestedFill = rowFill;
        
        // Deal with a background color change
        String bgcolor = request.getParameter("bg");
        if (bgcolor == null || bgcolor.length() != 6)
            bgcolor = background;
        
        // Deal with a table width change
        final String tableWidth = request.getParameter("width");
        int requestedWidth = width;
        try {
            requestedWidth = Integer.parseInt(tableWidth);
        } catch (NullPointerException | NumberFormatException e) {}
        
        StringBuilder output = new StringBuilder(1024);
        final String sizeMsg = "A " + dimension + "-Row Table";
        output
                .append("<!DOCTYPE html>\n")
                .append("<html>\n")
                .append("\t<head>\n")
                .append("\t\t<title>").append(sizeMsg).append("</title>\n")
                .append("\t</head>\n")
                .append("\t<body bgcolor=\"").append(bgcolor).append("\">\n")
                .append("\t\t<h1>").append(sizeMsg).append("</h1>\n")
                .append("\t\t<table width=\"").append(requestedWidth).append("%\" border=\"1\">\n");
        
        for (int n = 1; n <= dimension; n++)
            output.append(tableRow(n, dimension, requestedFill));
        
        output
                .append("\t\t</table>\n")
                .append("\t</body>\n")
                .append("</html>\n");
        
        response.setContentType("text/html");
        response.getWriter().append(output);
        
    }
    
    private String tableRow(int row, int dimension, String fill) {
        StringBuilder output = new StringBuilder(512);
        output.append("\t\t\t<tr>\n");
        for (int n = 1; n <= row; n++)
            output.append(coloredCell(fill));
        for (int n = dimension; n > row; n--)
            output.append(emptyCell(fill));
        output.append("\t\t\t</tr>\n");
        return output.toString();
    }
    
    private String coloredCell(String fill) {
        String color = colors[(int)(Math.random() * colors.length)];
        return String.format("\t\t\t\t<td bgcolor=\"%s\">%s</td>\n", color, fill);
    }
    
    private String emptyCell(String fill) {
        return String.format("\t\t\t\t<td>%s</td>\n", fill);
    }

}
