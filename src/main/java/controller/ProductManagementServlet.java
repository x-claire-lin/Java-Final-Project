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

/**
 *
 * @author Yongxing Lian
 */
@WebServlet(name = "ProductManagementServlet", urlPatterns = {"/ProductManagementServlet"})
public class ProductManagementServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
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

            response.sendRedirect("views/surplusProducts.jsp");

        } catch (NumberFormatException e) {
            provideFeedback(response, "Invalid numeric input. Please ensure all numeric fields are correctly formatted.");
        } catch (Exception e) {
            provideFeedback(response, "Error adding product: " + e.getMessage());
        }
    }

    private void provideFeedback(HttpServletResponse response, String message) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<script type=\"text/javascript\">");
        response.getWriter().println("alert('" + message.replace("'", "\\'") + "');");
        response.getWriter().println("window.history.back();");
        response.getWriter().println("</script>");
    }


}