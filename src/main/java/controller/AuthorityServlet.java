package controller;

import businesslayer.AuthorityService;
import businesslayer.UserService;
import model.Author;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This servlet manages user authentication and author management tasks. It handles
 * both GET and POST requests to verify user credentials and manage author data.
 *
 * The servlet interacts with the UserService and AuthorityService to retrieve user
 * information and manage authors. If a user's credentials are verified successfully,
 * they are granted access to author management functionalities.
 *
 * @author Yongxing Lian
 */
@WebServlet(name = "AuthorityServlet", urlPatterns = {"/AuthorityServlet"})
public class AuthorityServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * Retrieves a list of users and forwards the request to the authors JSP page.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("msg", "Password is incorrect");
        UserService US = new UserService();
        List<User> users = null;

        try {
            users = US.getAllUsers();
        } catch (SQLException ex) {
            log(ex.getMessage());
        }
        request.setAttribute("users", users);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/authors.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * Verifies user credentials and, if valid, delegates to the <code>doGet</code> method.
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
            if (checkUser(request, response)) {
                doGet(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorityServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing a short description of the servlet's functionality
     */
    @Override
    public String getServletInfo() {
        return "Servlet for user authentication and author management";
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
     * Verifies user credentials.
     *
     * @param request  servlet request
     * @param response servlet response
     * @return true if the user's email and password are valid, false otherwise
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