package controller;

import businesslayer.UserSubscriptionService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class SubscriptionDeleteServlet
 *
 * This servlet handles the deletion of user product subscriptions. It processes
 * POST requests to delete a subscription based on the provided subscription ID,
 * and then forwards the user to the SubscriptionServlet to display the updated
 * list of subscriptions.
 *
 * The servlet interacts with the UserSubscriptionService to manage the deletion
 * of subscriptions.
 *
 * @author Yongxing Lian
 */
@WebServlet(name = "SubscriptionDeleteServlet", urlPatterns = {"/SubscriptionDeleteServlet"})
public class SubscriptionDeleteServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * Forwards the request to the SubscriptionServlet to display the list of
     * subscriptions after a deletion operation.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/SubscriptionServlet");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * Deletes a user subscription based on the provided subscription ID.
     * After the deletion, the request is forwarded to the SubscriptionServlet
     * to display the updated list of subscriptions.
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
            UserSubscriptionService uss = new UserSubscriptionService();
            uss.deleteUserSubscription(id);
            doGet(request, response);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing a short description of the servlet's functionality
     */
    @Override
    public String getServletInfo() {
        return "Servlet for deleting user product subscriptions and forwarding to SubscriptionServlet";
    }

}