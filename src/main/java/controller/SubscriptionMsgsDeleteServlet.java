package controller;

import businesslayer.SubscriptionMsgService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class SubscriptionMsgsDeleteServlet
 *
 * This servlet handles the deletion of subscription messages. It processes POST requests
 * to delete a subscription message based on the provided message ID, and then forwards
 * the user to the SubscriptionMsgsServlet to display the updated list of subscription messages.
 *
 * The servlet interacts with the SubscriptionMsgService to manage the deletion of messages.
 *
 * @author Yongxing Lian
 */
@WebServlet(name = "SubscriptionMsgsDeleteServlet", urlPatterns = {"/SubscriptionMsgsDeleteServlet"})
public class SubscriptionMsgsDeleteServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * Forwards the request to the SubscriptionMsgsServlet to display the list of
     * subscription messages after a deletion operation.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/SubscriptionMsgsServlet");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * Deletes a subscription message based on the provided message ID.
     * After the deletion, the request is forwarded to the SubscriptionMsgsServlet
     * to display the updated list of subscription messages.
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
            SubscriptionMsgService sms = new SubscriptionMsgService();
            sms.deleteSubscriptionMsg(id);
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
        return "Servlet for deleting subscription messages and forwarding to SubscriptionMsgsServlet";
    }

}