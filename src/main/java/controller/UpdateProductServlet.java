package controller;

import businesslayer.ProductsBusinessLogic;
import model.Products;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateProductServlet", urlPatterns = {"/UpdateProductServlet"})
public class UpdateProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int productID = Integer.parseInt(request.getParameter("productID"));
            ProductsBusinessLogic productBL = new ProductsBusinessLogic();
            Products productsById = productBL.getProductsById(productID);
            request.setAttribute("productsById", productsById);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/UpdateProduct.jsp");
            dispatcher.forward(request, response);
        } catch (NumberFormatException e) {
            // Handle number format exception
            provideFeedback(response, "Invalid numeric input. Please ensure all numeric fields are correctly formatted.");
        } catch (Exception e) {
            // Handle general exceptions
            provideFeedback(response, "Error adding product: " + e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    private void provideFeedback(HttpServletResponse response, String message) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<script type=\"text/javascript\">");
        response.getWriter().println("alert('" + message.replace("'", "\\'") + "');");
        response.getWriter().println("window.history.back();");
        response.getWriter().println("</script>");
    }


}