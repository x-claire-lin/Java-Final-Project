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
 * Servlet implementation class DonationViewUpdate
 *
 * This servlet handles the update of donation information for products. It processes
 * both GET and POST requests, where the POST request updates the donation amount
 * based on the provided product ID, and the GET request forwards the user to the
 * DonationViewServlet for further processing.
 *
 * The servlet interacts with the ProductService to perform the donation update based
 * on the provided product ID and donation amount.
 *
 * @author Yongxing Lian
 */
@WebServlet(name = "DonationViewUpdate", urlPatterns = {"/DonationViewUpdate"})
public class DonationViewUpdate extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * Forwards the request to the DonationViewServlet.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/DonationViewServlet");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * Updates the donation information for a product based on the provided ID and amount.
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
            pbl.updateDonation(id, amount);

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
        return "Servlet for updating donation information for products";
    }

}