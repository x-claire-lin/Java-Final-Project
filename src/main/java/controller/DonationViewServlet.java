package controller;

import businesslayer.DonationViewService;
import model.DonationView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Servlet implementation class DonationViewServlet
 * <p>
 * This servlet handles requests for viewing donation products. It processes both
 * GET and POST requests to fetch donation information from the database and
 * forwards the data to a JSP page for display.
 * <p>
 * The servlet interacts with the DonationViewService to retrieve a list of donated
 * products and sets this list as a request attribute before forwarding the request to
 * the appropriate JSP page for rendering.
 *
 * @author Yongxing Lian
 */
@WebServlet(name = "DonationViewServlet", urlPatterns = {"/DonationViewServlet"})
public class DonationViewServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * Retrieves all donation products from the database and forwards the data to the
     * donation JSP page.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DonationViewService donationview = new DonationViewService();
        ArrayList<DonationView> donations = null;

        try {
            donations = donationview.getAllDonationProducts();
        } catch (SQLException ex) {
            log(ex.getMessage());
        }

        request.setAttribute("donations", donations);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/donation.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     * Delegates to the <code>processRequest</code> method to handle the request.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * Delegates to the <code>processRequest</code> method to handle the request.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing a short description of the servlet's functionality
     */
    @Override
    public String getServletInfo() {
        return "Servlet for managing and displaying donation products";
    }

}