package edu.acc.java3.craps;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Game extends HttpServlet {
    
    private String viewDir;
    private String viewType;
    private String actionDefault;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getParameter("action"), destination = actionDefault;
        if (action == null || action.length() == 0) action = actionDefault;
        switch (action) {
            default:
            case "start": destination = start(request); break;
            case "play": destination = play(request); break;
            case "logout": destination = logout(request); break;
        }
        String view = viewDir + '/' + destination + viewType;
        request.getRequestDispatcher(view).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public void init() {
        ServletContext ctx = this.getServletContext();
        viewDir = ctx.getInitParameter("view.dir");
        viewType = ctx.getInitParameter("view.type");
        actionDefault = ctx.getInitParameter("action.default");
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        // REDIRECT IS CANONICAL
        return start(request);
    }

    @SuppressWarnings("unchecked")
    private String start(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Player player = (Player)session.getAttribute("player");
        if (player == null) {
            player = new Player();
            session.setAttribute("player", player);
        }
        player.start();
        return "game";
    }

    @SuppressWarnings("unchecked")
    private String play(HttpServletRequest request) {
        if (request.getMethod().equalsIgnoreCase("GET")) return "game";
        Player player = (Player)request.getSession().getAttribute("player");
        String betText = request.getParameter("bet");
        if (betText == null || betText.length() == 0) betText = "0";
        try {
            int bet = Integer.parseInt(betText);
            player.updateBet(bet);
            player.play();
            if (player.getState() == Player.WIN)
                request.setAttribute("status", "win");
            else if (player.getState() == Player.LOSE)
                request.setAttribute("status", "lose");
        }
        catch (NumberFormatException nfe) {
            request.setAttribute("flash", "Bet must be a non-negative whole number");
        }
        catch (IllegalArgumentException iae) {
            request.setAttribute("flash", iae.getMessage());
        }
        return "game";
    }

}
