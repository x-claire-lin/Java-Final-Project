package controller;

import dataaccesslayer.SurplusProductIdentifier;
import model.Products;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class RetailerViewServlet
 *
 * This servlet is responsible for displaying the retailer's view of surplus products.
 * It processes both GET and POST requests to retrieve surplus products associated with
 * the logged-in retailer and forwards this information to the retailer JSP page for display.
 *
 * The servlet interacts with the SurplusProductIdentifier to filter and identify surplus
 * products for the retailer based on their user ID, which is stored in the session.
 *
 * @author Yongxing Lian
 */
@WebServlet(name = "RetailerViewServlet", urlPatterns = {"/RetailerViewServlet"})
public class RetailerViewServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * Retrieves the list of surplus products for the logged-in retailer and forwards
     * the data to the retailer JSP page for display.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        int userID = (int) session.getAttribute("userID");
        SurplusProductIdentifier surplusProductIdentifier = new SurplusProductIdentifier();
        List<Products> surplusProducts = surplusProductIdentifier.filterProductsByUserId(userID);
        request.setAttribute("products", surplusProducts);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/retailer.jsp");
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
        return "Servlet for displaying surplus products to retailers based on their user ID";
    }

}