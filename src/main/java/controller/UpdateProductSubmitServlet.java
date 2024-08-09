package controller;

import businesslayer.ProductService;
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
import java.sql.Date;
import java.util.List;

/**
 * Servlet implementation class UpdateProductSubmitServlet
 *
 * This servlet handles the submission of updated product information.
 * It processes POST requests to update the product details in the database
 * and then redirects the user to the retailer view page, showing the updated list of surplus products.
 *
 * The servlet interacts with the ProductService to update the product in the database and
 * with the SurplusProductIdentifier to filter and retrieve the user's surplus products.
 *
 * @author Yongxing Lian
 */
@WebServlet(name = "UpdateProductSubmitServlet", urlPatterns = {"/UpdateProductSubmitServlet"})
public class UpdateProductSubmitServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     * Collects the updated product details from the request, updates the product
     * in the database, and forwards the user to the retailer view page displaying
     * the updated list of surplus products.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int productID = Integer.parseInt(request.getParameter("productID"));
            HttpSession session = request.getSession();
            int userID = (int) session.getAttribute("userID");
            String location = (String) session.getAttribute("location");
            String productName = request.getParameter("productName");
            double salePrice = Double.parseDouble(request.getParameter("salePrice"));
            double discountPrice = Double.parseDouble(request.getParameter("discountPrice"));
            double inventoryAmount = Double.parseDouble(request.getParameter("inventoryAmount"));
            double discountAmount = Double.parseDouble(request.getParameter("discountAmount"));
            double donationAmount = Double.parseDouble(request.getParameter("donationAmount"));
            String productType = request.getParameter("productType");
            String surplusFlag = request.getParameter("surplusFlag");
            Date expiryDate = Date.valueOf(request.getParameter("expiryDate"));

            Products product = new Products(
                    productName,
                    salePrice,
                    discountPrice,
                    inventoryAmount,
                    discountAmount,
                    donationAmount,
                    productType,
                    surplusFlag,
                    userID,
                    expiryDate, location, productID);

            ProductService productService = new ProductService();
            productService.updateProduct(product);

            SurplusProductIdentifier surplusProductIdentifier = new SurplusProductIdentifier();
            List<Products> surplusProducts = surplusProductIdentifier.filterProductsByUserId(userID);
            request.setAttribute("products", surplusProducts);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/retailer.jsp");
            dispatcher.forward(request, response);

        } catch (NumberFormatException e) {
            provideFeedback(response, "Invalid numeric input. Please ensure all numeric fields are correctly formatted.");
        } catch (Exception e) {
            provideFeedback(response, "Error updating product: " + e.getMessage());
        }
    }

    /**
     * Provides feedback to the user via a JavaScript alert and then redirects
     * back to the previous page, preserving the form input.
     *
     * @param response servlet response
     * @param message  the feedback message to display
     * @throws IOException if an I/O error occurs
     */
    private void provideFeedback(HttpServletResponse response, String message) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<script type=\"text/javascript\">");
        response.getWriter().println("alert('" + message.replace("'", "\\'") + "');");
        response.getWriter().println("window.history.back();");
        response.getWriter().println("</script>");
    }
}