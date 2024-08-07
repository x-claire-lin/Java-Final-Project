package controller;

import businesslayer.UserBusinessLogic;
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
 *
 * @author Yongxing Lian
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    
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
        try {
            addUser(request, response);                        
        } 
        catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
    }

    
    private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        UserBusinessLogic UB=new UserBusinessLogic();
        String userName = request.getParameter("username");
        String userEmail = request.getParameter("email");
        String userPhoneNumber = request.getParameter("phonenumber");
        String userPassword = request.getParameter("password");
        String userType = request.getParameter("role");
        String userCity = request.getParameter("usercity");
        if(userName.trim().length()!=0 && userEmail.trim().length()!=0 && userPhoneNumber.trim().length()!=0 && userPassword.trim().length()!=0 
                && userType.trim().length()!=0 && userCity.trim().length()!=0){
            User user=UB.getUesrByEmail(userEmail);
            if(user == null){
                user=new User();
                user.setUserName(userName);
                user.setUserEmail(userEmail);
                user.setUserPhoneNumber(userPhoneNumber);
                user.setUserPassword(userPassword);
                user.setUserType(userType);
                user.setUserCity(userCity);

                UB.addUser(user);
                response.sendRedirect("views/login.jsp");
            }
            else{
                response.setContentType("text/html;charset=UTF-8");
                try ( PrintWriter out = response.getWriter()) {
                   out.println("<!DOCTYPE html>");
                   out.println("<html>");
                   out.println("<head>");
                   out.println("<title>User Exists</title>");            
                   out.println("</head>");
                   out.println("<body>");
                   out.println("<h2>The user emali " + request.getParameter("email") + " has already existed</h2>");
                   out.println("<a href='views/register.jsp'><button>Back, enter again.</button></a>");
                   out.println("</body>");
                   out.println("</html>");
                 }
            }
        }
        else{
            response.setContentType("text/html;charset=UTF-8");
            try ( PrintWriter out = response.getWriter()) {
               out.println("<!DOCTYPE html>");
               out.println("<html>");
               out.println("<head>");
               out.println("<title>Please enter all items.</title>");            
               out.println("</head>");
               out.println("<body>");
               out.println("<h2>The items can not be empty.</h2>");
               out.println("<a href='views/register.jsp'><button>Back, enter again.</button></a>");
               out.println("</body>");
               out.println("</html>");
             }
        }
   }     
}