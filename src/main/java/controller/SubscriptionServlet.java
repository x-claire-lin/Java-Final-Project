package controller;

import businesslayer.ProductTypeService;
import businesslayer.UserSubscriptionService;
import model.ProductTypes;
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

/**
 * Servlet implementation class SubscriptionServlet
 *
 * This servlet handles the retrieval and display of user subscriptions and available
 * product types. It processes both GET and POST requests to gather information
 * related to the user's subscriptions and available product types, then forwards
 * this data to the Subscription JSP page for display.
 *
 * The servlet interacts with the UserSubscriptionService to retrieve the user's
 * subscriptions and with the ProductTypeService to retrieve the available product types.
 *
 * @author  Yongxing Lian
 */
@WebServlet(name = "SubscriptionServlet", urlPatterns = {"/SubscriptionServlet"})
public class SubscriptionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * Retrieves the user's subscriptions and available product types, then forwards
     * the data to the Subscription JSP page for display.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        int id = (int) session.getAttribute("userID");

        UserSubscriptionService subscriptionLogic = new UserSubscriptionService();
        ArrayList<UserSubscription> subscription = null;

        try {
            subscription = subscriptionLogic.getUserSubscription(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        request.setAttribute("subscription", subscription);

        ProductTypeService productTypeLogic = new ProductTypeService();
        ArrayList<ProductTypes> productTypes = null;

        try {
            productTypes = productTypeLogic.getAllProductTypes();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        request.setAttribute("productTypes", productTypes);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/Subscription.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     * Delegates the request processing to the <code>processRequest</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * Delegates the request processing to the <code>processRequest</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing a short description of the servlet's functionality
     */
    @Override
    public String getServletInfo() {
        return "Servlet for managing and displaying user subscriptions and available product types";
    }

}