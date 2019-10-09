package edu.acc.java3.login;

import java.io.*;
import java.util.Set;
import javax.servlet.*;
import javax.servlet.http.*;


public class FrontController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getParameter("action"), destination = actionDefault;
        if (action == null) action = actionDefault;
        switch (action) {
            default:
            case "login": destination = login(request); break;
            case "content": destination = content(request); break;
            case "logout": destination = logout(request); break;
            case "treasure": destination = treasure(request); break;
        }
        
        String view;
        if (destination.startsWith(redirectTag)) {
            view = destination.substring(redirectTag.length());
            response.sendRedirect("main?action=" + view);
        }
        else {
            view = viewDir + '/' + destination + viewType;
            request.getRequestDispatcher(view).forward(request, response);
        }
    }
    
    private String login(HttpServletRequest request) {
        // Logged in users cannot get to the login screen
        if (request.getSession().getAttribute("user") != null)
            return "redirect:content";
        
        // get requests fetch the form to fill out
        if (request.getMethod().equalsIgnoreCase("GET"))
            return "login";
        
        // we get here for post requests - validate the form
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);
        Set<String> errors = UserValidator.validate(user);
        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
            return "login";
        }
        
        // form is valid so authenticate the user
        String validUsername = this.getServletContext().getInitParameter("validUsername");
        String validPassword = this.getServletContext().getInitParameter("validPassword");
        String validId = this.getServletContext().getInitParameter("validId");
        if (!UserAuthenticator.authenticate(user, validUsername, validPassword, validId)) {
            request.setAttribute("flash", "Access Denied");
            return "login";
        }
        
        // if we get here, user is legit so add to session and forward to honeypot
        request.getSession().setAttribute("user", user);
        return "content";
    }
    
    private String content(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") == null)
            return "redirect:login";
        else return "content";
    }
    
    private String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:login";
    }
    
    private String treasure(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") == null)
            return "redirect:login";
        String treasure = CandyVan.getRandomTreasure();
        request.setAttribute("treasure", treasure);
        return "treasure";
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    public void init() {
        ServletContext ctx = this.getServletContext();
        viewDir = ctx.getInitParameter("view.dir");
        viewType = ctx.getInitParameter("view.type");
        actionDefault = ctx.getInitParameter("action.default");
        redirectTag = ctx.getInitParameter("redirect.tag");
    }
    
    private String viewDir;
    private String viewType;
    private String actionDefault;
    private String redirectTag;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
