package controller;

import businesslayer.ProductsBusinessLogic;
import model.Products;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "ProductManagementServlet", urlPatterns = {"/ProductManagementServlet"})
public class ProductManagementServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            // Directly using a default userID = 2 if not found in session or request
//            int userID = 2; // Default userID
            HttpSession session=request.getSession();
            int userID =(int)session.getAttribute("userID");
            String location =(String)session.getAttribute("location");

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
                expiryDate, location, null);

            ProductsBusinessLogic productBL = new ProductsBusinessLogic();
            productBL.addProduct(product);

            // Redirect to surplusProducts.jsp after successful addition
            response.sendRedirect("views/surplusProducts.jsp");

        } catch (NumberFormatException e) {
            // Handle number format exception
            provideFeedback(response, "Invalid numeric input. Please ensure all numeric fields are correctly formatted.");
        } catch (Exception e) {
            // Handle general exceptions
            provideFeedback(response, "Error adding product: " + e.getMessage());
        }
    }

    // Method to provide feedback to the user via a JavaScript alert and then redirect back to the form
    private void provideFeedback(HttpServletResponse response, String message) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<script type=\"text/javascript\">");
        response.getWriter().println("alert('" + message.replace("'", "\\'") + "');"); // Escape single quotes in the message
        response.getWriter().println("window.history.back();"); // Go back to the previous page, preserving form input
        response.getWriter().println("</script>");
    }


}
