package controller;

import businesslayer.AuthorityService;
import businesslayer.UserService;
import dataaccesslayer.DiscountDaoImpl;
import model.Author;
import model.DiscountView;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet implementation class PurchaseServlet
 *
 * This servlet handles the retrieval and display of discounted products available for purchase.
 * It processes both GET and POST requests to fetch discount information from the database
 * and forwards the data to the purchase JSP page for display.
 *
 * The servlet interacts with DiscountDaoImpl to retrieve a list of discounted products
 * and sets this list as a request attribute before forwarding the request to the appropriate
 * JSP page for rendering. It also interacts with UserService to retrieve user information.
 *
 * @author Yongxing Lian
 */
@WebServlet(name = "PurchaseServlet", urlPatterns = {"/PurchaseServlet"})
public class PurchaseServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * Retrieves discounted products and user information, then forwards the data to
     * the purchase JSP page.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserService US = new UserService();
        DiscountDaoImpl discount = new DiscountDaoImpl();
        List<User> users = null;
        ArrayList<DiscountView> discountarray = null;

        try {
            discountarray = discount.getAllDiscountProducts();
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            users = US.getAllUsers();
        } catch (SQLException ex) {
            log(ex.getMessage());
        }

        request.setAttribute("dis", discountarray);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/purchase.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * Retrieves discounted products from the database and forwards the data to
     * the purchase JSP page.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DiscountDaoImpl discount = new DiscountDaoImpl();
        ArrayList<DiscountView> discountarray = null;

        try {
            discountarray = discount.getAllDiscountProducts();
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("dis", discountarray);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/purchase.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing a short description of the servlet's functionality
     */
    @Override
    public String getServletInfo() {
        return "Servlet for managing the retrieval and display of discounted products for purchase";
    }

    /**
     * Adds a new author to the system.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    private void addAuthor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AuthorityService authorBusinessLogic = new AuthorityService();
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorBusinessLogic.addAuthor(author);
    }

    /**
     * Checks if a user with the provided email and password exists in the system.
     *
     * @param request  servlet request
     * @param response servlet response
     * @return true if the user exists and the password matches, false otherwise
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     * @throws SQLException     if a database access error occurs
     */
    private Boolean checkUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        UserService US = new UserService();
        Boolean isExist = false;
        String email = request.getParameter("Email");
        String password = request.getParameter("password");
        User user = US.getUserByEmail(email);
        if (user != null && user.getUserPassword().equals(password)) {
            isExist = true;
        }
        return isExist;
    }

}