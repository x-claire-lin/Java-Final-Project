package controller;

import businesslayer.ProductsBusinessLogic;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Yongxing Lian
 */
@WebServlet(name = "DonationViewUpdate", urlPatterns = {"/DonationViewUpdate"})
public class DonationViewUpdate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/DonationViewServlet");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            double amount = Double.parseDouble(request.getParameter("amount"));
            ProductsBusinessLogic pbl = new ProductsBusinessLogic();

            pbl.updateDonation(id, amount);

            doGet(request, response);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}