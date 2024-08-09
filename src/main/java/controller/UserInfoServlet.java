package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class UserInfoServlet
 *
 * This servlet handles requests to display user information. It processes
 * GET requests by forwarding the request to the `userInfo.jsp` page for display.
 * The POST method is currently not implemented but is provided for future use if needed.
 *
 * @author Yongxing Lian
 */
@WebServlet(name = "UserInfoServlet", urlPatterns = {"/UserInfoServlet"})
public class UserInfoServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * Forwards the request to the `userInfo.jsp` page to display user information.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/userInfo.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * Currently not implemented, but provided for future use if needed.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Not implemented
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing a short description of the servlet's functionality
     */
    @Override
    public String getServletInfo() {
        return "Servlet for displaying user information";
    }

}