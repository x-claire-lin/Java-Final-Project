package controller;

import businesslayer.UserService;
import businesslayer.UserSubscriptionService;
import model.User;
import model.UserSubscription;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ydx22
 */
@WebServlet(name = "SubscriptionAddServlet", urlPatterns = {"/SubscriptionAddServlet"})
public class SubscriptionAddServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/SubscriptionServlet");
            dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         UserSubscriptionService subscriptionLogic = new UserSubscriptionService();
         ArrayList<UserSubscription> subscription = null;
         try {
            //int userID = Integer.parseInt(request.getParameter("userID"));
            HttpSession session = request.getSession(false);
            int id = (int) session.getAttribute("userID");

            String productType = request.getParameter("productType");
            
            //check subscription exist.
            boolean isExist = false;
            try {
                // Assuming recipientID 6 is hardcoded, you may need to retrieve it from request parameters
                subscription =  subscriptionLogic.getUserSubscription(id);
                for (UserSubscription s : subscription) {
                    if (s.getProductType().equals(productType)) {
                       isExist = true;
                    }
                }
            
            } 
            catch (SQLException ex){}
            
            if (!isExist){
                String city = "*****";
                UserSubscriptionService usmbl = new UserSubscriptionService();
                UserSubscription subs = new UserSubscription();
                                                
                //get user city;
                UserService userLogic = new UserService();
                List<User> users = userLogic.getAllUsers();
                for (User u : users) {
                    if (u.getUserID() == id) {
                       city = u.getUserCity();
                    }
                }
                subs.setUserID(id);
                subs.setProductType(productType);
                subs.setUserCity(city);
                usmbl.addUserSubscription(subs);
            }
            doGet(request, response);

         } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
        } 
        catch (SQLException ex) {
            Logger.getLogger(SubscriptionAddServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}