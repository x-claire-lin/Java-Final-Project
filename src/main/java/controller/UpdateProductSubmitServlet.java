package controller;

import businesslayer.ProductsBusinessLogic;
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

@WebServlet(name = "UpdateProductSubmitServlet", urlPatterns = {"/UpdateProductSubmitServlet"})
public class UpdateProductSubmitServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            int productID = Integer.parseInt(request.getParameter("productID"));
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
                expiryDate, location, productID);

            ProductsBusinessLogic productBL = new ProductsBusinessLogic();
            productBL.updateProduct(product);

            SurplusProductIdentifier surplusProductIdentifier = new SurplusProductIdentifier();
            List<Products> surplusProducts = surplusProductIdentifier.filterProductsByUserId(userID);
            request.setAttribute("products", surplusProducts);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/retailer.jsp");
            dispatcher.forward(request, response);

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
