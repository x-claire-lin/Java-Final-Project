package controller;

import businesslayer.ProductService;
import model.Products;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

/**
 * Servlet implementation class ProductManagementServlet
 * <p>
 * This servlet handles the addition of new products to the system. It processes
 * POST requests to collect product information from the request, creates a new
 * Products object, and delegates the addition of the product to the ProductService.
 * <p>
 * After successful product addition, the user is redirected to the surplusProducts.jsp
 * page. If any errors occur during the process, appropriate feedback is provided to
 * the user through an alert message.
 * <p>
 * This servlet expects various product details, including the product name, sale price,
 * discount price, inventory amount, discount amount, donation amount, product type,
 * surplus flag, expiry date, and the user's location, to be submitted via the request.
 *
 * @author Yongxing Lian
 */
@WebServlet(name = "ProductManagementServlet", urlPatterns = {"/ProductManagementServlet"})
public class ProductManagementServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     * Collects product details from the request, creates a Products object, and
     * adds the product to the system using the ProductService.
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
                    expiryDate,
                    location,
                    null
            );

            ProductService productService = new ProductService();
            productService.addProduct(product);

            response.sendRedirect("views/surplusProducts.jsp");

        } catch (NumberFormatException e) {
            provideFeedback(response, "Invalid numeric input. Please ensure all numeric fields are correctly formatted.");
        } catch (Exception e) {
            provideFeedback(response, "Error adding product: " + e.getMessage());
        }
    }

    /**
     * Provides feedback to the user by displaying an alert with the provided message.
     * This method is called when an error occurs during the product addition process.
     *
     * @param response servlet response
     * @param message  the message to display in the alert
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