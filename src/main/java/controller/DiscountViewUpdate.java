package controller;

import businesslayer.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class DiscountViewUpdate
 *
 * This servlet handles the update of discount information for products. It processes
 * both GET and POST requests, where the POST request updates the discount and the GET
 * request forwards the user to the DiscountViewServlet for further processing.
 *
 * The servlet interacts with the ProductService to perform the discount update based
 * on the provided product ID and discount amount.
 *
 * @author Yongxing Lian
 */
@WebServlet(name = "DiscountViewUpdate", urlPatterns = {"/DiscountViewUpdate"})
public class DiscountViewUpdate extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * Forwards the request to the DiscountViewServlet.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/DiscountViewServlet");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * Updates the discount information for a product based on the provided ID and amount.
     * If the ID or amount is invalid, a 400 Bad Request error is returned.
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
            double amount = Double.parseDouble(request.getParameter("amount"));

            ProductService pbl = new ProductService();
            pbl.updateDiscount(id, amount);

            doGet(request, response);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID or amount format");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing a short description of the servlet's functionality
     */
    @Override
    public String getServletInfo() {
        return "Servlet for updating discount information for products";
    }

}