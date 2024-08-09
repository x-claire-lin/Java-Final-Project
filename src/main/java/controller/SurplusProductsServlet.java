package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class SurplusProductsServlet
 *
 * This servlet handles requests to display the surplus products page. It processes
 * GET requests and forwards the request to the surplusProducts.jsp page for display.
 *
 * The servlet does not perform any business logic itself but simply routes the request
 * to the appropriate JSP page for rendering the surplus products view.
 *
 * @author Yongxing Lian
 */
@WebServlet(name = "SurplusProductsServlet", urlPatterns = {"/SurplusProductsServlet"})
public class SurplusProductsServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * Forwards the request to the surplusProducts.jsp page for display.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("views/surplusProducts.jsp").forward(request, response);
    }
}