package controller;

import businesslayer.ProductService;
import businesslayer.UserSubscriptionService;
import model.Products;
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
import java.util.stream.Collectors;

/**
 * Servlet implementation class SubscriptionMsgsServlet
 * <p>
 * This servlet handles the retrieval and display of products that match the
 * user's subscriptions. It processes both GET and POST requests to find products
 * that are discounted, not expired, and located in the same city as the user.
 * <p>
 * The servlet interacts with the UserSubscriptionService to retrieve the user's
 * subscriptions and with the ProductService to filter and retrieve products that
 * match the user's subscription criteria.
 *
 * @author Yongxing Lian
 */
@WebServlet(name = "SubscriptionMsgsServlet", urlPatterns = {"/SubscriptionMsgsServlet"})
public class SubscriptionMsgsServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * Retrieves the list of products that match the user's subscription criteria and
     * forwards the data to the subscriptionMsg JSP page for display.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     * @throws SQLException     if a database access error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        HttpSession session = request.getSession();
        int userID = (int) session.getAttribute("userID");
        String location = (String) session.getAttribute("location");

        UserSubscriptionService subscriptionService = new UserSubscriptionService();
        List<UserSubscription> subscriptions = subscriptionService.getUserSubscriptionList(userID, location);

        ProductService productService = new ProductService();
        if (subscriptions != null && subscriptions.size() > 0) {
            List<String> subscriptionTypes = subscriptions.stream()
                    .map(UserSubscription::getProductType)
                    .collect(Collectors.toList());

            List<Products> productsList = productService.getAllProductsByCondition(subscriptionTypes, location);
            List<Products> filteredProducts = productsList.stream()
                    .filter(product -> product.getUserCity().equals(location))
                    .collect(Collectors.toList());

            request.setAttribute("productsList", filteredProducts);
        } else {
            request.setAttribute("productsList", new ArrayList<>());
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/subscriptionMsg.jsp");
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
        try {
            processRequest(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing a short description of the servlet's functionality
     */
    @Override
    public String getServletInfo() {
        return "Servlet for displaying products that match the user's subscription criteria";
    }
}