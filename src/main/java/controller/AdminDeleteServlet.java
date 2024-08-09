package controller;

import businesslayer.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class AdminDeleteServlet
 *
 * This servlet handles the deletion of users by the admin. It processes the
 * deletion request and forwards the user to the AdminServlet for further processing.
 *
 * The servlet supports both GET and POST methods. The GET method is used to
 * forward the request to the AdminServlet, while the POST method handles the
 * deletion of a user based on the provided user ID.
 *
 * @author Yongxing Lian
 */
@WebServlet(name = "AdminDeleteServlet", urlPatterns = {"/AdminDeleteServlet"})
public class AdminDeleteServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method by forwarding the request to
     * the AdminServlet.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminServlet");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method by deleting a user based on the
     * provided user ID. If the ID is invalid, it sends a 400 Bad Request error.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            UserService admin = new UserService();
            admin.deleteUserByID(id);
            doGet(request, response);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing a short description of the servlet
     */
    @Override
    public String getServletInfo() {
        return "Servlet for handling admin user deletion requests";
    }

}