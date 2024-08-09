package controller;

import businesslayer.ProductService;
import model.Products;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class UpdateProductServlet
 *
 * This servlet handles the retrieval and updating of product information.
 * It processes GET requests to retrieve product details by product ID and
 * forwards the data to the UpdateProduct.jsp page for display. It also handles
 * POST requests by delegating them to the GET method to reuse the logic.
 *
 * The servlet interacts with the ProductService to fetch the product details
 * based on the provided product ID.
 *
 * @author Yongxing Lian
 */
@WebServlet(name = "UpdateProductServlet", urlPatterns = {"/UpdateProductServlet"})
public class UpdateProductServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * Retrieves product details by product ID and forwards the data to the
     * UpdateProduct.jsp page for display.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int productID = Integer.parseInt(request.getParameter("productID"));
            ProductService productService = new ProductService();
            Products productsById = productService.getProductsById(productID);
            request.setAttribute("productsById", productsById);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/UpdateProduct.jsp");
            dispatcher.forward(request, response);
        } catch (NumberFormatException e) {
            // Handle number format exception
            provideFeedback(response, "Invalid numeric input. Please ensure all numeric fields are correctly formatted.");
        } catch (Exception e) {
            // Handle general exceptions
            provideFeedback(response, "Error retrieving product: " + e.getMessage());
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * Delegates the request processing to the <code>doGet</code> method to
     * reuse the logic for retrieving product details.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
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