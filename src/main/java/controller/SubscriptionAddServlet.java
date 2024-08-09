package controller;

import businesslayer.UserService;
import businesslayer.UserSubscriptionService;
import model.User;
import model.UserSubscription;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet implementation class SubscriptionAddServlet
 *
 * This servlet handles the addition of new product subscriptions for users.
 * It processes POST requests to add a subscription for a user if it doesn't
 * already exist. After processing, it forwards the user to the SubscriptionServlet
 * to display the updated list of subscriptions.
 *
 * The servlet interacts with the UserSubscriptionService to manage subscriptions
 * and with the UserService to retrieve user information such as the city.
 *
 * @author Yongxing Lian
 */
@WebServlet(name = "SubscriptionAddServlet", urlPatterns = {"/SubscriptionAddServlet"})
public class SubscriptionAddServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * Forwards the request to the SubscriptionServlet to display the list of
     * subscriptions after processing.
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
     * Adds a new subscription for the user if it does not already exist.
     * After adding the subscription, the request is forwarded to the SubscriptionServlet
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

        UserSubscriptionService subscriptionLogic = new UserSubscriptionService();
        ArrayList<UserSubscription> subscription = null;
        try {
            HttpSession session = request.getSession(false);
            int id = (int) session.getAttribute("userID");
            String productType = request.getParameter("productType");
            boolean isExist = false;

            try {
                subscription = subscriptionLogic.getUserSubscription(id);
                for (UserSubscription s : subscription) {
                    if (s.getProductType().equals(productType)) {
                        isExist = true;
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(SubscriptionAddServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (!isExist) {
                String city = "*****";
                UserSubscriptionService uss = new UserSubscriptionService();
                UserSubscription subs = new UserSubscription();

                UserService userLogic = new UserService();
                List<User> users = userLogic.getAllUsers();
                for (User u : users) {
                    if (u.getUserID() == id) {
                        city = u.getUserCity();
                    }
                }

                subs.setUserID(id);
                subs.setProductType(productType);
                subs.setUserCity(city);
                uss.addUserSubscription(subs);
            }
            doGet(request, response);

        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
        } catch (SQLException ex) {
            Logger.getLogger(SubscriptionAddServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing a short description of the servlet's functionality
     */
    @Override
    public String getServletInfo() {
        return "Servlet for adding user product subscriptions if they do not already exist";
    }

}