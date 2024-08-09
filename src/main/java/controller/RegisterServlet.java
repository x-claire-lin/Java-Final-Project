package controller;

import businesslayer.UserService;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet implementation class RegisterServlet
 *
 * This servlet handles user registration by processing HTTP POST requests.
 * It collects user information from the request, validates the data, checks
 * if the user already exists, and if not, adds the new user to the system.
 *
 * If the user already exists, or if the provided data is incomplete, the servlet
 * responds with an appropriate error message.
 *
 * @author Yongxing lian
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * Currently, this method does not perform any actions.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // No action
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * Collects user details from the request and attempts to register the user.
     * If the registration is successful, the user is redirected to the login page.
     * If the user already exists or if any data is missing, an error message is displayed.
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
            addUser(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing a short description of the servlet's functionality
     */
    @Override
    public String getServletInfo() {
        return "Servlet for handling user registration";
    }

    /**
     * Adds a new user to the system based on the data provided in the request.
     * If the user already exists or if any required data is missing, an error message is displayed.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     * @throws SQLException     if a database access error occurs
     */
    private void addUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        UserService US = new UserService();
        String userName = request.getParameter("username");
        String userEmail = request.getParameter("email");
        String userPhoneNumber = request.getParameter("phonenumber");
        String userPassword = request.getParameter("password");
        String userType = request.getParameter("role");
        String userCity = request.getParameter("usercity");

        if (userName.trim().length() != 0 && userEmail.trim().length() != 0 &&
                userPhoneNumber.trim().length() != 0 && userPassword.trim().length() != 0 &&
                userType.trim().length() != 0 && userCity.trim().length() != 0) {

            User user = US.getUserByEmail(userEmail);
            if (user == null) {
                user = new User();
                user.setUserName(userName);
                user.setUserEmail(userEmail);
                user.setUserPhoneNumber(userPhoneNumber);
                user.setUserPassword(userPassword);
                user.setUserType(userType);
                user.setUserCity(userCity);

                US.addUser(user);
                response.sendRedirect("views/login.jsp");
            } else {
                displayMessage(response, "The email " + request.getParameter("email") + " has already exists.");
            }
        } else {
            displayMessage(response, "Please filled out all fields.");
        }
    }

    /**
     * Displays a message to the user in the form of an HTML response.
     *
     * @param response servlet response
     * @param message  the message to display
     * @throws IOException if an I/O error occurs
     */
    private void displayMessage(HttpServletResponse response, String message) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Error</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>" + message + "</h2>");
            out.println("<a href='views/register.jsp'><button>Back, try again.</button></a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}