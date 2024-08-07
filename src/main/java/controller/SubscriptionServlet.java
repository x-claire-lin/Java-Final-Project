package controller;

import businesslayer.ProductTypesBusinessLogic;
import businesslayer.UserSubscriptionBusinessLogic;
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
 *
 * @author Yongxing Lian
 */
@WebServlet(name = "SubscriptionServlet", urlPatterns = {"/SubscriptionServlet"})
public class SubscriptionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userID = 7;
        UserSubscriptionBusinessLogic subscriptionLogic = new UserSubscriptionBusinessLogic();
        ArrayList<UserSubscription> subscription = null;
        HttpSession session = request.getSession(false);
        int id = (int) session.getAttribute("userID");
        String username = (String) session.getAttribute("username");

        try {
            // Assuming recipientID 6 is hardcoded, you may need to retrieve it from request parameters
            subscription =  subscriptionLogic.getUserSubscription(id);
        } catch (SQLException ex) {
        }
        request.setAttribute("userID", "testid");
        request.setAttribute("subscription", subscription);
        ProductTypesBusinessLogic productTypeLogic = new ProductTypesBusinessLogic();
        ArrayList<ProductTypes>  productTypes = null;
        try {
            // Assuming recipientID 6 is hardcoded, you may need to retrieve it from request parameters
            productTypes = productTypeLogic.getAllProductTypes();
        } catch (SQLException ex) {
        }
        request.setAttribute("productTypes", productTypes);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/Subscription.jsp");
        dispatcher.forward(request, response);
    }

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


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}